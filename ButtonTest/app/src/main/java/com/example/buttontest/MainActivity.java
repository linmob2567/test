package com.example.buttontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt2).setOnClickListener(this);
        bt3=findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Button 3 clickd", LENGTH_LONG).show();
            }
        });

    }

    public void button_nn(View view) {
        Toast.makeText(getApplicationContext(),"Button 1 clickd",Toast.LENGTH_LONG).show();
    }

    public void onClick(View v) {
        if(v.getId()==R.id.bt2)
        {
            Toast.makeText(getApplicationContext(),"Button 2 clicked",Toast.LENGTH_LONG).show();
        }
    }
}