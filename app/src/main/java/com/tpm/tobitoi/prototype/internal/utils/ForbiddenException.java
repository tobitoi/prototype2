package com.tpm.tobitoi.prototype.internal.utils;

import retrofit2.Response;

public final class ForbiddenException extends Exception {
    private final int code;
    private final String message;
    private final transient Response<?> response;

    public ForbiddenException(final Response<?> response) {
        this.code = response.code();
        this.message = response.message();
        this.response = response;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Response<?> getResponse() {
        return response;
    }
}