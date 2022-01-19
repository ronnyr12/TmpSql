package com.example.tmpsql;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class studentAdapter extends AppCompatActivity {
    Context context;
    List<Student> objects;

    public studentAdapter(Context context, int resource, int textViewResourceld, List<Student> objects) {
        //super(context, resource,textViewResourceld,objects);
        this.context = context;
        this.objects = objects;

    }

    public int getCount() {
        return objects.size();
    }


    public Object getItem(int position) {
        return objects.get(position);
    }


    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater =((Activity)context).getLayoutInflater();
        View view= layoutInflater.inflate(R.layout.activity_student_adapter,parent,false);
        TextView Tname= (TextView)view.findViewById(R.id.Tname);
        TextView Tclaas= (TextView)view.findViewById(R.id.Tclaas);
        ImageView Tavatar = (ImageView) view.findViewById(R.id.Tavatar);
        Student temp = objects.get(position);

        Tavatar.setImageBitmap(temp.getBitmap());
        Tname.setText(temp.getFirstName());
        Tclaas.setText(temp.getNumClass());
        return view;
    }
}
