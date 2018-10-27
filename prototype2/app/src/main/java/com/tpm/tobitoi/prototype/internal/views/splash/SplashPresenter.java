package com.tpm.tobitoi.prototype.internal.views.splash;

import android.content.Context;
import android.text.TextUtils;

import com.tpm.tobitoi.prototype.internal.data.local.RealmManagers;
import com.tpm.tobitoi.prototype.internal.data.local.data.LocaleData;
import com.tpm.tobitoi.prototype.internal.data.local.data.UserData;
import com.tpm.tobitoi.prototype.internal.utils.Commons;
import com.tpm.tobitoi.prototype.internal.views.base.IPresenter;

import java.util.Locale;

import javax.inject.Inject;


public class SplashPresenter implements IPresenter<SplashView> {
    private SplashView mView;

    @Inject
    Commons mCommonUtils;

    @Inject
    RealmManagers mRealmManagers;

    @Inject
    public SplashPresenter() {
    }

    @Override
    public void onAttach(final SplashView view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }

    public void checkDefaultLocale(final Context context) {
        // Set default locale
        final LocaleData data = mRealmManagers.getLocale();

        if (null != data) {
            final String locale = data.getValue();
            mCommonUtils.updateLocaleConfigurations(context, new Locale(locale));
        }
    }

    public void checkApplicationState() {
        final UserData data = mRealmManagers.getUser();

        if (null != data && !TextUtils.isEmpty(data.getToken())) {
            getView().onNavigateHomeView();
        } else {
            getView().onNavigateLoginView();
        }
    }

    public SplashView getView() {
        return mView;
    }
}