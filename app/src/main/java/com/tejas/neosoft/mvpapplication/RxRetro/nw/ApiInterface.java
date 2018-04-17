package com.tejas.neosoft.mvpapplication.RxRetro.nw;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by webwerks1 on 18/1/18.
 */

public interface ApiInterface {
    @GET("/api/unknown")
    Observable<ApiResponse> Register();
}
