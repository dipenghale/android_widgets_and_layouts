package com.example.myveryfirstapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtview = findViewById(R.id.txtview1);
        EditText edt_txt = findViewById(R.id.edt_text1);
        Button btn = findViewById(R.id.btnsubmit);

        CheckBox sports = findViewById(R.id.sports);
        CheckBox ent = findViewById(R.id.ent);
        CheckBox health = findViewById(R.id.health);



        btn.setOnClickListener(v->{
            String txt = edt_txt.getText().toString();
            if(txt.isEmpty()) {
                txtview.setText("Enter Text!");
            }
            else {

                Toast tst = Toast.makeText(this, txt, Toast.LENGTH_LONG);
                tst.show();
            }

            RadioGroup radioGroup = findViewById(R.id.gender);
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                String selectedText = selectedRadioButton.getText().toString();
                //Toast.makeText(this, "Selected: "+selectedText,Toast.LENGTH_SHORT).show();
                // Now 'selectedText' holds the text of the selected radio button
                txtview.setText("Gender: "+selectedText);
            }

            if(sports.isChecked()){
                String sports_text = sports.getText().toString();
                txtview.setText("Interest: "+sports_text);
            }


        });
        Spinner mySpinner = findViewById(R.id.country);
        ArrayList<String> spinnerItems;
        ArrayAdapter<String> adapter;
        spinnerItems = new ArrayList<>();
        // Initialize with some default items if needed
        spinnerItems.add("Nepal");
        spinnerItems.add("India");
        spinnerItems.add("Bhutan");
        spinnerItems.add("Srilanka");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        ImageView myImageView = findViewById(R.id.my_image);
        myImageView.setImageResource(R.drawable.padmakanya); // "my_image" is the name of your image file in drawable


    }
}