package com.tpm.tobitoi.prototype.internal.utils;

import android.content.Context;
import com.tpm.tobitoi.prototype.BuildConfig;
import com.tpm.tobitoi.prototype.internal.data.local.RealmMigrations;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public final class RealmHelpers {
    private final Context mContext;
    private final String mSchema;
    private final int mSchemaVersion;

    public RealmHelpers(final Context context) {
        mContext = context;
        mSchema = "elogbook.realm";
        mSchemaVersion = 3;
    }

    public void initialRealm() {
        // Initial Realm
        Realm.init(mContext);

        // Initial Realm Configuration
        RealmConfiguration configuration;
        if (BuildConfig.REALM) {
            configuration = new RealmConfiguration.Builder().name(mSchema).schemaVersion(mSchemaVersion).migration(new RealmMigrations()).build();
        } else {
            configuration = new RealmConfiguration.Builder().name(mSchema).schemaVersion(mSchemaVersion).deleteRealmIfMigrationNeeded().build();
        }

        // Set Default Realm Configuration
        Realm.setDefaultConfiguration(configuration);
        Realm.getInstance(configuration);
    }
}