package com.tpm.tobitoi.prototype.internal.views.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tpm.tobitoi.prototype.internal.App;
import com.tpm.tobitoi.prototype.internal.injectors.component.ActivityComponent;
import com.tpm.tobitoi.prototype.internal.injectors.component.DaggerActivityComponent;
import com.tpm.tobitoi.prototype.internal.injectors.module.ActivityModule;
import com.tpm.tobitoi.prototype.internal.utils.Navigators;

import javax.inject.Inject;


public class SplashActivity extends AppCompatActivity implements SplashView {
    private ActivityComponent mComponent;

    @Inject
    SplashPresenter mPresenter;

    @Inject
    Navigators mNavigators;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        onAttach();
    }

    @Override
    public void inject() {
        mComponent = DaggerActivityComponent.builder().applicationComponent(App.getComponent())
                                                      .activityModule(new ActivityModule(this))
                                                      .build();
        getComponent().inject(this);
    }

    @Override
    public void onAttach() {
        mPresenter.onAttach(this);
        mPresenter.checkDefaultLocale(this);
        mPresenter.checkApplicationState();
    }

    @Override
    public void onDetach() {
        mPresenter.onDetach();
    }

    @Override
    public void onNavigateLoginView() {
        mNavigators.openLoginActivity(this, false);
    }

    @Override
    public void onNavigateHomeView() {
        mNavigators.openHomeActivity(this, null);
    }

    @Override
    protected void onDestroy() {
        onDetach();
        super.onDestroy();
    }

    public ActivityComponent getComponent() {
        return mComponent;
    }
}