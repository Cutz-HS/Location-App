package com.example.a403_10.location;

import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class NetworkUtil {
    public String get(String address) {

        // TODO 자바의 Thread 로 변경 필요
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL(address);
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader reader = new BufferedReader(isr);

            String separator = "";
            //Log.e("tagtag", "get1");

            while (true) {
                String data = reader.readLine();
                if (data == null) {
                    //Log.e("breakdata", data.toString());
                    break;
                }
                result.append(separator + data);
                separator = "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}