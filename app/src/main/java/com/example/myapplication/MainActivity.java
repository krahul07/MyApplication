package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater.from(getApplicationContext()).inflate(R.layout.custom_layout, null, false);

        Button tBtn = findViewById(R.id.toastBtn);

        tBtn.setOnClickListener( (View v) -> {
            Intent intent = new Intent(this, greetScreen.class);
            startActivity(intent);
        });
    }


    public void plusClick(View view) {
        TextView tv = findViewById(R.id.textView);
        Integer num = Integer.parseInt(tv.getText().toString());
        num += 1;
        tv.setText(num.toString());
    }


    public void subClick(View view) {
        TextView tv = findViewById(R.id.textView);
        Integer num = Integer.parseInt(tv.getText().toString());
        num -= 1;
        tv.setText(num.toString());
    }
}