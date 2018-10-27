package com.tpm.tobitoi.prototype.internal.data.remote;

import com.tpm.tobitoi.prototype.internal.data.remote.response.LoginResponse;
import com.tpm.tobitoi.prototype.internal.utils.IConstant;



import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import rx.Observer;

/**
 * Created by Tobitoi on 20/10/2018.
 */

public interface IApi {
    @FormUrlEncoded
    @POST(IConstant.IApis.Login)
    Observable<Response<LoginResponse>> login(@Field("username") String username, @Field("password") String password);

    @DELETE(IConstant.IApis.Logout)
    Observer<Response<Void>> logout();
}
