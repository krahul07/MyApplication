package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Download extends AppCompatActivity {
    EditText et2;
    static ImageView img;
    DownloadTask dt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        et2 = findViewById(R.id.findBox);
        img = findViewById(R.id.img);
    }

    public void downloadImage(View view) {
        dt = new DownloadTask();
        String src = et2.getText().toString();
        dt.execute(src);
    }
}