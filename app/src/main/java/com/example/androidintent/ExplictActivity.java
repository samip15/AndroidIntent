package com.example.androidintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ExplictActivity extends AppCompatActivity {

    private TextView mDisplaytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explict);
        mDisplaytext = findViewById(R.id.tv_display);
        //get data from main activity

        Intent in = getIntent();
        if (getIntent().hasExtra(Intent.EXTRA_TEXT)){
            String textEntered = in.getStringExtra(Intent.EXTRA_TEXT);
            mDisplaytext.setText(textEntered);
        }
    }
}