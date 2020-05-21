package com.example.gad.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UppercaseActivity extends AppCompatActivity
{
    public static final int REQUEST_CODE = 200;

    public static final int RESULT_CODE_UPPERCASE = 100;

    public static final String KEY_EXAMPLE_TEXT = "com.example.gad.intent.extra.keys.EXAMPLE_TEXT";

    private String mExampleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uppercase);

        Intent starting_intent = getIntent();
        mExampleText = starting_intent.getExtras().getString(KEY_EXAMPLE_TEXT);
    }

    public void doUppercaseAndFinish(View view) {
        Intent result_intent = new Intent();
        result_intent.putExtra(KEY_EXAMPLE_TEXT, mExampleText.toUpperCase());

        setResult(RESULT_CODE_UPPERCASE, result_intent);
        finish();
    }

}
