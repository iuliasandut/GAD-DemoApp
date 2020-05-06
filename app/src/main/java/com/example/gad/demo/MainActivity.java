package com.example.gad.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import static android.R.layout.simple_spinner_item;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] data_source = {"Timisoara", "Cluj", "Iasi", "Bucuresti"};

        // get a reference to the spinner view declared in layout xml
        Spinner spinner = findViewById(R.id.actMain_ddCities);

        // create a basic array adapter and specify the layout for the item
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, simple_spinner_item, data_source);

        // specify the layout for the dropdown list items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }


}
