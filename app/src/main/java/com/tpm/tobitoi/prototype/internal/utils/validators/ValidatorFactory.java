package com.tpm.tobitoi.prototype.internal.utils.validators;

public final class ValidatorFactory {
    /**
     * @return {@link EmailValidator} instance
     */
    public final IValidator<String> getEmailValidator() {
        return new EmailValidator();
    }
}