package com.example.gad.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity
{
    // initializing sample data source
    private ArrayList<String> mContactsDataSource = new ArrayList<String>() {{
        add("Post Malone");
        add("Jimmy McNulty");
        add("Tony Stark");
        add("Bucky Barnes");
        add("Ellen Ripley");
        add("Dwayne Hicks");
        add("Clark Kent");
        add("Thomas Wayne");
        add("Bruce Wayne");
        add("Diana Prince");
        add("Ororo Munroe");
        add("Miles Morales");
        add("Frodo Baggins");
        add("Bilbo Baggins");
        add("Gandalf the Grey");
        add("Rand al-Thor");
        add("Kima Greggs");
        add("Charles Xavier");
        add("Jean Grey");
        add("Steve Rogers");
        add("Bruce Banner");
        add("Peter Parker");
        add("Steven Strange");
        add("Steve Summers");
        add("Alex Summers");
    }};

    private ContactsAdapter mAdapter;
    private RecyclerView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = findViewById(R.id.actMain_listContacts);
        mList.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ContactsAdapter(mContactsDataSource);
        mList.setAdapter(mAdapter);
    }
}
