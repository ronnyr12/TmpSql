package com.example.tmpsql;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class studentAdapter extends ArrayAdapter<Student> {
    Context context;
    List<Student> students;

    public studentAdapter(@NonNull Context context, int resource, @NonNull List<Student> students) {
        super(context, resource, students);
        this.context = context;
        this.students = students;
    }

/*
    public int getCount() {
        return students.size();
    }




    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater =((Activity)context).getLayoutInflater();
        View view= layoutInflater.inflate(R.layout.activity_student_adapter,parent,false);
        TextView Tname= (TextView)view.findViewById(R.id.Tname);
        TextView Tclaas= (TextView)view.findViewById(R.id.Tclaas);
        //ImageView Tavatar = (ImageView) view.findViewById(R.id.Tavatar);
        Student temp = students.get(position);

        Tname.setText(temp.getFirstName());
        Tclaas.setText(temp.getNumClass());
        return view;
    }*/
}
