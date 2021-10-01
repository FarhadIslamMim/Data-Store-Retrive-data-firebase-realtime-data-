package com.example.stordataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView nametextview,agetextview,phonenumbertextview;
    private Button submitbutton,showdata;
    private ProgressBar progressBar;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference= FirebaseDatabase.getInstance().getReference("People Information");

        nametextview=findViewById(R.id.idnametextview);
        agetextview=findViewById(R.id.idagetextview);
        phonenumbertextview=findViewById(R.id.idphonenumbertextview);
        submitbutton=findViewById(R.id.idsubmitbutton);
        showdata=findViewById(R.id.idshowdata);

        submitbutton.setOnClickListener(this);
        showdata.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.idsubmitbutton)
        {
            saveData();
        }
        if (v.getId()==R.id.idshowdata)
        {
            Intent intent=new Intent(MainActivity.this,ShowDetails.class);
            startActivity(intent);
        }
    }

    private void saveData() {
        String name=nametextview.getText().toString().trim();
        String age=agetextview.getText().toString().trim();
        String phnnumber=phonenumbertextview.getText().toString().trim();

        String key=databaseReference.push().getKey();

        People people=new People(name,age,phnnumber);

        databaseReference.child(key).setValue(people);

        Toast.makeText(getApplicationContext(),"Information Added",Toast.LENGTH_SHORT).show();
        nametextview.setText("");
        agetextview.setText("");
        phonenumbertextview.setText("");


    }

}