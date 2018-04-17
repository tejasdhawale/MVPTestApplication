package com.tejas.neosoft.mvpapplication.Login;


import android.os.Handler;

import com.tejas.neosoft.mylibrary.Validator;

/**
 * Created by webwerks1 on 11/1/18.
 */

public class LoginModel implements LoginContract.LoginModel {

    @Override
    public void login(final String username,final String password, final OnLoginFinishedListener listener) {

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               if (!Validator.validateEmail(username))
               {
                   listener.onUsernameError();
                   return;
               }

               if (password.isEmpty())
               {
                   listener.onPasswordError();
                   return;
               }
               listener.onSuccess();
           }
       },1000);
    }
}
