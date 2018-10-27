package com.tpm.tobitoi.prototype.internal.utils.validators;

import android.text.TextUtils;
import android.util.Patterns;

public final class EmailValidator implements IValidator<String> {

    @Override
    public boolean isValid(final String data) {
        return !TextUtils.isEmpty(data) && Patterns.EMAIL_ADDRESS.matcher(data).matches();
    }
}