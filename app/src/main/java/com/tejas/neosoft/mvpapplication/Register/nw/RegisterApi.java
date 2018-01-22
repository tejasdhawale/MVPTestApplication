package com.tejas.neosoft.mvpapplication.Register.nw;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by webwerks1 on 18/1/18.
 */

public interface RegisterApi {
    @GET("/api/unknown")
    Call<RegisterResponse> Register();

}
