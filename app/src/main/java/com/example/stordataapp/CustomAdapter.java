package com.example.stordataapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<People> {
    private Activity context;
    private List<People> peopleList;

    public CustomAdapter(Activity context, int resource,List<People> peopleList) {
        super(context, R.layout.samplelayout, peopleList);
        this.context = context;
        this.peopleList = peopleList;
    }




    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.samplelayout,null,true);

        People people=peopleList.get(position);

        TextView tn= view.findViewById(R.id.idnametextview);
        TextView ta= view.findViewById(R.id.idagetextview);
        TextView tp= view.findViewById(R.id.idphntextview);

        tn.setText("Name : "+people.getNaem());
        ta.setText("Age : "+people.getAge());
        tp.setText("Phone N. : "+people.getPhnnumber());


        return view;
    }
}
