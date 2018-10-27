package com.tpm.tobitoi.prototype.internal.injectors.module;

import android.content.Context;
import android.support.design.widget.BottomSheetDialogFragment;

import com.tpm.tobitoi.prototype.internal.injectors.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;


@Module
public class BottomSheetModule {
    private final BottomSheetDialogFragment mFragment;

    public BottomSheetModule(final BottomSheetDialogFragment fragment) {
        mFragment = fragment;
    }

    @Provides
    public BottomSheetDialogFragment provideBottomSheet() {
        return mFragment;
    }

    @Provides
    @ActivityContext
    public Context provideBottomSheetContext() {
        return mFragment.getContext();
    }
}