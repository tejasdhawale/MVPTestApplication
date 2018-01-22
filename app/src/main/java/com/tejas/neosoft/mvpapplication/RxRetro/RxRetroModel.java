package com.tejas.neosoft.mvpapplication.RxRetro;


import android.util.Log;

import com.tejas.neosoft.mvpapplication.RxRetro.nw.ApiInterface;
import com.tejas.neosoft.mvpapplication.RxRetro.nw.ApiResponse;
import com.tejas.neosoft.mvpapplication.RxRetro.nw.Data;
import com.tejas.neosoft.mvpapplication.Singletons.RetrofitClient;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by webwerks1 on 11/1/18.
 */

public class RxRetroModel implements RxRetroContract.RxRetroModel {
    OnDataFinishedListener mDataFinishedListener;
    String TAG="RegisterModel";

    public RxRetroModel(RxRetroContract.RxRetroModel.OnDataFinishedListener mOnGetDatalistener){
        this.mDataFinishedListener = mOnGetDatalistener;

    }

    @Override
    public void HitApiFromModel( OnDataFinishedListener listener) {
        Retrofit retrofit=RetrofitClient.getClient();
        retrofit.create(ApiInterface.class).Register()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError );

    }
    private void handleResults(ApiResponse response){
        Log.d("Data", "response "+response);
        Log.d("Data", "Refreshed getStatus "+response.getTotal());
        String total,totalpage,page,per_page;
        total=response.getTotal().toString();
        totalpage=response.getTotalPages().toString();
        page=response.getPage().toString();
        per_page=response.getPerPage().toString();
        List<Data> dataList=response.getData();
        for ( Data data : dataList) {
            Log.d("Data", "data[] : "+ data.getName());
        }
        mDataFinishedListener.onSuccess(page,per_page,total,totalpage,dataList);

    }
    private void handleError(Throwable error){
        mDataFinishedListener.onError();
        Log.d("error", "error "+error.getMessage());
    }


}

