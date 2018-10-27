package com.tpm.tobitoi.prototype.internal.injectors.component;

import android.content.Context;

import com.tpm.tobitoi.prototype.internal.injectors.module.ActivityModule;
import com.tpm.tobitoi.prototype.internal.injectors.scope.ActivityContext;
import com.tpm.tobitoi.prototype.internal.injectors.scope.ActivityScope;
import com.tpm.tobitoi.prototype.internal.views.home.HomeActivity;
import com.tpm.tobitoi.prototype.internal.views.login.LoginActivity;
import com.tpm.tobitoi.prototype.internal.views.splash.SplashActivity;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = ApplicationComponent.class,
        modules = { ActivityModule.class }
)
public interface ActivityComponent {

    @ActivityContext
    Context getContext();

    void inject (LoginActivity loginActivity);

    void inject (HomeActivity homeActivity);

    void inject(SplashActivity splashActivity);

}