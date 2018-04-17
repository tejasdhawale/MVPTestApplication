package com.tejas.neosoft.mvpapplication.RxRetro;

import com.tejas.neosoft.mvpapplication.RxRetro.nw.Data;

import java.util.List;

/**
 * Created by webwerks1 on 11/1/18.
 */
public interface RxRetroContract {
    /**note- tejas
     * contract is like set of rules,Anything that implements have to override its funtions
     * **/

    interface RxRetroView {
        /**
         * implemented by View of Register
         * **/
     void showProgress();
     void hideProgress();
     void showMessage(String message);

     void invalidCall();
     void successfulCall(String page, String per_page, String total, String totalpage, List<Data> dataList);
    }

    interface RxRetroPresenter {
        /**
         * implemented by Presenter of Register
         * **/
        void RequestHitFromModel();
        void onDestory();
    }
    interface RxRetroModel {
        /**
         * implemented by model of Register
         * **/
        interface OnDataFinishedListener {
            void onError();
            void showMsg(String msg);
            void onSuccess(String page, String per_page, String total, String totalpage, List<Data> dataList);
        }
        void HitApiFromModel(OnDataFinishedListener listener);
    }
    interface onItemClickListener{
        void showClick(String message);
    }
}
