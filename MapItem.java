package com.example.a403_10.location;

import android.content.Context;
import android.util.Log;

public class MapItem {
    String name;
    int resId;

    public MapItem (String name) {
        this.name=name;
    }

    public MapItem (String name, int resId) {
        this.name=name;
        this.resId=resId;
        Log.e("bgbg",name);
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

}