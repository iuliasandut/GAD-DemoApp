package com.example.gad.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import static android.R.layout.simple_spinner_item;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{

    private static final String[] DATA_SOURCE = {"Timisoara", "Cluj", "Iasi", "Bucuresti"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get a reference to the spinner view declared in layout xml
        Spinner spinner = findViewById(R.id.actMain_ddCities);

        // create a basic array adapter and specify the layout for the item
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, simple_spinner_item, DATA_SOURCE);

        // specify the layout for the dropdown list items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // option 1 -> setting the listener using the interface implementation on the current class
        // spinner.setOnItemSelectedListener(this);

        // option 2 -> setting the listener using an inner class
        // option 2.5 -> you may externalise inner class to it's own file
        // spinner.setOnItemSelectedListener(new MyInnerSpinnerListener());

        // option 3 -> setting the listener as an anonymous implementation of the interface
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tvSelectedCity = findViewById(R.id.actMain_tvSelectedCity);
                String selected_city = DATA_SOURCE[position];

                tvSelectedCity.setText(selected_city);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {}
        });
    }


    /* Methods below implement the interface AdapterView.OnItemSelectedListener */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView tvSelectedCity = findViewById(R.id.actMain_tvSelectedCity);
        String selected_city = DATA_SOURCE[position];

        tvSelectedCity.setText(selected_city);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {}


    /* Inner class implementing the interface AdapterView.OnItemSelectedListener */
    public class MyInnerSpinnerListener implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            TextView tvSelectedCity = findViewById(R.id.actMain_tvSelectedCity);
            String selected_city = DATA_SOURCE[position];

            tvSelectedCity.setText(selected_city);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent)
        {}
    }

}
