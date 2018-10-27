package com.tpm.tobitoi.prototype.internal.data.local;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

/**
 * Created by Tobitoi on 21/10/2018.
 */

public class RealmMigrations implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        final RealmSchema schema =realm.getSchema();
        if (oldVersion == 1) {
            // Create Locale Schema
            final RealmObjectSchema localeSchema = schema.create("LocaleData");
            localeSchema.addField("key", String.class, FieldAttribute.PRIMARY_KEY);
            localeSchema.addField("value", String.class);

            oldVersion++;
        }
    }
}
