package com.example.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ViewWords extends AppCompatActivity {

    private EditText etMeaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_words);

        etMeaning = findViewById(R.id.etMeaning);

    }
}
