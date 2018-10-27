package com.tpm.tobitoi.prototype.internal.utils;

import com.tpm.tobitoi.prototype.internal.data.local.RealmManagers;
import com.tpm.tobitoi.prototype.internal.data.local.pojo.User;
import com.tpm.tobitoi.prototype.internal.data.remote.response.LoginResponse;

import java.util.List;



public final class Authentications {

    public User getUserAuthentication(final RealmManagers realmManagers, final LoginResponse response) {
        // Set login response
        final String name = response.user.username != null ? response.user.username: "";
        final String token = response.accessToken != null ? response.accessToken: "";
        final String avatar = response.user.avatar !=null ? response.user.avatar:"";


        // Set user object
        User user = new User();
        user.setUsername(name);
        user.setToken(token);
        user.setAvatar(avatar);

        // Cache login authentication
        realmManagers.saveOrUpdateUser(user);

        return user;
    }
}