package com.tpm.tobitoi.prototype.internal.injectors.module;

import android.app.Activity;
import android.content.Context;

import com.tpm.tobitoi.prototype.internal.injectors.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;


@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(final Activity activity) {
        mActivity = activity;
    }

    @Provides
    public Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    public Context provideActivityContext() {
        return mActivity;
    }
}