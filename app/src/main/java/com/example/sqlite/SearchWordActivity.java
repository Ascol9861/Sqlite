package com.example.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.MyHelper;
import model.Word;

public class SearchWordActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etSearch;
    private Button btnSearch;
    private ListView lstSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_word);

        etSearch = findViewById(R.id.etSearch);
        btnSearch = findViewById(R.id.btnSearch);
        lstSearch = findViewById(R.id.lstSearch);

        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqlLiteDatabase = myHelper.getWritableDatabase();
        getWordByName(etSearch.getText().toString(), sqlLiteDatabase);

    }

    private void getWordByName(String word, SQLiteDatabase db) {
        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqlLiteDatabase = myHelper.getWritableDatabase();

        List <Word> wordList = new ArrayList<>();
        wordList = myHelper.GetAlWords(sqlLiteDatabase);

        HashMap<String, String> hashMap = new HashMap<>();
        for (int i =0; i<wordList.size(); i++){
            hashMap.put(wordList.get(i).getWord(), wordList.get(i).getMeaning());
        }

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(hashMap.keySet())
        );
        lstSearch.setAdapter(stringArrayAdapter);
    }
}
