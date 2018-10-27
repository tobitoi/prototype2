package com.tpm.tobitoi.prototype.internal.injectors.module;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tpm.tobitoi.prototype.BuildConfig;
import com.tpm.tobitoi.prototype.internal.data.local.RealmManagers;
import com.tpm.tobitoi.prototype.internal.data.local.data.UserData;
import com.tpm.tobitoi.prototype.internal.data.remote.IApi;
import com.tpm.tobitoi.prototype.internal.utils.IConstant;
import com.tpm.tobitoi.prototype.internal.utils.IConstants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Tobitoi on 20/10/2018.
 */
@Module
public class NetworkModule {


    @Provides
    @Singleton
    @Named("core")
    public IApi provideApi() {
        final String baseUrl = BuildConfig.ENDPOINT;
        final Retrofit retrofit = new Retrofit.Builder().client(getOkHttpClient("core"))
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(getObjectMapper()))
                .build();

        return retrofit.create(IApi.class);
    }

    @Provides
    @Singleton
    @Named("jwt")
    public IApi provideApiWithJwt() {
        final String baseUrl = BuildConfig.ENDPOINT;
        final Retrofit retrofit = new Retrofit.Builder().client(getOkHttpClient("jwt"))
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create(getObjectMapper()))
                .build();

        return retrofit.create(IApi.class);
    }

    private ObjectMapper getObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        return objectMapper;
    }

    private OkHttpClient getOkHttpClient(final String namespace) {
        final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        final boolean isLogEnabled = BuildConfig.LOG;
        httpLoggingInterceptor.setLevel(isLogEnabled ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        return new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(getInterceptor(namespace))
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    private Interceptor getInterceptor(final String namespace) {
        if (namespace.equalsIgnoreCase("core")) {
            return new Interceptor() {
                @Override
                public Response intercept(final Chain chain) throws IOException {
                    final Request request = chain.request();
                    final Request.Builder builder = request.newBuilder().addHeader("Content-Type", "application/x-www-form-urlencoded");


                    return chain.proceed(builder.build());
                }
            };
        }

        return new Interceptor() {
            @Override
            public Response intercept(final Chain chain) throws IOException {
                final Request request = chain.request();
                final Request.Builder builder = request.newBuilder().addHeader("Content-Type", "application/x-www-form-urlencoded");

                // Add authorization for every API request except login
                final RealmManagers realmManagers = new RealmManagers();
                final UserData data = realmManagers.getUser();

                if (null != data) {
                    final String token = data.getToken();
                    builder.addHeader("Authorization", token);
                }

                return chain.proceed(builder.build());
            }
        };
    }
}
