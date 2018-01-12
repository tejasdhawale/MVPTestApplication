package com.tejas.neosoft.mvpapplication.Login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tejas.neosoft.mvpapplication.Main.MainActivity;
import com.tejas.neosoft.mvpapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends Activity implements LoginContract.LoginView {

 /**
 * implements LoginView overrides it's functions & also using Butterknife lib to bindviews
 * **/


    @BindView(R.id.et_email)
    EditText et_email;
    @BindView(R.id.et_pass)
    EditText et_pass;
    @BindView(R.id.btn_submit)
    Button btn_submit;
    Context mContext;
    LoginPresenter presenter;
    @BindView(R.id.pb_progress)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mContext=this;

        presenter=new LoginPresenter(this,new LoginModel());
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
    public void invalidUserId() {
        et_email.setError("Email is Invalid");
        progressBar.setVisibility(View.GONE);
//      Toast.makeText(mContext,"Loginuser: Invalid UserEmail ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void invalidPass() {
        et_pass.setError("Invalid Password");
        progressBar.setVisibility(View.GONE);
//      Toast.makeText(mContext,"Loginuser: Invalid Password ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void successfullLogin() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(mContext,"Loginuser: Successfull login ", Toast.LENGTH_SHORT).show();
        mContext.startActivity(new Intent(LoginActivity.this, MainActivity.class));

    }

    @OnClick(R.id.btn_submit)
    public void Loginuser(View view)
    {
        String email=et_email.getText().toString();
        String pass=et_pass.getText().toString();
        Log.d("test", "Loginuser: Submit Clicked");

        presenter.validateLogin(email,pass);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestory();
        super.onDestroy();
    }

}

