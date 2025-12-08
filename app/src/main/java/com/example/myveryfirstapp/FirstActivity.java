package com.example.myveryfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", "onCreate Called");
        setContentView(R.layout.first_activity);

        Button btn = findViewById(R.id.gotosecond);
        btn.setOnClickListener(v->{
            //explicit intent
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("myname","Ram Thapa");
            intent.putExtra("myphone","9851043657");
            startActivity(intent);
        });

        Button webutton = findViewById(R.id.openweb);
        webutton.setOnClickListener(v->{
            //implicit intent
            String url = "https://www.google.com";
            Intent intentbrowser = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intentbrowser);
        });

        Button loadfirstfrag = findViewById(R.id.loadfirstfrag);
        loadfirstfrag.setOnClickListener(v->{
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer,FirstFragment.class,null).commit();
        });
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("FirstActivity", "onStart Called");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d("FirstActivity", "onPause Called");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d("FirstActivity", "onResume Called");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d("FirstActivity", "onStop Called");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("FirstActivity", "onDestroy Called");
    }

    @Override
    public void onRestart(){
        super.onRestart();
        Log.d("FirstActivity", "onRestart Called");
    }
}
