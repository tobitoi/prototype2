package com.tpm.tobitoi.prototype.internal.data.local.dao;

/**
 * Created by Tobitoi on 20/10/2018.
 */

import java.util.List;

import io.realm .RealmObject;

public interface IDao<T extends RealmObject> {
    void saveOrUpdate(T data);

    List<T> findAll();

    T findOne();

    void delete();
}
