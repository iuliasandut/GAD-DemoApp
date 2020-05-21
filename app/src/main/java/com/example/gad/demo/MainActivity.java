package com.example.gad.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void doLaunchWithImplicitIntent(View view)
    {
        Intent intent = new Intent(SecondActivity.LAUNCH_INTENT);
        startActivity(intent);
    }

    public void doLaunchWithImplicitExplicit(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void doLaunchActivityForResult(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        startActivityForResult(intent, ResultActivity.REQUEST_CODE);
    }

    public void doLaunchActivityForResultWithResponse(View view) {
        Intent intent = new Intent(this, UppercaseActivity.class);
        intent.putExtra(UppercaseActivity.KEY_EXAMPLE_TEXT, "sample_text");

        startActivityForResult(intent, UppercaseActivity.REQUEST_CODE);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ResultActivity.REQUEST_CODE) {
            if (resultCode == ResultActivity.RESULT_CODE_YES) {
                Toast.makeText(this, "Result returned: YES", Toast.LENGTH_SHORT).show();
            }

            if (resultCode == ResultActivity.RESULT_CODE_NO) {
                Toast.makeText(this, "Result returned: NO", Toast.LENGTH_SHORT).show();
            }

            if (resultCode == ResultActivity.RESULT_CODE_CANCEL) {
                Toast.makeText(this, "Result returned: CANCEL", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == UppercaseActivity.REQUEST_CODE) {
            if (resultCode == UppercaseActivity.RESULT_CODE_UPPERCASE) {
                if (data != null) {
                    String result_text = data.getExtras().getString(UppercaseActivity.KEY_EXAMPLE_TEXT);
                    Toast.makeText(this, "Result returned: " + result_text, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
