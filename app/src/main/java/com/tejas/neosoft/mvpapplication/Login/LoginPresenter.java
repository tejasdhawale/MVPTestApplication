package com.tejas.neosoft.mvpapplication.Login;

/**
 * Created by webwerks1 on 11/1/18.
 */
public class LoginPresenter implements LoginContract.LoginPresenter,LoginContract.LoginModel.OnLoginFinishedListener {
    LoginContract.LoginView mView;
    LoginContract.LoginModel modelMain;

    public LoginPresenter(LoginContract.LoginView view, LoginContract.LoginModel model) {
        mView=view;
        modelMain=model;
  }
    @Override
    public void validateLogin(String Email, String Pass) {
   if(mView!=null)
        {
           mView.showProgress();
           modelMain.login(Email, Pass,this);
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
        mView.successfullLogin();
    }



    @Override
    public void onDestory() {
        mView=null;
    }
}


