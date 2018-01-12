package com.tejas.neosoft.mvpapplication;

import android.widget.EditText;

/**
 * Created by webwerks1 on 11/1/18.
 */
public class MainPresenter implements Maincontract.presenterMain,Maincontract.modelMain.OnLoginFinishedListener {


    Maincontract.viewMain mView;


    public MainPresenter(Maincontract.viewMain view) {
        mView=view;
  }


    public void submitlogin(EditText et_email, EditText et_pass) {


    }

    @Override
    public void onUsernameError() {

    }

    @Override
    public void onPasswordError() {

    }

    @Override
    public void onSuccess() {

    }
}


