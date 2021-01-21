package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.addapt.BaseAddapt;
import com.example.listview.bin.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        //初始化数据
        initData();
    }

    private void initData() {
        List<Student> students = new ArrayList<>();
        for(int i=0;i<100;i++){
            students.add(new Student(i,"学生"+i,"描述"+i));
        }
        //实例化构造器
        BaseAddapt myAdapter = new BaseAddapt(students,getApplicationContext());
        mListView.setAdapter(myAdapter);
        //注册点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"当前位置："+position,Toast.LENGTH_LONG);
            }
        });
    }

    private void initUI() {
        mListView = findViewById(R.id.list_view);
        
    }
}
