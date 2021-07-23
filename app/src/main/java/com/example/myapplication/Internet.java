package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Internet extends AppCompatActivity {
    InternetTask it;

    EditText et;

    static TextView webText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);

        et = findViewById(R.id.searchBox);
        webText = findViewById(R.id.webText);

    }

    public void searchWeb(View view) {
        it = new InternetTask(Internet.this);
        String searchFor = et.getText().toString();
        it.execute(searchFor);
    }

    public void goToDownload(View view) {
        Intent intent = new Intent(this, Download.class);
        startActivity(intent);
    }
}