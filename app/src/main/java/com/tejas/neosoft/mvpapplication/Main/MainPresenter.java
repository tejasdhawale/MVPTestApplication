package com.tejas.neosoft.mvpapplication.Main;

import android.content.Context;
import android.util.Log;

import com.tejas.neosoft.mvpapplication.Main.model.Datum;

import java.util.List;

/**
 * Created by webwerks1 on 12/1/18.
 */

public class MainPresenter implements MainContract.mainPresenter, MainContract.onGetDataListener,MainContract.onItemClickListener {
        private MainContract.mainView mView;
        private MainModel mModel;

        public MainPresenter(MainContract.mainView view){
            this.mView = view;
            mModel = new MainModel(this);
        }
        @Override
        public void getDataFromURL(Context context, String url) {
            mModel.initRetrofitCall(context,url);
        }

    @Override
    public void onSuccess(String message, List<Datum> list) {
        mView.onGetDataSuccess(message, list);
    }

    @Override
        public void onFailure(String message) {
            mView.onGetDataFailure(message);
        }

    @Override
    public void showClick(String message) {
       mView.showMessage(message);
        Log.d("testing", "showMessage: testing");
    }
}

