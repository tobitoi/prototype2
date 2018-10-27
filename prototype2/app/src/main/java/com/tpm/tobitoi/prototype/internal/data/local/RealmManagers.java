package com.tpm.tobitoi.prototype.internal.data.local;

import com.tpm.tobitoi.prototype.internal.data.local.dao.LocaleDao;
import com.tpm.tobitoi.prototype.internal.data.local.dao.UserDao;
import com.tpm.tobitoi.prototype.internal.data.local.data.LocaleData;
import com.tpm.tobitoi.prototype.internal.data.local.data.UserData;
import com.tpm.tobitoi.prototype.internal.data.local.pojo.User;

/**
 * Created by Tobitoi on 20/10/2018.
 */

public class RealmManagers {

    public void saveOrUpdateUser(final User user) {
        final UserData data = new UserData();
        final UserDao dao = new UserDao();
        data.fill(user);
        dao.saveOrUpdate(data);
    }

    public UserData getUser() {
        final UserDao dao = new UserDao();
        return dao.findOne();
    }

    public void deleteUser() {
        final UserDao dao = new UserDao();
        dao.delete();
    }

    public void deleteAll(){
        deleteUser();
    }

    public void saveOrUpdateLocale(final String[] locales) {
        final LocaleData data = new LocaleData();
        final LocaleDao dao = new LocaleDao();
        data.fill(locales);
        dao.saveOrUpdate(data);
    }

    public LocaleData getLocale() {
        final LocaleDao dao = new LocaleDao();
        return dao.findOne();
    }

    public void deleteLocale() {
        final LocaleDao dao = new LocaleDao();
        dao.delete();
    }

}
