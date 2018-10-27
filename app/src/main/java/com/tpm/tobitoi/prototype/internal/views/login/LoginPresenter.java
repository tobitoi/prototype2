package com.tpm.tobitoi.prototype.internal.views.login;

import android.text.TextUtils;

import com.tpm.tobitoi.prototype.internal.data.local.RealmManagers;
import com.tpm.tobitoi.prototype.internal.data.local.pojo.User;
import com.tpm.tobitoi.prototype.internal.data.remote.IApi;
import com.tpm.tobitoi.prototype.internal.data.remote.request.LoginRequest;
import com.tpm.tobitoi.prototype.internal.data.remote.response.LoginResponse;
import com.tpm.tobitoi.prototype.internal.utils.Authentications;
import com.tpm.tobitoi.prototype.internal.utils.Reactives;
import com.tpm.tobitoi.prototype.internal.utils.validators.IValidator;
import com.tpm.tobitoi.prototype.internal.utils.validators.ValidatorFactory;
import com.tpm.tobitoi.prototype.internal.views.base.BasePresenter;
import com.tpm.tobitoi.prototype.internal.views.base.IPresenter;

import javax.inject.Inject;
import javax.inject.Named;


import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter implements IPresenter<LoginView> {
    private LoginView mView;
    private Subscription mSubscription;

    @Inject
    @Named("core")
    IApi mApi;

    @Inject
    RealmManagers mRealmManagers;

    @Inject
    ValidatorFactory mValidator;

    @Inject
    Authentications mAuthentications;

    @Inject
    Reactives mReactives;

    @Inject
    public LoginPresenter() {
    }

    @Override
    public void onAttach(final LoginView view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
        mReactives.setSafeUnsubscribe(mSubscription);
    }

    public void validateLogin(final String username, final String password) {
        // Get email address pattern


        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            getView().onValidationFailed();
        } else {
            getView().onDoLogin(username, password);
        }
    }

    public void doLogin(final String username, final String password) {
        // Show progress dialog
        getView().onShowProgressDialog();

        // Post login API
        mReactives.setSafeUnsubscribe(mSubscription);
        mSubscription = login(username, password).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Subscriber<LoginResponse>() {
            @Override
            public void onCompleted() {
                getView().onDismissProgressDialog();
            }

            @Override
            public void onError(final Throwable throwable) {
                getView().onDismissProgressDialog();

                // Show error message based on error state
                if (throwable instanceof HttpException) {
                    final String errorMessage = getErrorResponse(throwable, "error");
                    getView().onShowError(errorMessage);
                } else if (throwable instanceof Exception) {
                    getView().onConnectionError();
                }
            }

            @Override
            public void onNext(final LoginResponse response) {
                if (null != response) {
                    setLoginResponse(response);
                }
            }
        });
    }

    public Observable<LoginResponse> login(final String username, final String password) {
        // Initial login request
        final LoginRequest request = new LoginRequest();
        request.username = username;
        request.password = password;

        return mApi.login(request.username,request.password).flatMap(new Func1<Response<LoginResponse>, Observable<LoginResponse>>() {
            @Override
            public Observable<LoginResponse> call(final Response<LoginResponse> response) {
                try {
                    switch (response.code()) {
                        case 200: {
                            return Observable.just(response.body());
                        }
                        case 401: {
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
        });
    }

    public void setLoginResponse(final LoginResponse response) {
        final User user = mAuthentications.getUserAuthentication(mRealmManagers, response);
        getView().onNavigateView(user);
    }

    public LoginView getView() {
        return mView;
    }
}