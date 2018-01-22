package com.tejas.neosoft.mvpapplication.RxRetro;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tejas.neosoft.mvpapplication.R;
import com.tejas.neosoft.mvpapplication.RxRetro.Adapter.RxRetroListAdapter;
import com.tejas.neosoft.mvpapplication.RxRetro.nw.Data;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RxRetroActivity extends Activity implements RxRetroContract.RxRetroView{

 /**
 * implements RegisterView overrides it's functions & also using Butterknife lib to bindviews
 * **/


    @BindView(R.id.tv_page)
    TextView tv_page;
    @BindView(R.id.tv_per_page)
    TextView tv_per_page;
    @BindView(R.id.tv_total)
    TextView tv_total;
    @BindView(R.id.tv_total_pages)
    TextView tv_total_pages;
    @BindView(R.id.rv_rv1)
    RecyclerView recyclerView;


    String genderdata=null;

    @BindView(R.id.btn_submit)
    Button btn_submit;
    Context mContext;

    RxRetroPresenter presenter;
    @BindView(R.id.pb_progress)
    ProgressBar progressBar;
    LinearLayoutManager linearLayoutManager;
    RxRetroListAdapter itemAdapter;
    private String tag="RxRetroView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxretro);
        ButterKnife.bind(this);
        mContext=this;
        presenter=new RxRetroPresenter(this);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,"Clicked :"+message,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void invalidCall() {

        progressBar.setVisibility(View.GONE);
        Toast.makeText(mContext,"Reg: invalidCall ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void successfulCall(String page, String per_page, String total, String totalpage, List<Data> dataList) {
        progressBar.setVisibility(View.GONE);
        Log.d(tag, "View: successfulCall ()");
        tv_page.setText("page :"+page);
        tv_per_page.setText("per page :"+per_page);
        tv_total.setText("Total:"+total);
        tv_total_pages.setText("Total page:"+totalpage);
        itemAdapter = new RxRetroListAdapter(getApplicationContext(), dataList,new RxRetroPresenter(this));
        recyclerView.setAdapter(itemAdapter);
        Toast.makeText(mContext,"Reg: Successful call ", Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btn_submit)
    public void RegisterUser(View view)
    {
        Log.d(tag, "Reg: Submit Clicked");
        presenter.RequestHitFromModel();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestory();
        super.onDestroy();
    }


}

