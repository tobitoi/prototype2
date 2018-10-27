package com.tpm.tobitoi.prototype.internal.injectors.component;

import android.content.Context;

import com.tpm.tobitoi.prototype.internal.injectors.module.DialogFragmentModule;
import com.tpm.tobitoi.prototype.internal.injectors.scope.ActivityContext;
import com.tpm.tobitoi.prototype.internal.injectors.scope.DialogFragmentScope;

import dagger.Component;

@DialogFragmentScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = { DialogFragmentModule.class }
)
public interface DialogFragmentComponent {

    @ActivityContext
    Context getContext();

}