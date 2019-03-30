package com.example.frank.bigdatacalculate;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.frank.bigdatacalculate.utils.CheckPermissionUtils;
import com.example.frank.bigdatacalculate.utils.DataResult;
import com.example.frank.bigdatacalculate.utils.Tools;

import java.io.File;

public class InputSevenActivity extends AppCompatActivity {
    public static String sdcardPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/BigDataTempleData/";

    private EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_seven);

        et1=findViewById(R.id.et7_1);
        et2=findViewById(R.id.et7_2);
        et3=findViewById(R.id.et7_3);
        et4=findViewById(R.id.et7_4);
        et5=findViewById(R.id.et7_5);
        et6=findViewById(R.id.et7_6);
        et7=findViewById(R.id.et7_7);
        et8=findViewById(R.id.et7_8);
        et9=findViewById(R.id.et7_9);
        et10=findViewById(R.id.et7_10);
        et11=findViewById(R.id.et7_11);

        findViewById(R.id.get7data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckPermissionUtils.verifyStoragePermissions(InputSevenActivity.this);
                deleteDir(sdcardPath);
                Tools.saveTempleData(""+et1.getText().toString(), "get7data");
                Tools.saveTempleData(""+et2.getText().toString(), "get7data");
                Tools.saveTempleData(""+et3.getText().toString(), "get7data");
                Tools.saveTempleData(""+et4.getText().toString(), "get7data");
                Tools.saveTempleData(""+et5.getText().toString(), "get7data");
                Tools.saveTempleData(""+et6.getText().toString(), "get7data");
                Tools.saveTempleData(""+et7.getText().toString(), "get7data");
                Tools.saveTempleData(""+et8.getText().toString(), "get7data");
                Tools.saveTempleData(""+et9.getText().toString(), "get7data");
                Tools.saveTempleData(""+et10.getText().toString(), "get7data");
                Tools.saveTempleData(""+et11.getText().toString(), "get7data");
                startActivity(new Intent(InputSevenActivity.this,InputTewteenActivity.class));
                finish();
            }
        });

    }


    //删除文件夹和文件夹里面的文件
    public static void deleteDir(final String pPath) {
        File dir = new File(pPath);
        deleteDirWihtFile(dir);
    }

    public static void deleteDirWihtFile(File dir) {
        if (dir == null || !dir.exists() || !dir.isDirectory())
            return;
        for (File file : dir.listFiles()) {
            if (file.isFile())
                file.delete(); // 删除所有文件
            else if (file.isDirectory())
                deleteDirWihtFile(file); // 递规的方式删除文件夹
        }
        dir.delete();// 删除目录本身
    }
}
