package com.tejas.neosoft.mvpapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity implements Maincontract.viewMain {

MainPresenter presenter;
  @BindView(R.id.et_email)
  EditText et_email;
    @BindView(R.id.et_pass)
    EditText et_pass;
    @BindView(R.id.btn_submit)
    Button btn_submit;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext=this;

        presenter=new MainPresenter(this);
    }



    @Override
    public void init() {


    }

    @Override
    public void successfullLogin() {
        Toast.makeText(mContext,"Loginuser: Successfull login ", Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.btn_submit)
    public void Loginuser(View view)
    {
        String temp=et_email.getText().toString();
        String temp_pass=et_pass.getText().toString();
        Log.e("test", "Loginuser: Submit Clicked By "+temp);
        Toast.makeText(mContext,"Loginuser: Submit Clicked By "+temp, Toast.LENGTH_SHORT).show();
        presenter.submitlogin(et_email,et_pass);
    }



}

