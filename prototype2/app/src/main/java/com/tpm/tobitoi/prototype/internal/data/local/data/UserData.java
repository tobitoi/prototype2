package com.tpm.tobitoi.prototype.internal.data.local.data;

import com.tpm.tobitoi.prototype.internal.data.local.pojo.User;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Tobitoi on 20/10/2018.
 */

public class UserData extends RealmObject {


    @PrimaryKey
    private String name;
    private String avatar;

    private String token;
    private RealmList<Roles> roles;

    public UserData() {
    }

    public void fill(final User user){
        final String name = user.getUsername() != null ? user.getUsername() :"";
        final String token = user.getToken() != null ? user.getToken():"";
        final String avatar = user.getAvatar() != null ? user.getAvatar():"";

        setName(name);
        setToken(token);
        setAvatar(avatar);
    }

    private RealmList<Roles> convertRolesToRealm(final List<String> roles){
        final RealmList<Roles> rolesRealmList = new RealmList<>();
        for (String role : roles){
            Roles data = new Roles();
            data.fill(role);
            rolesRealmList.add(data);
        }
        return rolesRealmList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RealmList<Roles> getRoles() {
        return roles;
    }

    public void setRoles(RealmList<Roles> roles) {
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
