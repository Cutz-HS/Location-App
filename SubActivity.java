package com.example.a403_10.location;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //intent.get(location 받아오기) & location 출력
        Intent intent = getIntent();
        final String location = intent.getStringExtra("location");
        TextView tv1 = findViewById(R.id.tv1);
        tv1.setText(location);

        //Latitude & Longitude 출력
        TextView tv2 = findViewById(R.id.lat);
        TextView tv3 = findViewById(R.id.lon);
        String lat=intent.getStringExtra("lat");
        String lng=intent.getStringExtra("lng");
        tv2.setText("위도 "+lat);
        tv3.setText("경도 "+lng);

        //ArrayList
        ArrayList<String> mapList= new ArrayList<String>();
        mapList.add("NAVER"); mapList.add("DAUM"); mapList.add("GOOGLE"); mapList.add("SATELLITE");

        //GridView + adapter
        GridView gv = findViewById(R.id.gv1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,R.layout.item, mapList);
        gv.setAdapter(adapter);

        //Listener > Sub2Activity 연결;


        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent1 = new Intent(SubActivity.this, Sub2Activity.class);
               intent1.putExtra("location2", location);
               intent1.putExtra("i", i);
               startActivity(intent1);
                }
        });
    }
}
