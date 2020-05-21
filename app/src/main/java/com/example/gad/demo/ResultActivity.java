package com.example.gad.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ResultActivity extends AppCompatActivity
{
    public static final int REQUEST_CODE            = 100;

    public static final int RESULT_CODE_NO          = 0;
    public static final int RESULT_CODE_YES         = 1;
    public static final int RESULT_CODE_CANCEL      = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void doEndWithResultYes(View view) {
        setResult(RESULT_CODE_YES);
        finish();
    }

    public void doEndWithResultNo(View view) {
        setResult(RESULT_CODE_NO);
        finish();
    }

    public void doEndWithResultCancel(View view) {
        setResult(RESULT_CODE_CANCEL);
        finish();
    }
}
