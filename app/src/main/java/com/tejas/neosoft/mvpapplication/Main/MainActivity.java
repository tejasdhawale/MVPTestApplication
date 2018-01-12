package com.tejas.neosoft.mvpapplication.Main;

import android.app.Activity;
import android.os.Bundle;

import com.tejas.neosoft.mvpapplication.R;

/**
 * Created by webwerks1 on 12/1/18.
 */

public class MainActivity extends Activity implements MainContract.mainView{

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
