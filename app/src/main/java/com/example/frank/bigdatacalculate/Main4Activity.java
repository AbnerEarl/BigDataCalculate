package com.example.frank.bigdatacalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.frank.bigdatacalculate.config.OriginData;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main4Activity extends AppCompatActivity {

    private TextView computeResultShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        computeResultShow=findViewById(R.id.textView5);

        findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator iter;
                if (OriginData.dataMode.equals("7")){
                    iter= OriginData.computeDataResult1for7.entrySet().iterator();
                }else {
                    iter= OriginData.computeDataResult1for21.entrySet().iterator();
                }

                String dd="";
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    dd=dd + entry.getKey()+entry.getValue()+"\n";
                }

                dd=dd+"第一次裂变统计完成！";
                computeResultShow.setText(dd);
            }
        });

        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator iter;
                if (OriginData.dataMode.equals("7")){
                    iter= OriginData.computeDataResult2for7.entrySet().iterator();
                }else {
                    iter= OriginData.computeDataResult2for21.entrySet().iterator();
                }
                String dd="";
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    dd=dd + entry.getKey()+entry.getValue()+"\n";
                }
                dd=dd+"第二次裂变统计完成！";
                computeResultShow.setText(dd);
            }
        });

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Iterator iter ;
                if (OriginData.dataMode.equals("7")){
                    iter= OriginData.computeDataResult3for7.entrySet().iterator();
                }else {
                    iter= OriginData.computeDataResult3for21.entrySet().iterator();
                }
                String dd="";
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    dd=dd + entry.getKey()+entry.getValue()+"\n";
                }
                dd=dd+"第三次裂变统计完成！";
                computeResultShow.setText(dd);
            }
        });

    }
}
