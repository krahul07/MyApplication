package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MyAsyncTask extends AsyncTask<Void , Integer, String> {
    Context ctx;
    ProgressBar pb;
    Button dwnld;
    public MyAsyncTask(Context ctx, ProgressBar pb, Button dwnld){
        this.ctx = ctx;
        this.pb = pb;
        this.dwnld = dwnld;
    }

    @Override
    protected void onPreExecute() {
        pb.setProgress(0);
        pb.setVisibility(View.VISIBLE);
        // Here we are accessing and changing a UI element
        dwnld.setText("Cancel");
    }

    @Override
    protected String doInBackground(Void... voids){
        // ONLY this method runs in a Background thread
        try {
            for(int i=1; i<=10; i++){
                Thread.sleep(1000);
                publishProgress(i);
                dwnld.setOnClickListener(v -> {
                    cancel(true);
                    // Now since cancel is  invoked the onPostExecute() will not be called
                    // Hence, we need to do the cleanup or any other task here only.
                    Toast.makeText(ctx, "Download Stopped...", Toast.LENGTH_LONG).show();
                    pb.setVisibility(View.INVISIBLE);
                    dwnld.setText("Download");
                });
            }
            return "Completed";
        }
        catch (Exception e){
            return "Error occurred...";
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int prg = values[0];
        pb.setProgress(prg);
        // Note that we are now changing a UI element here
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(ctx, "File downloaded ...", Toast.LENGTH_LONG).show();
        pb.setVisibility(View.INVISIBLE);
        // Again, we are changing the UI elements visibility
        dwnld.setText("Download");
    }
}
