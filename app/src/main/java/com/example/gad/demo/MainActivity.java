package com.example.gad.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gad.demo.adapter.ChatAdapter;
import com.example.gad.demo.model.ChatMessage;
import com.example.gad.demo.model.MessageSource;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView mTaskList;
    private ArrayList<ChatMessage> mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get a reference to the recycler view
        mTaskList = findViewById(R.id.actMain_listTasks);
        mTaskList.hasFixedSize();

        // set the layout manager for that recycler view
        RecyclerView.LayoutManager llm = new LinearLayoutManager(this);
        mTaskList.setLayoutManager(llm);

        // create a mocked data source
        mDataSource = new ArrayList<ChatMessage>();
        for (int i = 0; i < 60; i++) {

            // generate a random source
            MessageSource source = (new Random().nextInt() % 2 == 0) ? MessageSource.PERSON_A : MessageSource.PERSON_B;

            // generate a task, alternate between status "true" and "false"
            mDataSource.add(new ChatMessage(source, "Message #"+i));
        }

        // create a new adapter instance for a data-source
        ChatAdapter adapter = new ChatAdapter(mDataSource);

        // set adapter to the recycler view
        mTaskList.setAdapter(adapter);
    }
}
