package com.tpm.tobitoi.prototype.internal.injectors.component;

import android.app.Application;
import android.content.Context;


import com.tpm.tobitoi.prototype.internal.data.local.RealmManagers;
import com.tpm.tobitoi.prototype.internal.data.remote.IApi;
import com.tpm.tobitoi.prototype.internal.injectors.module.ApplicationModule;
import com.tpm.tobitoi.prototype.internal.injectors.module.NetworkModule;
import com.tpm.tobitoi.prototype.internal.injectors.module.RealmModule;
import com.tpm.tobitoi.prototype.internal.injectors.module.UtilityModule;
import com.tpm.tobitoi.prototype.internal.injectors.scope.ApplicationContext;
import com.tpm.tobitoi.prototype.internal.utils.Authentications;
import com.tpm.tobitoi.prototype.internal.utils.Commons;
import com.tpm.tobitoi.prototype.internal.utils.Dates;
import com.tpm.tobitoi.prototype.internal.utils.Images;
import com.tpm.tobitoi.prototype.internal.utils.Keyboards;
import com.tpm.tobitoi.prototype.internal.utils.Navigators;
import com.tpm.tobitoi.prototype.internal.utils.Reactives;
import com.tpm.tobitoi.prototype.internal.utils.validators.ValidatorFactory;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        NetworkModule.class,
        RealmModule.class,
        UtilityModule.class
})
public interface ApplicationComponent {

    @ApplicationContext
    Context getContext();

    void inject(Application application);

    // Network Module
    @Named("core")
    IApi getApi();


    // Realm Module
    RealmManagers getRealmManagers();

    // Utility Module
    ValidatorFactory getValidator();

    Authentications getAuthentications();

    Commons getCommonUtils();

    Dates getDates();

    Images getImages();

    Keyboards getKeyboards();

    Navigators getNavigators();

    Reactives getReactives();
}