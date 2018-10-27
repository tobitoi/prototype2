package com.tpm.tobitoi.prototype.internal;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.crashlytics.android.Crashlytics;
import com.tpm.tobitoi.prototype.BuildConfig;
import com.tpm.tobitoi.prototype.internal.injectors.component.ApplicationComponent;
import com.tpm.tobitoi.prototype.internal.injectors.component.DaggerApplicationComponent;
import com.tpm.tobitoi.prototype.internal.injectors.module.ApplicationModule;
import com.tpm.tobitoi.prototype.internal.injectors.module.NetworkModule;
import com.tpm.tobitoi.prototype.internal.injectors.module.RealmModule;
import com.tpm.tobitoi.prototype.internal.injectors.module.UtilityModule;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;

/**
 * Created by Tobitoi on 21/10/2018.
 */

public class  App extends Application {
    private static volatile ApplicationComponent component;

    public static synchronized ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize dagger component for android application
        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule())
                .realmModule(new RealmModule(this))
                .utilityModule(new UtilityModule())
                .build();

        // Initialize fabric sdk based on build.gradle config
        if (BuildConfig.FABRIC) {
            Fabric.with(this, new Crashlytics());
        }
    }

    @Override
    public void onTerminate() {
        Realm.getDefaultInstance().close();
        super.onTerminate();
    }

    @Override
    protected void attachBaseContext(final Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
