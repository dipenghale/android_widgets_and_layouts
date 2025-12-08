package com.example.myveryfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment);
        Button firstbutton = findViewById(R.id.firstfragment);
        Button secondbutton = findViewById(R.id.secondfragment);
        Button gotofirst = findViewById(R.id.gotofirst);
        firstbutton.setOnClickListener(v->{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentcontainer, FirstFragment.class, null)
                    .commit();
            


        });

        secondbutton.setOnClickListener(v->{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentcontainer, SecondFragment.class, null)
                    .commit();

        });

        gotofirst.setOnClickListener(v->{
            Intent intent = new Intent(this,FirstActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(this,"Item Selected: "+ item.getTitle(),Toast.LENGTH_LONG).show();
        Integer itemid = item.getItemId();
        if(itemid==0){

        }
        return true;
    }
}