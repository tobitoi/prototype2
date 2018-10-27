package com.tpm.tobitoi.prototype.internal.injectors.module;

import com.tpm.tobitoi.prototype.internal.utils.Authentications;
import com.tpm.tobitoi.prototype.internal.utils.Commons;
import com.tpm.tobitoi.prototype.internal.utils.Dates;
import com.tpm.tobitoi.prototype.internal.utils.Images;
import com.tpm.tobitoi.prototype.internal.utils.Keyboards;
import com.tpm.tobitoi.prototype.internal.utils.Navigators;
import com.tpm.tobitoi.prototype.internal.utils.Reactives;
import com.tpm.tobitoi.prototype.internal.utils.validators.ValidatorFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class UtilityModule {

    @Provides
    @Singleton
    public ValidatorFactory provideValidator() {
        return new ValidatorFactory();
    }

    @Provides
    @Singleton
    public Authentications provideAuthentications() {
        return new Authentications();
    }

    @Provides
    @Singleton
    public Commons provideCommonUtils() {
        return new Commons();
    }

    @Provides
    @Singleton
    public Dates provideDates() {
        return new Dates();
    }

    @Provides
    @Singleton
    public Images provideImages() {
        return new Images();
    }

    @Provides
    @Singleton
    public Keyboards provideKeyboards() {
        return new Keyboards();
    }

    @Provides
    @Singleton
    public Navigators provideNavigators() {
        return new Navigators();
    }

    @Provides
    @Singleton
    public Reactives provideReactives() {
        return new Reactives();
    }
}