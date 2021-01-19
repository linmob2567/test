package com.example.api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTvShow;
    BufferedReader bufferedReader;
    InputStream inputStream;
    HttpURLConnection connection;
    int GETDATA_SUCCESS=101;

    Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            if(msg.what==GETDATA_SUCCESS){
                String data=msg.getData().getString("data");
                Log.i("MainActivity",data);
                mTvShow.setText(data);
            }
            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initUI();
        initData();
    }

    private void initUI() {
        //获取文本框
        mTvShow = findViewById(R.id.tv_show);
        //获取按钮并且绑定监听者对象
        findViewById(R.id.btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        initData();
    }

    //必须在子线程请求网络，否则造成阻塞
    private void initData() {
        new Thread(new Runnable(){
            public void run(){
                String data=getDataFromServer();
                Log.i("MainActivity","获取数据为:"+data);

                //创建信息对象
                Message message = Message.obtain();
                Bundle bundle=new Bundle();
                bundle.putString("data",data);
                message.setData(bundle);
                message.what=GETDATA_SUCCESS;
                mHandler.sendMessage(message);
            }
        }).start();
    }
    private String getDataFromServer(){
        try{
            URL url=new URL("https://v1.hitokoto.cn/?c=f&encode=text");
            connection = (HttpURLConnection) url.openConnection();
            if(connection.getResponseCode()==200){
                inputStream = connection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                for(String line="";(line=bufferedReader.readLine())!=null;){
                    stringBuilder.append(line);
                }
                return stringBuilder.toString();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(bufferedReader!=null)bufferedReader.close();
                if(inputStream!=null)inputStream.close();
                if(connection!=null)connection.disconnect();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "";
    }
}
