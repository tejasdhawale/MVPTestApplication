package com.tejas.neosoft.mvpapplication.Login;

/**
 * Created by webwerks1 on 11/1/18.
 */
public interface LoginContract {
    /**note- tejas
     * contract is like set of rules,Anything that implements have to override its funtions
     * **/

    interface LoginView {
        /**
         * implemented by View of login
         * **/
     void showProgress();
     void hideProgress();
     void invalidUserId();
     void invalidPass();
     void successfullLogin();
    }
    interface LoginPresenter{
        void validateLogin(String email,String Pass);
        void onDestory();

    }
    interface LoginModel{
        interface OnLoginFinishedListener {
            void onUsernameError();
            void onPasswordError();
            void onSuccess();
        }

        void login(String username, String password, OnLoginFinishedListener listener);


    }
}
