package com.example.a403_10.location;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    //입력값
    public void bt1(View v) {

        EditText et = findViewById(R.id.et1);
        final String st = et.getText().toString();

        //버튼
        Button bt1 = findViewById(R.id.bt1);

        //intent 지정
        Intent intent = new Intent(MainActivity.this, SubActivity.class);

        //정규식이용 (입력값 검토)
        boolean res = true;
        for (int i = 0; i < st.length(); i++) { //한글자씩 검사
            String letter = st.substring(i, i + 1);
            boolean temp = Pattern.matches("[가-힣]", letter);
            if (temp == false) {
                res = false;
            }
        }
        // 결과값 불러오기
        CrawlingMap crawlResult = new CrawlingMap();

        //한글일경우, SubActivity로 / Error 변수 제거
        if (res == true) {
            intent.putExtra("location", st);
            LinkedList<String> resList = crawlResult.getLatLng(st);
            String lat = resList.get(0);
            if (lat.equals("error1")) {
                Toast.makeText(MainActivity.this,
                        "대한민국 내의 위치를 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            if (lat.equals("error2")) {
                Toast.makeText(MainActivity.this,
                        "잘못된 주소입니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            String lng = resList.get(1);
            intent.putExtra("lat",lat);
            intent.putExtra("lng", lng);
            startActivity(intent);

        } else Toast.makeText(MainActivity.this, "한글 주소를 입력해주세요.", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }
}