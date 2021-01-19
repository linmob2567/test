package com.example.myapplication1;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class b extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b);

        Bundle bundle=getIntent().getExtras();
        User user=(User) bundle.getSerializable("user");
        Log.i("b","姓名："+user.getName()+"id是："+user.getId());

        TextView tvshow = findViewById(R.id.tvshow);
        tvshow.setText("姓名："+user.getName()+"id是："+user.getId());
    }
}
