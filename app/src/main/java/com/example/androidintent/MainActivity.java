package com.example.androidintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mNameEntry;
    private Button mSendData,gotoImplict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEntry = findViewById(R.id.et_text_entry);
        mSendData = findViewById(R.id.btton_send_data);
        gotoImplict = findViewById(R.id.btton_goto_implict);
        gotoImplict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startImplict = new Intent(MainActivity.this,ImplictActivity.class);
                startActivity(startImplict);

            }
        });
        mSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textenter = mNameEntry.getText().toString().trim();
                Intent i = new Intent(getApplicationContext(),ExplictActivity.class);
                i.putExtra(Intent.EXTRA_TEXT,textenter);
                startActivity(i);
            }
        });
    }
}