package com.tpm.tobitoi.prototype.internal.data.local.dao;

/**
 * Created by Tobitoi on 20/10/2018.
 */

import com.tpm.tobitoi.prototype.internal.data.local.data.UserData;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class UserDao implements IDao<UserData> {

    @Override
    public void saveOrUpdate(final UserData data) {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(final Realm realm) {
                realm.insertOrUpdate(data);
            }
        });

        realm.close();
    }

    @Override
    public List<UserData> findAll() {
        final Realm realm = Realm.getDefaultInstance();
        final RealmResults<UserData> data = realm.where(UserData.class).findAll();
        realm.close();

        return data;
    }

    @Override
    public UserData findOne() {
        final Realm realm = Realm.getDefaultInstance();
        UserData data = realm.where(UserData.class).findFirst();

        if (null != data) {
            data = realm.copyFromRealm(data);
        }

        realm.close();

        return data;
    }

    @Override
    public void delete() {
        final Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(final Realm realm) {
                realm.delete(UserData.class);
            }
        });

        realm.close();
    }
}

