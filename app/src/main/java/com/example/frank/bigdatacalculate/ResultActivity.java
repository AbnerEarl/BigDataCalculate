package com.example.frank.bigdatacalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.frank.bigdatacalculate.config.OriginData;

public class ResultActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView=findViewById(R.id.textView10);
        textView.setText(OriginData.result+"");
    }
}
