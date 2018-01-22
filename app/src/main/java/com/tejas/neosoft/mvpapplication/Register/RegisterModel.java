package com.tejas.neosoft.mvpapplication.Register;


import android.util.Log;

import com.tejas.neosoft.mvpapplication.Register.nw.RegisterApi;
import com.tejas.neosoft.mvpapplication.Register.nw.RegisterResponse;
import com.tejas.neosoft.mvpapplication.Singletons.RetrofitClient;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by webwerks1 on 11/1/18.
 */

public class RegisterModel implements RegisterContract.RegisterModel {
    String TAG="RegisterModel";
    @Override
    public void Register(String Fname, String Lname, String Email, String Password,String CPass, String Gender,String Phone, OnRegisterFinishedListener listener) {

        Log.d(TAG, "Register(): in model \n"
                        +"Fname: "+Fname
                        +"\nLname: "+Lname
                        +"\nEmail: "+Email
                        +"\npassword: "+Password
                        +"\npassword: "+CPass
                        +"\nGender: "+Gender
                        +"\nPhone: "+Phone
        );
        Retrofit retrofit=RetrofitClient.getClient();
        RegisterApi request = retrofit.create(RegisterApi.class);
//        retrofit2.Call<RegisterResponse> call =request.Register(Fname,Lname,Email,Password,CPass,Gender,Phone);
        retrofit2.Call<RegisterResponse> call =request.Register();

        call.enqueue(new retrofit2.Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                Log.d("Data", "response "+response);
                RegisterResponse registerResponse   = response.body();
                Log.d("Data", "Refreshed getStatus "+registerResponse.getTotal());

                Log.d("Data", "Refreshed");

          }
            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
//                mOnGetDatalistener.onFailure(t.getMessage());
            }});
    }
}

