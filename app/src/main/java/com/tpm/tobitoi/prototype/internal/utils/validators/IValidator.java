package com.tpm.tobitoi.prototype.internal.utils.validators;

public interface IValidator<T> {
    /**
     * Validate given object, returns <b>TRUE</b> if valid
     *
     * @param object An object to be checked
     * @return <b>TRUE</b> if given object is valid, otherwise <b>FALSE</b>
     */
    boolean isValid(T object);
}