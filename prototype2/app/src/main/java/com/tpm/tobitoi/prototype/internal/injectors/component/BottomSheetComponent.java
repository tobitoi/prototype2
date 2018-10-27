package com.tpm.tobitoi.prototype.internal.injectors.component;

import android.content.Context;

import com.tpm.tobitoi.prototype.internal.injectors.module.BottomSheetModule;
import com.tpm.tobitoi.prototype.internal.injectors.scope.ActivityContext;
import com.tpm.tobitoi.prototype.internal.injectors.scope.BottomSheetScope;

import dagger.Component;


@BottomSheetScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = { BottomSheetModule.class }
)
public interface BottomSheetComponent {

    @ActivityContext
    Context getContext();


}