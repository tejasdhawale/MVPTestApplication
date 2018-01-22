package com.tejas.neosoft.mvpapplication.Register;

import android.util.Log;

/**
 * Created by webwerks1 on 11/1/18.
 */
public class RegisterPresenter implements RegisterContract.RegisterPresenter, RegisterContract.RegisterModel.OnRegisterFinishedListener {
    RegisterContract.RegisterView mView;
    RegisterContract.RegisterModel modelMain;
    private String TAG="RegisterPresenter";

    public RegisterPresenter(RegisterContract.RegisterView view, RegisterContract.RegisterModel model) {
        mView=view;
        modelMain=model;
  }
    @Override
    public void validateRegister(String Fname,String Lname,String Email, String Pass,String Cpass,String Gender,String Phone) {
   if(mView!=null)
        {
           mView.showProgress();
           if(Cpass.equals(Pass))
           {
               Log.d(TAG, "validateRegister: ");
           modelMain.Register(Fname,Lname,Email,Pass,Cpass,Gender,Phone,this);}
           else{
               mView.invalidPass();
           }
        }
    }

    @Override
    public void onUsernameError() {
        mView.invalidUserId();
    }

    @Override
    public void onPasswordError() {
        mView.invalidPass();
    }

    @Override
    public void onSuccess() {
        mView.successfullRegister();
    }

    @Override
    public void onDestory() {
        mView=null;
    }
}


