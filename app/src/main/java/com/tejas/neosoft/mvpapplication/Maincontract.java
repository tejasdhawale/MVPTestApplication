package com.tejas.neosoft.mvpapplication;

/**
 * Created by webwerks1 on 11/1/18.
 */
public interface Maincontract {
    interface viewMain{
     void init();
     void successfullLogin();
    }
    interface presenterMain{

    }
    interface modelMain{
        interface OnLoginFinishedListener {
            void onUsernameError();

            void onPasswordError();

            void onSuccess();
        }

        void login(String username, String password, OnLoginFinishedListener listener);


    }
}
