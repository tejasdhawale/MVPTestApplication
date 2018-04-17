package com.tejas.neosoft.mvpapplication.Main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.tejas.neosoft.mvpapplication.Main.Adapter.SampleAdapter;
import com.tejas.neosoft.mvpapplication.Main.model.Datum;
import com.tejas.neosoft.mvpapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by webwerks1 on 12/1/18.
 */

public  class MainActivity extends Activity implements MainContract.mainView{
    @BindView(R.id.rv_1)
    RecyclerView recyclerView;
    private MainPresenter mPresenter;
    LinearLayoutManager linearLayoutManager;
    SampleAdapter itemAdapter;
    Context mContext;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext=this;
        mPresenter = new MainPresenter(this);
        mPresenter.getDataFromURL(getApplicationContext(), "");
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    @Override
    public void showMessage(String message) {
        Toast.makeText(this,"Clicked :"+message,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onGetDataSuccess(String message, List<Datum> list) {
        itemAdapter = new SampleAdapter(mContext, list,new MainPresenter(this));
        recyclerView.setAdapter(itemAdapter);
    }
    @Override
    public void onGetDataFailure(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
