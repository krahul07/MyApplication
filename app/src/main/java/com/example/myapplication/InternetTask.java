package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InternetTask extends AsyncTask<String , String, String> {

    Context context;

    public InternetTask(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... searchFor) {
        String src = searchFor[0];
        InputStream istream;
        // Now we have our url inside of src String, but we need to convert it to URL object:
        try {
            URL currUrl = new URL(src);

            // Now we need to open HTTP connection for the currUrl:
            HttpURLConnection myCon = (HttpURLConnection) currUrl.openConnection();

            // Set some optional connection configuration:
            myCon.setReadTimeout(10000);
            myCon.setConnectTimeout(20000);
            myCon.setRequestMethod("GET");

            // finally connect it to the web page:
            myCon.connect();

            // Now read the values form the web page:
            istream = myCon.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
            StringBuilder output = new StringBuilder();
            String line ="";

            while((line = reader.readLine())!=null){
                output.append(line+" \n");
//                publishProgress(output.toString());
            }

            //finally close the open streams
            reader.close();
            istream.close();

//          return the output to the onPostExecute:
            return output.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        if(s!=null)Internet.webText.setText(s);
        else Internet.webText.setText("Something went wrong..");
    }

}
