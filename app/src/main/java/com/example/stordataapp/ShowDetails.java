package com.example.stordataapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowDetails extends AppCompatActivity {
    private ListView listView;
    DatabaseReference databaseReference;
    private List<People> peopleList;
    private CustomAdapter customAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        databaseReference= FirebaseDatabase.getInstance().getReference("People Information");

        peopleList=new ArrayList<>();
        customAdapter= new CustomAdapter(ShowDetails.this,R.layout.samplelayout,peopleList);

        listView=findViewById(R.id.idlistview);
    }

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                peopleList.clear();
                for(DataSnapshot dataSnapshot1: snapshot.getChildren() )
                {
                    People people=dataSnapshot1.getValue(People.class);
                    peopleList.add(people);
                }
                listView.setAdapter(customAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        super.onStart();
    }
}