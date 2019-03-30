package com.example.frank.bigdatacalculate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String myString = "2029-03-10";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String nowDate = df.format(new Date());// new Date()为获取当前系统时间
        Date d = null,nowd=null;
        try {
            d = df.parse(myString);
            nowd=df.parse(nowDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        boolean flag = nowd.before(d);
        if(flag){

        }
        else{
            finish();
            System.exit(0);
        }

        findViewById(R.id.button10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
            }
        });


        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,MainActivity.class);
                intent.putExtra("tag","21");
                startActivity(intent);
            }
        });

        findViewById(R.id.button12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(HomeActivity.this,SelectDataActivity.class));
                startActivity(new Intent(HomeActivity.this,InputSevenActivity.class));
            }
        });
    }
}
