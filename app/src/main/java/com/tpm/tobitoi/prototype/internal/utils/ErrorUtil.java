package com.tpm.tobitoi.prototype.internal.utils;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;

public class ErrorUtil {

	private static final String TAG = ErrorUtil.class.getSimpleName();

	public static String getErrorResponse(final Throwable throwable, final String key) {
		final HttpException httpException = (HttpException) throwable;
		final Response response = httpException.response();

		try {
			final JSONObject jsonObject = new JSONObject(response.errorBody().source().readUtf8());
			return jsonObject.getString(key);

		} catch (JSONException jsonException){
			return response.errorBody().toString();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		}
	}


	public static int getForbiddenErrorCode(final Throwable throwable) {
		final ForbiddenException forbiddenException = (ForbiddenException) throwable;
		return forbiddenException.getCode();
	}

	public static String getForbiddenErrorResponse(final Throwable throwable, final String key) {
		final ForbiddenException forbiddenException = (ForbiddenException) throwable;
		final Response response = forbiddenException.getResponse();

		try {
			final JSONObject jsonObject = new JSONObject(response.errorBody().source().readUtf8());
			return jsonObject.getString(key);
		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
			return null;
		}
	}

}
