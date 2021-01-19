package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();

        User user=new User();
        user.setId(1);
        user.setName("小芳");
        intent.putExtra("user",user);
        intent.putExtra("name","李明");
        switch (v.getId()){
            case R.id.bt1:
                intent.setClass(getApplicationContext(),a.class);
                break;
            case R.id.bt2:
                intent.setClass(getApplicationContext(),b.class);
                break;
        }
        this.startActivity(intent);
    }
}
