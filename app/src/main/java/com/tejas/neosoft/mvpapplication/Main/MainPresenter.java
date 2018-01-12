package com.tejas.neosoft.mvpapplication.Main;

/**
 * Created by webwerks1 on 12/1/18.
 */

public class MainPresenter implements MainContract.mainPresenter{
    MainContract.mainView mView;

    public MainPresenter(MainContract.mainView view) {
        mView=view;

    }
}
