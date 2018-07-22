package com.example.a403_10.location;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Sub2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        //intent 1(location) & 2 (click i) 가져오기
        Intent intent1 = getIntent();
        String location2 = intent1.getStringExtra("location2");
        int i = intent1.getIntExtra("i", 0);

        //TextView 기능
        TextView textView = findViewById(R.id.sub2tv1);
        textView.setText(location2);

        //MapSite 불러오기
        WebView wb = findViewById(R.id.wb);
        wb.setWebViewClient(new WebViewClient());
        WebSettings wbSetting = wb.getSettings();
        wbSetting.setJavaScriptEnabled(true);
        if (i == 0) {
            wb.loadUrl("https://m.map.naver.com/search2/search.nhn?query="+location2+"&sm=hty#/map/1/13479304");
        }
            else if (i==1) {
            wb.loadUrl("https://m.map.daum.net/actions/searchView?q="+location2+"&wxEnc=LQMRMP&wyEnc=QNLNQQN&lvl=4&rcode=I10031203#!/25048462/map/place");
        }
            else if (i==2) {
            wb.loadUrl("https://www.google.com/maps/place/"+location2);
        }
            else if (i==3) {
            wb.loadUrl("https://www.google.com/maps/place/"+location2+"/data=!3m2!1e3!4b1");
        }
                else return;

        }
    }
