package com.tejas.neosoft.mvpapplication.Register;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.tejas.neosoft.mvpapplication.Main.MainActivity;
import com.tejas.neosoft.mvpapplication.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class RegisterActivity extends Activity implements RegisterContract.RegisterView {

 /**
 * implements RegisterView overrides it's functions & also using Butterknife lib to bindviews
 * **/


    @BindView(R.id.et_f_name)
    EditText etFirstName;
    @BindView(R.id.et_l_name)
    EditText etLastname;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.et_cpass)
    EditText etCpass;
    @BindView(R.id.sp_gender)
    Spinner spGender;
    @BindView(R.id.et_phone)
            EditText etPhone;




    String genderdata=null;

    @BindView(R.id.btn_submit)
    Button btn_submit;
    Context mContext;

    RegisterPresenter presenter;
    @BindView(R.id.pb_progress)
    ProgressBar progressBar;
    ArrayList<String> genderList= new ArrayList<String>();
    private String tag="RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mContext=this;
        presenter=new RegisterPresenter(this,new RegisterModel());
        initSp();


    }

    private void initSp() {

        genderList.add("M");
        genderList.add("F");

        ArrayAdapter<String> adapter =new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,genderList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGender.setAdapter(adapter);
        spGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(tag, "onItemSelected: "+genderList.get(position));
                genderdata=genderList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                Log.d(tag, "onNothingSelected: ");
            }
        });
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
        etEmail.setError("Email is Invalid");
        progressBar.setVisibility(View.GONE);
//      Toast.makeText(mContext,"Reg: Invalid UserEmail ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void invalidPass() {
        etPass.setError("Invalid Password");
        progressBar.setVisibility(View.GONE);
//      Toast.makeText(mContext,"Reg: Invalid Password ", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void successfullRegister() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(mContext,"Reg: Successfull Register ", Toast.LENGTH_SHORT).show();
        mContext.startActivity(new Intent(RegisterActivity.this, MainActivity.class));

    }

    @OnClick(R.id.btn_submit)
    public void Registeruser(View view)
    {
        String fname=etFirstName.getText().toString();
        String lname=etLastname.getText().toString();
        String email=etEmail.getText().toString();
        String pass=etPass.getText().toString();
        String cpass=etCpass.getText().toString();
        String phone=etPhone.getText().toString();
        Log.d(tag, "Reg: Submit Clicked");

        presenter.validateRegister(fname,lname,email,pass,cpass,genderdata,phone);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestory();
        super.onDestroy();
    }

}

