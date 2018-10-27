package com.tpm.tobitoi.prototype.internal.injectors.component;

import android.content.Context;

import com.tpm.tobitoi.prototype.internal.injectors.module.FragmentModule;
import com.tpm.tobitoi.prototype.internal.injectors.scope.ActivityContext;
import com.tpm.tobitoi.prototype.internal.injectors.scope.FragmentScope;
import com.tpm.tobitoi.prototype.internal.views.dashboard.DashboardFragment;
import com.tpm.tobitoi.prototype.internal.views.profile.ProfileFragment;

import dagger.Component;


@FragmentScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = { FragmentModule.class }
)
public interface FragmentComponent {

    @ActivityContext
    Context getContext();

    void inject (DashboardFragment dashboardFragment);

    void inject (ProfileFragment profileFragment);



}