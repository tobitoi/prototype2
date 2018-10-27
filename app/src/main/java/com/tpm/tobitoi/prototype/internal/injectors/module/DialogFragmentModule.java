package com.tpm.tobitoi.prototype.internal.injectors.module;

import android.content.Context;
import android.support.v4.app.DialogFragment;

import com.tpm.tobitoi.prototype.internal.injectors.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class DialogFragmentModule {
    private final DialogFragment mFragment;

    public DialogFragmentModule(final DialogFragment fragment) {
        mFragment = fragment;
    }

    @Provides
    public DialogFragment provideDialogFragment() {
        return mFragment;
    }

    @Provides
    @ActivityContext
    public Context provideDialogFragmentContext() {
        return mFragment.getContext();
    }
}