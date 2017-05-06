package com.erpproject.androidapp.webservicesregisterapp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Eslam on 5/6/2017.
 */

public class BachServerTask extends AsyncTask<String ,String ,String> {



    Context context;
    public BachServerTask(Context context){

        this.context=context;
    }
    String register_url = "http://192.168.177.1/formuser/register.php";
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context.getApplicationContext(),s,Toast.LENGTH_LONG).show();

    }

    @Override
    protected String doInBackground(String... params) {

        String getkey = params[0];
        if(getkey.equals("RegisterData")){

            String name = params[1];
        String username = params[2];
        String  email = params[3];
        String password = params[4];
            try {
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream  outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String data =
                        URLEncoder.encode("name","UTF-8") +"="+URLEncoder.encode(name,"UTF-8")+"&"+
                                URLEncoder.encode("user_name","UTF-8") +"="+URLEncoder.encode(username,"UTF-8")+"&"+
                                URLEncoder.encode("email","UTF-8") +"="+URLEncoder.encode(email,"UTF-8")+"&"+
                                URLEncoder.encode("password","UTF-8") +"="+URLEncoder.encode(password,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();


                return  "succes data";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
