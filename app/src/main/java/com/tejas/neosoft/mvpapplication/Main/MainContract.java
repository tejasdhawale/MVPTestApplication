package com.tejas.neosoft.mvpapplication.Main;

import android.content.Context;

import com.tejas.neosoft.mvpapplication.Main.model.Datum;

import java.util.List;

/**
 * Created by webwerks1 on 12/1/18.
 */

public interface MainContract {
    interface mainView{
        void showMessage(String message);
        void onGetDataSuccess(String message, List<Datum> list);
        void onGetDataFailure(String message);

    }
    interface mainPresenter{
        void getDataFromURL(Context context,String url);
    }
    interface mainModel{
        void initRetrofitCall(Context context, String url);

    }
    interface onGetDataListener{
        void onSuccess(String message, List<Datum> userList);
        void onFailure(String message);

    }
    interface onItemClickListener{
    void showClick(String message);
    }
}
