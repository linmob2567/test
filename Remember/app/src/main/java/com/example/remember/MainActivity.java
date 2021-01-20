package com.example.remember;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtPhone;
    private EditText mEtPasswd;
    private CheckBox mPsd;
    private String SP_PHONE="sp_phone";
    private String SP_PASSWD="sp_passwd";
    private SharedPreferences sharedPreferences;
    private String SP_IS_REMEMBER="sp_is_remember";
    private boolean isCheck=false;
    private String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initData();
    }

    private void initData() {
        if(sharedPreferences==null){
            sharedPreferences=getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        mEtPhone.setText(sharedPreferences.getString(SP_PHONE,""));
        mEtPasswd.setText(sharedPreferences.getString(SP_PASSWD,""));
        isCheck=sharedPreferences.getBoolean(SP_IS_REMEMBER,false);
        Log.i(TAG,"测试:"+isCheck);
        mPsd.setChecked(isCheck);
    }

    private void initUI() {
        mEtPhone=findViewById(R.id.et_phone);
        mEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(isCheck){
                    if(sharedPreferences==null){
                        sharedPreferences=getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
                    }
                    SharedPreferences.Editor edit=sharedPreferences.edit();
                    edit. putString(SP_PHONE,mEtPhone.getText().toString());
                    edit.commit();
                }

            }
        });
        mEtPasswd=findViewById(R.id.et_passwd);
        mEtPasswd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(isCheck){
                    if(sharedPreferences==null){
                        sharedPreferences=getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
                    }
                    SharedPreferences.Editor edit=sharedPreferences.edit();
                    edit.putString(SP_PASSWD,mEtPasswd.getText().toString());
                    edit.commit();
                }

            }
        });
        mPsd=findViewById(R.id.cb_remember_psd);
        mPsd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG,"状态为："+isChecked);
                isCheck=isChecked;

                if(sharedPreferences==null){
                    sharedPreferences=getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);
                }
                SharedPreferences.Editor edit=sharedPreferences.edit();
                if(isChecked){
                    edit. putString(SP_PHONE,mEtPhone.getText().toString());
                    edit.putString(SP_PASSWD,mEtPasswd.getText().toString());
                }
                edit.putBoolean(SP_IS_REMEMBER,isChecked);
                edit.commit();
            }
        });

    }
}
