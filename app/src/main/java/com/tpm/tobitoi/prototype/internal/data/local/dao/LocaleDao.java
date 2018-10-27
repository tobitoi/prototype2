package com.tpm.tobitoi.prototype.internal.data.local.dao;

import com.tpm.tobitoi.prototype.internal.data.local.data.LocaleData;

import java.util.List;


import io.realm.Realm;
import io.realm.RealmResults;


public class LocaleDao implements IDao<LocaleData> {

    @Override
    public void saveOrUpdate(final LocaleData data) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(final Realm realm) {
                realm.insertOrUpdate(data);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                realm.close();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(final Throwable throwable) {
                realm.close();
            }
        });
    }

    @Override
    public List<LocaleData> findAll() {
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<LocaleData> data = realm.where(LocaleData.class).findAll();
        realm.close();

        return data;
    }

    @Override
    public LocaleData findOne() {
        final Realm realm = Realm.getDefaultInstance();
        LocaleData data = realm.where(LocaleData.class).findFirst();

        if (null != data) {
            data = realm.copyFromRealm(data);
        }

        realm.close();

        return data;
    }

    @Override
    public void delete() {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(final Realm realm) {
                realm.delete(LocaleData.class);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                realm.close();
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(final Throwable throwable) {
                realm.close();
            }
        });
    }
}