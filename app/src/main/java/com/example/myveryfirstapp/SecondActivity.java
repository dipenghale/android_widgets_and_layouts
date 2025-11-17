package com.example.myveryfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_actity);
        TextView msg = findViewById(R.id.displaymsg);
         Bundle bundle = getIntent().getExtras();
         if(bundle!=null){

             String name = bundle.getString("myname");
             String phone = bundle.getString("myphone");
             msg.setText("Name: "+name+" Phone: "+phone);
         }

        Button btn = findViewById(R.id.gotofirst);
        btn.setOnClickListener(v->{
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
        });

    }
}