package com.example.myapplication;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    ProgressBar pb;
    MyAsyncTask mat;
    Button dwnld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LinearLayout mainLayout = findViewById(R.id.mainLayout);
//        LinearLayout subLayout = findViewById(R.id.subLayout);

//        View view = getLayoutInflater().inflate(R.layout.custom_layout, subLayout);
////        View view = getLayoutInflater().inflate(R.layout.custom_layout, null);
////        subLayout.addView(view);
//
////        Button tBtn = findViewById(R.id.toastBtn);
        findViewById(R.id.toastBtn).setOnClickListener( (View v) -> {
            Intent intent = new Intent(this, greetScreen.class);
            startActivity(intent);
        });

        pb = findViewById(R.id.myProgressBar);
        dwnld = findViewById(R.id.download);
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

    public void ProgressClicked(View view) {
        mat = new MyAsyncTask(MainActivity.this, pb, dwnld);
        mat.execute();
    }

    public void useInternet(View view) {
        Intent intent = new Intent(this, Internet.class);
        startActivity(intent);
    }
}