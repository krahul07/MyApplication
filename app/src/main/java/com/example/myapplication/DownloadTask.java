package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, Bitmap> {

    @Override
    protected Bitmap doInBackground(String... strings) {
        String src = strings[0];
        InputStream istream;

        try {
            URL url = new URL(src);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(20000);
            conn.setReadTimeout(10000);
            conn.setRequestMethod("GET");
            conn.connect();
            istream = conn.getInputStream();

            // Upto this the code for almost every internet query is same

            Bitmap bmap = BitmapFactory.decodeStream(istream);

            istream.close();
            return bmap;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        Download.img.setImageBitmap(bitmap);
    }
}
