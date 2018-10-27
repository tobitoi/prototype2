package com.tpm.tobitoi.prototype.internal.views.base;

import android.util.Log;

import com.tpm.tobitoi.prototype.internal.utils.ForbiddenException;

import org.json.JSONObject;


import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;

public abstract class BasePresenter {
    private static final String TAG = BasePresenter.class.getSimpleName();

    protected String getErrorResponse(final Throwable throwable, final String key) {
        final HttpException httpException = (HttpException) throwable;
        final Response response = httpException.response();

        try {
            final JSONObject jsonObject = new JSONObject(response.errorBody().source().readUtf8());
            return jsonObject.getString(key);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
            return null;
        }
    }

    protected int getForbiddenErrorCode(final Throwable throwable) {
        final ForbiddenException forbiddenException = (ForbiddenException) throwable;
        return forbiddenException.getCode();
    }

    protected String getForbiddenErrorResponse(final Throwable throwable, final String key) {
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