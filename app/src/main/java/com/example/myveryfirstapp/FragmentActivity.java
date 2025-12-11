package com.example.myveryfirstapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment);
        Button firstbutton = findViewById(R.id.firstfragment);
        Button secondbutton = findViewById(R.id.secondfragment);
        Button gotofirst = findViewById(R.id.gotofirst);

        Button openalert = findViewById(R.id.openalert);

        openalert.setOnClickListener(v->{
            //open alert dialogue
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Do you want to continue?");
            builder.setMessage("If you clicked yes, you will be taken to another activity");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", (dialog,id)->{
                Toast.makeText(this, "You clicked yes", Toast.LENGTH_SHORT).show();

            });
            builder.setNegativeButton("No", (dialog,id)->{
                Toast.makeText(this, "You clicked no", Toast.LENGTH_SHORT).show();
            });
            builder.show();

        });

        Button pickadate = findViewById(R.id.pickdate);
        EditText dob = findViewById(R.id.dob);
        pickadate.setOnClickListener(v->{
            //Display Date Picker
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view, yy, mm, dd) -> dob.setText(dd + "-" + (mm + 1) + "-" + yy), mYear, mMonth, mDay);
            datePickerDialog.show();

        });

        Button loadcontext = findViewById(R.id.loadcontextmenu);
        registerForContextMenu(loadcontext);

        Button loadpop = findViewById(R.id.loadpopupmenu);
        loadpop.setOnClickListener(v->{
        //show popup menu
            PopupMenu popup = new PopupMenu(this,v);
            popup.inflate(R.menu.popup_menu);
            popup.show();

            //popup menu event handling
            popup.setOnMenuItemClickListener(item->{
            Toast.makeText(this,"Popup Clicked: "+item.getTitle(),Toast.LENGTH_LONG).show();
            return true;
            });

        });

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
    //option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return true;
    }

    //option menu event handling
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Toast.makeText(this,"Item Selected: "+ item.getTitle(),Toast.LENGTH_LONG).show();
        Integer itemid = item.getItemId();
        if(itemid==0){
            // write your action
        }
        return true;
    }

    //Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("Select Item");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        Toast.makeText(this, "Item Selected: "+item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }

}