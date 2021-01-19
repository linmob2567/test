package com.example.myapplication1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class a extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a);

        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        Log.i("a","获取的名字是"+name);

        TextView tvshow = findViewById(R.id.tvshow);
        tvshow.setText("姓名："+name);
    }
}
