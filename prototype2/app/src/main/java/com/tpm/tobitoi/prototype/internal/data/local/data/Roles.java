package com.tpm.tobitoi.prototype.internal.data.local.data;

import io.realm.RealmObject;

public class Roles extends RealmObject {
    private String name;

    public Roles() {
    }

    public  void fill(Roles roles){
        setName(roles.getName());
    }

    public Roles(final Roles roles) {
        setName(roles.getName());
    }

    public void fill(final String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}