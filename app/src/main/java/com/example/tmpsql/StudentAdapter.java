package com.example.tmpsql;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentAdapter extends BaseAdapter {
    ArrayList<Student> students;
    Context context;

    public StudentAdapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }


    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Student student = students.get(i);

        view = LayoutInflater.from(context).inflate(R.layout.row_list_student,null);

        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_class = view.findViewById(R.id.tv_class);
        TextView tv_avg = view.findViewById(R.id.tv_avg);

        tv_name.setText(student.getFirstName()+" "+student.getLastName());
        tv_class.setText(student.getNumClass());
        tv_avg.setText(String.valueOf(student.getAvgGrade()));

        return  view;

    }
}
