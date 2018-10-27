package com.tpm.tobitoi.prototype.internal.utils;

import rx.Subscription;

public final class Reactives {
    /**
     * @param subscription Reactive subscription
     */
    public void setSafeUnsubscribe(final Subscription subscription) {
        if (null != subscription && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}