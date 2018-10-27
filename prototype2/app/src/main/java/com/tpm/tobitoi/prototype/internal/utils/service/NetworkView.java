package com.tpm.tobitoi.prototype.internal.utils.service;



import android.util.Log;

import com.tpm.tobitoi.prototype.internal.utils.ForbiddenException;

import java.io.IOException;


import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.tpm.tobitoi.prototype.internal.utils.ErrorUtil.getErrorResponse;
import static com.tpm.tobitoi.prototype.internal.utils.ErrorUtil.getForbiddenErrorCode;
import static com.tpm.tobitoi.prototype.internal.utils.ErrorUtil.getForbiddenErrorResponse;

public class NetworkView<T>  {

	private Action0 onShowProgressBar;

	private Action0 onHideProgressBar;

	private Action1<String> onShowError;

	private Action0 onConnectionError;

	private Action1<String> onShowForbiddenError;

	private Action0 onError;

	private Action1<T> onResponse;

	private Subscription mSubscription;

	public NetworkView(final Action0 onShowProgressBar, final Action0 onHideProgressBar,
			final Action1<String> onShowError, final Action0 onConnectionError,
			final Action1<String> onShowForbiddenError, final Action0 onError,
			final Action1<T> onResponse) {
		this.onShowProgressBar = onShowProgressBar;
		this.onHideProgressBar = onHideProgressBar;
		this.onShowError = onShowError;
		this.onConnectionError = onConnectionError;
		this.onShowForbiddenError = onShowForbiddenError;
		this.onError = onError;
		this.onResponse = onResponse;
	}

	public void callApi(Func0<Observable<Response<T>>> apiResult) {

		onShowProgressBar.call();

		setSafeUnsubscribe();

		mSubscription = apiResult
				.call()
				.flatMap(flatmapResponse())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.io())
				.subscribe(getSubscriber());

	}

	public void setSafeUnsubscribe() {
		if (null != mSubscription && !mSubscription.isUnsubscribed()) {
			mSubscription.unsubscribe();
		}
	}

	private Subscriber<T> getSubscriber() {
		return new Subscriber<T>() {

			@Override
			public void onCompleted() {
				onHideProgressBar.call();
			}

			@Override
			public void onError(final Throwable throwable) {
				onHideProgressBar.call();

				// Show error message based on error state
				if (throwable instanceof HttpException) {

					final HttpException httpException = (HttpException) throwable;
					final Response response = httpException.response();

					String result = null;
					try {
						result = String.valueOf(response.errorBody().source().readUtf8());
					} catch (IOException e) {
						e.printStackTrace();
					}

					if(!result.equals("[\"You're not authorized to perform this action.\"]")){
						final String errorMessage = getErrorResponse(throwable, "errors");
						onShowError.call(errorMessage);
					}
				} else if (throwable instanceof IOException) {
					onConnectionError.call();
				} else if (throwable instanceof ForbiddenException) {
					final int code = getForbiddenErrorCode(throwable);
					final String message = getForbiddenErrorResponse(throwable, "message");

					// Show error code and message
					Log.e(NetworkView.class.getSimpleName(), String.format("Response Code: %d", code));
					onShowForbiddenError.call(message);

					onError.call();
				}
			}

			@Override
			public void onNext(final T response) {
				if (null != response) {
					onResponse.call(response);
				}
			}
		};
	}

	private Func1<Response<T>, Observable<T>> flatmapResponse() {
		return new Func1<Response<T>, Observable<T>>() {
			@Override
			public Observable<T> call(final Response<T> response) {
				try {
					switch (response.code()) {
						case 200: {
							return Observable.just(response.body());
						}
						case 401: {
							return Observable.error(new HttpException(response));
						}
						case 403: {
							final ForbiddenException forbiddenException = new ForbiddenException(response);
							return Observable.error(forbiddenException);
						}
						case 406: {
							return Observable.error(new HttpException(response));
						}
						default: {
							return Observable.empty();
						}
					}
				} catch (Exception e) {
					return Observable.error(e);
				}
			}
		};
	}
}
