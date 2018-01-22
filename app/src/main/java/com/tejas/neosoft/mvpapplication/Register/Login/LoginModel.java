package com.tejas.neosoft.mvpapplication.Login;


import android.os.Handler;

/**
 * Created by webwerks1 on 11/1/18.
 */

public class LoginModel implements LoginContract.LoginModel {

    @Override
    public void login(final String username,final String password, final OnLoginFinishedListener listener) {

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               if (!username.contains("@")||username.isEmpty())
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
