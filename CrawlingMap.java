package com.example.a403_10.location;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class CrawlingMap {
    public LinkedList<String> getLatLng(String location) {
        //긁어오기
        NetworkUtil network = new NetworkUtil();
        String text = network.get("http://maps.googleapis.com/maps/api/geocode/json?address=" + location);

        LinkedList<String> resList = new LinkedList<String>();

        // 잘못된 위치
        int checkWord = text.indexOf("location", 0);
        if (checkWord == -1) {
            resList.add("error2");
            return resList;
        } else {
            //대한민국 외 제거
            int checkNat = text.indexOf("KR", 0);
            if (checkNat == -1) {
                //독도 예외
                if (location.equals("독도")) {
                    int latNum = text.indexOf("lat", text.indexOf("location"));
                    String lat = text.substring(latNum + 7, latNum + 13);
                    resList.add(lat);
                    int lngNum = text.indexOf("lng", text.indexOf("location"));
                    String lng = text.substring(lngNum + 7, lngNum + 13);
                    resList.add(lng);
                }
                resList.add("error1");
                return resList;
            }

            //위도 찾아서 append
            int latNum = text.indexOf("lat", text.indexOf("location"));
            String lat = text.substring(latNum + 7, latNum + 13);
            resList.add(lat);

            //경도 찾아서 append
            int lngNum = text.indexOf("lng", text.indexOf("location"));
            String lng = text.substring(lngNum + 7, lngNum + 13);
            resList.add(lng);

            return resList;
        }
    }
}

