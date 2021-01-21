package com.example.listview.addapt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.listview.R;
import com.example.listview.bin.Student;

import java.util.List;

public class BaseAddapt extends BaseAdapter {
    private final List<Student> students;
    private final Context context;
    public BaseAddapt(List<Student> students, Context context){
        this.students=students;
        this.context = context;
    }
    public int getCount(){
        return students.size();
    }
    public Object getItem(int position){
        return students.get(position);
    }
    public long getItemId(int position){
        return students.get(position).getId();
    }
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item_list,null);
        }
        //将数据集合设置到条目中
        TextView name=convertView.findViewById(R.id.tv_name);
        TextView des=convertView.findViewById(R.id.tv_des);
        name.setText(students.get(position).getName());
        des.setText(students.get(position).getDes());
        return convertView;
    }

}
