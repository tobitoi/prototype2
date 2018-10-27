package com.tpm.tobitoi.prototype.internal.injectors.module;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.tpm.tobitoi.prototype.internal.injectors.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;


@Module
public class FragmentModule {
    private final Fragment mFragment;

    public FragmentModule(final Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    public Fragment provideFragment() {
        return mFragment;
    }

    @Provides
    @ActivityContext
    public Context provideFragmentContext() {
        return mFragment.getContext();
    }
}