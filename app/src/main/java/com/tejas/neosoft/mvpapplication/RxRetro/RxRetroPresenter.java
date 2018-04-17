package com.tejas.neosoft.mvpapplication.RxRetro;

import android.util.Log;

import com.tejas.neosoft.mvpapplication.RxRetro.nw.Data;

import java.util.List;

/**
 * Created by webwerks1 on 11/1/18.
 */
public class RxRetroPresenter implements RxRetroContract.RxRetroPresenter, RxRetroContract.RxRetroModel.OnDataFinishedListener,RxRetroContract.onItemClickListener {
    RxRetroContract.RxRetroView mView;
    RxRetroContract.RxRetroModel modelMain;
    private String TAG="RegisterPresenter";

    public RxRetroPresenter(RxRetroContract.RxRetroView view) {
        mView=view;
        modelMain=new RxRetroModel(this);
  }
    @Override
    public void RequestHitFromModel() {
   if(mView!=null)
        {
           mView.showProgress();
           modelMain.HitApiFromModel(this);
        }
    }


    @Override
    public void onError() {
        mView.hideProgress();
        mView.invalidCall();
    }

    @Override
    public void showMsg(String msg) {
        mView.showMessage(msg);
    }



    @Override
    public void onSuccess(String page, String per_page, String total, String totalpage, List<Data> dataList) {
        Log.d(TAG, "onSuccess:page "+page);
        mView.hideProgress();
        mView.successfulCall(page,per_page,total, totalpage, dataList);
    }

    @Override
    public void onDestory() {
        mView.hideProgress();
        mView=null;
    }

    @Override
    public void showClick(String message) {
        mView.hideProgress();
        mView.showMessage(message);
    }
}


