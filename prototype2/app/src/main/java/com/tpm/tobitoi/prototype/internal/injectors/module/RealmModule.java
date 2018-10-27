package com.tpm.tobitoi.prototype.internal.injectors.module;

import android.content.Context;

import com.tpm.tobitoi.prototype.internal.data.local.RealmManagers;
import com.tpm.tobitoi.prototype.internal.utils.RealmHelpers;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class RealmModule {
    private final Context mContext;

    public RealmModule(final Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    public RealmManagers provideRealmManagers() {
        final RealmHelpers realmHelpers = new RealmHelpers(mContext);
        realmHelpers.initialRealm();

        return new RealmManagers();
    }
}