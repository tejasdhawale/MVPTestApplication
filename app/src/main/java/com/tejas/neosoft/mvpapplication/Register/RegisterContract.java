package com.tejas.neosoft.mvpapplication.Register;

/**
 * Created by webwerks1 on 11/1/18.
 */
public interface RegisterContract {
    /**note- tejas
     * contract is like set of rules,Anything that implements have to override its funtions
     * **/

    interface RegisterView {
        /**
         * implemented by View of Register
         * **/
     void showProgress();
     void hideProgress();
     void invalidUserId();
     void invalidPass();
     void successfullRegister();
    }
    interface RegisterPresenter {
        /**
         * implemented by Presenter of Register
         * **/
        void validateRegister(String Fname,String Lname,String email, String Pass,String CPass,String Gender,String Phone);
        void onDestory();

    }
    interface RegisterModel {
        /**
         * implemented by model of Register
         * **/
        interface OnRegisterFinishedListener {
            void onUsernameError();
            void onPasswordError();
            void onSuccess();
        }

        void Register(String Fname,String Lname,String Email, String password,String CPass, String Gender,String Phone,OnRegisterFinishedListener listener);

    }
}
