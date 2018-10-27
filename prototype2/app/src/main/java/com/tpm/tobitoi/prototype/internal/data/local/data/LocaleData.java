package com.tpm.tobitoi.prototype.internal.data.local.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class LocaleData extends RealmObject {

    @PrimaryKey
    private String key;

    private String value;

    public LocaleData() {
    }

    public void fill(final String[] locales) {
        final String key = locales[0];
        final String value = locales[1];

        setKey(key);
        setValue(value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}