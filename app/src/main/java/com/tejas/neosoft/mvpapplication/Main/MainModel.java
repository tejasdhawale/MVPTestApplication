package com.tejas.neosoft.mvpapplication.Main;

import android.content.Context;
import android.util.Log;

import com.tejas.neosoft.mvpapplication.Main.model.Datum;
import com.tejas.neosoft.mvpapplication.Main.model.ListUserApi;
import com.tejas.neosoft.mvpapplication.Main.model.Users;
import com.tejas.neosoft.mvpapplication.Singletons.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by webwerks1 on 12/1/18.
 */

public class MainModel implements MainContract.mainModel {
    private MainContract.onGetDataListener mOnGetDatalistener;
    List<Users> allUsers = new ArrayList<>();
    List<String> allHerosData = new ArrayList<>();


    public MainModel(MainContract.onGetDataListener mOnGetDatalistener){
        this.mOnGetDatalistener = mOnGetDatalistener;
    }

    @Override
    public void initRetrofitCall(Context context, String url) {
        Retrofit retrofit=RetrofitClient.getClient();

        ListUserApi request = retrofit.create(ListUserApi.class);
        Call<Users> call =request.getUsers();

        call.enqueue(new retrofit2.Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                Log.d("Data", "response "+response);
                Users users = response.body();
                List<Datum> usersList1=users.getData();
                Log.d("Data", "Refreshed"+ usersList1.get(1).getFirstName());
                for(int i = 0; i< usersList1.size(); i++){
                        allHerosData.add(usersList1.get(i).getFirstName());
                    Log.d("Data", "Refreshed :"+ usersList1.get(i).getFirstName() );
                    }
                    mOnGetDatalistener.onSuccess("List Size: " + allHerosData.size(), usersList1);
            }
            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                mOnGetDatalistener.onFailure(t.getMessage());
            }});
    }
}
