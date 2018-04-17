package com.tejas.neosoft.mvpapplication.Main.model;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by webwerks1 on 12/1/18.
 */


public interface ListUserApi {
    @GET("/api/users?page=2")
    Call<Users> getUsers();


}
