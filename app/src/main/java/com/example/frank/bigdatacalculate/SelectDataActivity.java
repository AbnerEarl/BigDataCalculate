package com.example.frank.bigdatacalculate;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.frank.bigdatacalculate.config.OriginData;
import com.example.frank.bigdatacalculate.utils.CheckPermissionUtils;
import com.example.frank.bigdatacalculate.utils.DataResult;
import com.example.frank.bigdatacalculate.utils.FileChooseUtil;
import com.example.frank.bigdatacalculate.utils.Tools;
import com.mic.etoast2.EToast2;
import com.mic.etoast2.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SelectDataActivity extends AppCompatActivity {

    private String sevenSourcePath="",tweenSourcePath="";
    private TextView tv_seven,tv_tween;
    private Button startCompute;

    public static int []input1=new int[7];
    public static int []input2=new int[7];
    public static int []input3=new int[7];
    public static int []input4=new int[7];
    public static int []input5=new int[7];
    public static int []input6=new int[7];
    public static int []input7=new int[7];
    public static int []input8=new int[7];
    public static int []input9=new int[7];
    public static int []input10=new int[7];
    public static int []input11=new int[7];

    public static int []input21=new int[21];
    public static int []input22=new int[21];
    public static int []input23=new int[21];
    public static int []input24=new int[21];
    public static int []input25=new int[21];
    public static int []input26=new int[21];
    public static int []input27=new int[21];
    public static int []input28=new int[21];
    public static int []input29=new int[21];
    public static int []input210=new int[21];
    public static int []input211=new int[21];
    private int calculateResult=0,computeResult=0;
    public static String sdcardPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/BigDataCalculateAll/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_data);

        tv_seven=findViewById(R.id.textView7);
        tv_tween=findViewById(R.id.textView8);
        startCompute=findViewById(R.id.button15);
        CheckPermissionUtils.verifyStoragePermissions(SelectDataActivity.this);
        deleteDir(sdcardPath);

        findViewById(R.id.button13).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                //intent.setType("image/*");//选择图片
                //intent.setType(“audio/*”); //选择音频
                //intent.setType(“video/*”); //选择视频 （mp4 3gp 是android支持的视频格式）
                //intent.setType(“video/*;image/*”);//同时选择视频和图片
                intent.setType("*/*");//无类型限制
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 11);
                //startActivity(new Intent(this, AccessibilityNormalSample.class));
            }
        });

        findViewById(R.id.button14).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                //intent.setType("image/*");//选择图片
                //intent.setType(“audio/*”); //选择音频
                //intent.setType(“video/*”); //选择视频 （mp4 3gp 是android支持的视频格式）
                //intent.setType(“video/*;image/*”);//同时选择视频和图片
                intent.setType("*/*");//无类型限制
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 12);
                //startActivity(new Intent(this, AccessibilityNormalSample.class));
            }
        });

        startCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sevenSourcePath.contains(".")&&tweenSourcePath.contains(".")){
                    startCompute.setText("正在计算，请稍候……");
                    startCompute.setEnabled(false);

                    try {
                        File file = new File(sevenSourcePath);
                        InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                        BufferedReader bf = new BufferedReader(inputReader);
                        String str= "";
                        str = bf.readLine();
                        String []data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input1[i]=Integer.parseInt(data[i]);
                        }

                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input2[i]=Integer.parseInt(data[i]);
                        }
                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input3[i]=Integer.parseInt(data[i]);
                        }

                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input4[i]=Integer.parseInt(data[i]);
                        }

                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input5[i]=Integer.parseInt(data[i]);
                        }

                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input6[i]=Integer.parseInt(data[i]);
                        }

                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input7[i]=Integer.parseInt(data[i]);
                        }

                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input8[i]=Integer.parseInt(data[i]);
                        }
                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input9[i]=Integer.parseInt(data[i]);
                        }
                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input10[i]=Integer.parseInt(data[i]);
                        }
                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input11[i]=Integer.parseInt(data[i]);
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }


                    try {
                        File file = new File(tweenSourcePath);
                        InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                        BufferedReader bf = new BufferedReader(inputReader);
                        String str= "";
                        str = bf.readLine();
                        String []data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input21[i]=Integer.parseInt(data[i]);
                        }

                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input22[i]=Integer.parseInt(data[i]);
                        }
                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input23[i]=Integer.parseInt(data[i]);
                        }

                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input24[i]=Integer.parseInt(data[i]);
                        }

                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input25[i]=Integer.parseInt(data[i]);
                        }

                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input26[i]=Integer.parseInt(data[i]);
                        }

                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input27[i]=Integer.parseInt(data[i]);
                        }

                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input28[i]=Integer.parseInt(data[i]);
                        }
                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input29[i]=Integer.parseInt(data[i]);
                        }
                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input210[i]=Integer.parseInt(data[i]);
                        }
                        str = bf.readLine();
                        data=str.split(",");
                        for (int i=0;i<data.length;i++){
                            input211[i]=Integer.parseInt(data[i]);
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    startChange();
                }
            }
        });

        if (OriginData.isNotAuCompute){
            OriginData.isNotAuCompute=false;
            sevenSourcePath=InputSevenActivity.sdcardPath+"get7data.txt";
            tweenSourcePath=InputSevenActivity.sdcardPath+"get21data.txt";
            clickStart();
        }
    }

    private void clickStart(){

        startCompute.setText("正在计算，请稍候……");
        startCompute.setEnabled(false);

        try {
            File file = new File(sevenSourcePath);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);
            String str= "";
            str = bf.readLine();
            String []data=str.split(",");
            for (int i=0;i<data.length;i++){
                input1[i]=Integer.parseInt(data[i]);
            }

            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input2[i]=Integer.parseInt(data[i]);
            }
            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input3[i]=Integer.parseInt(data[i]);
            }

            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input4[i]=Integer.parseInt(data[i]);
            }

            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input5[i]=Integer.parseInt(data[i]);
            }

            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input6[i]=Integer.parseInt(data[i]);
            }

            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input7[i]=Integer.parseInt(data[i]);
            }

            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input8[i]=Integer.parseInt(data[i]);
            }
            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input9[i]=Integer.parseInt(data[i]);
            }
            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input10[i]=Integer.parseInt(data[i]);
            }
            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input11[i]=Integer.parseInt(data[i]);
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        try {
            File file = new File(tweenSourcePath);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);
            String str= "";
            str = bf.readLine();
            String []data=str.split(",");
            for (int i=0;i<data.length;i++){
                input21[i]=Integer.parseInt(data[i]);
            }

            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input22[i]=Integer.parseInt(data[i]);
            }
            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input23[i]=Integer.parseInt(data[i]);
            }

            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input24[i]=Integer.parseInt(data[i]);
            }

            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input25[i]=Integer.parseInt(data[i]);
            }

            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input26[i]=Integer.parseInt(data[i]);
            }

            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input27[i]=Integer.parseInt(data[i]);
            }

            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input28[i]=Integer.parseInt(data[i]);
            }
            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input29[i]=Integer.parseInt(data[i]);
            }
            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input210[i]=Integer.parseInt(data[i]);
            }
            str = bf.readLine();
            data=str.split(",");
            for (int i=0;i<data.length;i++){
                input211[i]=Integer.parseInt(data[i]);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        startChange();
    }

    private void startChange(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input1.length; i++) {
                    for (int j = i + 1; j < input1.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input1[i] + input1[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input2)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a11);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af11);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af11);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a11 + ".txt", DataResult.a12, input2, DataResult.af12);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a12 + ".txt", DataResult.a13, input2, DataResult.af13);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

                    startAddData();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input2.length; i++) {
                    for (int j = i + 1; j < input2.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input2[i] + input2[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input3)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a21);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af21);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af21);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a21 + ".txt", DataResult.a22, input3, DataResult.af22);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a22 + ".txt", DataResult.a23, input3, DataResult.af23);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input3.length; i++) {
                    for (int j = i + 1; j < input3.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input3[i] + input3[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input4)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a31);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af31);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af31);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a31 + ".txt", DataResult.a32, input4, DataResult.af32);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a32 + ".txt", DataResult.a33, input4, DataResult.af33);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input4.length; i++) {
                    for (int j = i + 1; j < input4.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input4[i] + input4[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input5)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a41);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af41);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a41 + ".txt", DataResult.a42, input5, DataResult.af42);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a42 + ".txt", DataResult.a43, input5, DataResult.af43);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input5.length; i++) {
                    for (int j = i + 1; j < input5.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input5[i] + input5[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input6)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a51);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af51);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af51);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a51 + ".txt", DataResult.a52, input6, DataResult.af52);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a52 + ".txt", DataResult.a53, input6, DataResult.af53);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input6.length; i++) {
                    for (int j = i + 1; j < input6.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input6[i] + input6[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input7)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a61);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af61);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af61);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a61 + ".txt", DataResult.a62, input7, DataResult.af62);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a62 + ".txt", DataResult.a63, input7, DataResult.af63);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input7.length; i++) {
                    for (int j = i + 1; j < input7.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input7[i] + input7[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input8)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a71);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af71);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af71);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a71 + ".txt", DataResult.a72, input8, DataResult.af72);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a72 + ".txt", DataResult.a73, input8, DataResult.af73);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input8.length; i++) {
                    for (int j = i + 1; j < input8.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input8[i] + input8[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input9)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a81);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af81);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af81);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a81 + ".txt", DataResult.a82, input9, DataResult.af82);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a82 + ".txt", DataResult.a83, input9, DataResult.af83);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input9.length; i++) {
                    for (int j = i + 1; j < input9.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input9[i] + input9[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input10)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a91);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af91);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af91);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a91 + ".txt", DataResult.a92, input10, DataResult.af92);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a92 + ".txt", DataResult.a93, input10, DataResult.af93);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input10.length; i++) {
                    for (int j = i + 1; j < input10.length; j++) {
                        boolean isDiff = false;
                        int finalD = (input10[i] + input10[j]);
                        if (finalD > 49) {
                            finalD %= 49;
                        } else {
                            if (isDifferent(finalD, input11)) {

                                isDiff = true;
                            }
                        }

                        Tools.saveRecordData(finalD + "", DataResult.a101);
                        if (isDiff) {
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>" + finalD + "</font>", DataResult.af101);
                        } else {
                            Tools.saveRecordData("<font size='18'>" + finalD + "</font>", DataResult.af101);
                        }
                    }
                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a101 + ".txt", DataResult.a102, input11, DataResult.af102);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a102 + ".txt", DataResult.a103, input11, DataResult.af103);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();



        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input11.length; i++) {
                    for (int j = i + 1; j < input11.length; j++) {
                        int finalD = (input11[i] + input11[j]);
                        if (finalD>0) {
                            if (finalD > 49) {
                                finalD %= 49;
                            }
                            Tools.saveRecordData(finalD + "", DataResult.a111);
                        }else {
                            Tools.saveRecordData(49 + "", DataResult.a111);
                        }
                    }
                }

                //第二次裂变
                caculateDataLast(sdcardPath + DataResult.a111 + ".txt", DataResult.a112);
                //第三次裂变
                caculateDataLast(sdcardPath + DataResult.a112 + ".txt", DataResult.a113);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

                    startAddData();
                }
            }
        }).start();


        // 21个数的裂变

        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input21.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input21[i], input22)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input21[i] + "", DataResult.a11for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input21[i] + "</font>", DataResult.af11for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input21[i] + "</font>", DataResult.af11for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a11for21 + ".txt", DataResult.a12for21, input22, DataResult.af12for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a12for21 + ".txt", DataResult.a13for21, input22, DataResult.af13for21);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input22.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input22[i], input23)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input22[i] + "", DataResult.a21for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input22[i] + "</font>", DataResult.af21for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input22[i] + "</font>", DataResult.af21for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a21for21 + ".txt", DataResult.a22for21, input23, DataResult.af22for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a22for21 + ".txt", DataResult.a23for21, input23, DataResult.af23for21);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input23.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input23[i], input24)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input23[i] + "", DataResult.a31for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input23[i] + "</font>", DataResult.af31for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input23[i] + "</font>", DataResult.af31for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a31for21 + ".txt", DataResult.a32for21, input24, DataResult.af32for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a32for21 + ".txt", DataResult.a33for21, input24, DataResult.af33for21);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input24.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input24[i], input25)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input24[i] + "", DataResult.a41for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input24[i] + "</font>", DataResult.af41for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input24[i] + "</font>", DataResult.af41for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a41for21 + ".txt", DataResult.a42for21, input25, DataResult.af42for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a42for21 + ".txt", DataResult.a43for21, input25, DataResult.af43for21);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input25.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input25[i], input26)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input25[i] + "", DataResult.a51for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input25[i] + "</font>", DataResult.af51for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input25[i] + "</font>", DataResult.af51for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a51for21 + ".txt", DataResult.a52for21, input26, DataResult.af52for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a52for21 + ".txt", DataResult.a53for21, input26, DataResult.af53for21);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input26.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input26[i], input27)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input26[i] + "", DataResult.a61for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input26[i] + "</font>", DataResult.af61for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input26[i] + "</font>", DataResult.af61for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a61for21 + ".txt", DataResult.a62for21, input27, DataResult.af62for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a62for21 + ".txt", DataResult.a63for21, input27, DataResult.af63for21);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input27.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input27[i], input28)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input27[i] + "", DataResult.a71for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input27[i] + "</font>", DataResult.af71for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input27[i] + "</font>", DataResult.af71for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a71for21 + ".txt", DataResult.a72for21, input28, DataResult.af72for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a72for21 + ".txt", DataResult.a73for21, input28, DataResult.af73for21);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input28.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input28[i], input29)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input28[i] + "", DataResult.a81for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input28[i] + "</font>", DataResult.af81for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input28[i] + "</font>", DataResult.af81for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a81for21 + ".txt", DataResult.a82for21,input29, DataResult.af82for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a82for21 + ".txt", DataResult.a83for21, input29, DataResult.af83for21);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input29.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input29[i], input210)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input29[i] + "", DataResult.a91for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input29[i] + "</font>", DataResult.af91for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input29[i] + "</font>", DataResult.af91for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a91for21 + ".txt", DataResult.a92for21, input210, DataResult.af92for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a92for21 + ".txt", DataResult.a93for21, input210, DataResult.af93for21);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input210.length; i++) {
                    boolean isDiff = false;
                    if (isDifferent(input210[i], input211)) {
                        isDiff = true;
                    }
                    Tools.saveRecordFor21Data(input210[i] + "", DataResult.a101for21);
                    if (isDiff) {
                        //保存相同的数据标记
                        Tools.saveRecordFor21Data("<font color='red' size='18'>" + input210[i] + "</font>", DataResult.af101for21);
                    } else {
                        Tools.saveRecordFor21Data("<font size='18'>" + input210[i] + "</font>", DataResult.af101for21);
                    }

                }

                //第二次裂变
                caculateData(sdcardPath + DataResult.a101for21 + ".txt", DataResult.a102for21, input211, DataResult.af102for21);
                //第三次裂变
                caculateData(sdcardPath + DataResult.a102for21 + ".txt", DataResult.a103for21, input211, DataResult.af103for21);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                    startAddData();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                //第一次裂变
                for (int i = 0; i < input211.length; i++) {

                    if (input211[i] > 49) {
                        input211[i] %= 49;
                    }
                    Tools.saveRecordFor21Data(input211[i] + "", DataResult.a111for21);

                }

                //第二次裂变
                caculateDataLast(sdcardPath + DataResult.a111for21 + ".txt", DataResult.a112for21);
                //第三次裂变
                caculateDataLast(sdcardPath + DataResult.a112for21 + ".txt", DataResult.a113for21);

                calculateResult++;
                if (calculateResult >= 22) {
//                    computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
//                    computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
//                    computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

                    startAddData();
                }
            }
        }).start();

    }

    private void startAddData() {

        //開始累积加，进行存储
        for (int k=1;k<11;k++){
            String fileName1=sdcardPath+"a"+k+"2"+".txt";
            String fileName2=sdcardPath+"a"+k+"2for21"+".txt";

            int []input=input1;
            if (k==1){
                input=input2;
            }else if (k==2){
                input=input3;
            }else if (k==3){
                input=input4;
            }else if (k==4){
                input=input5;
            }else if (k==5){
                input=input6;
            }else if (k==6){
                input=input7;
            }else if (k==7){
                input=input8;
            }else if (k==8){
                input=input9;
            }else if (k==9){
                input=input10;
            }else if (k==10){
                input=input11;
            }
            try {
                File file1 = new File(fileName1);
                File file2 = new File(fileName2);
                InputStreamReader inputReader1 = new InputStreamReader(new FileInputStream(file1));
                BufferedReader bf1 = new BufferedReader(inputReader1);

                // 按行读取字符串
                String str, strTem;
                int a = 0,b=0,tag=0,index=0;
                //两个循环分别得到两万一千个数的和。
                while ((str = bf1.readLine()) != null) {
                    index++;
                    InputStreamReader inputReader2 = new InputStreamReader(new FileInputStream(file2));
                    BufferedReader bf2 = new BufferedReader(inputReader2);
                    String saveFileName=k+"Change"+index;
                    String saveFileNameFinal=k+"ChangeFinal"+index;


                    while ((strTem=bf2.readLine())!=null){
                        a=Integer.parseInt(str);
                        b=Integer.parseInt(strTem);
                        boolean isDiff=false;
                        int finalD=a+b;

                        //进行数据判断
                        if(finalD>49){
                            finalD%=49;
                            if (a!=49&&b!=49){
                                if(isDifferent(finalD,input)){
                                    isDiff=true;
                                }
                            }
                        }else{
                            if(isDifferent(finalD,input)){
                                isDiff=true;
                            }
                        }
                        Tools.saveRecordData(finalD+"", saveFileName);
                        if(isDiff){
                            //保存相同的数据标记
                            Tools.saveRecordData("<font color='red' size='18'>"+finalD+"</font>", saveFileNameFinal);
                        }else{
                            Tools.saveRecordData("<font size='18'>"+finalD+"</font>", saveFileNameFinal);
                        }

                    }
                    bf2.close();
                    inputReader2.close();

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        try {
            File file = new File(sdcardPath+"a112"+".txt");
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);

            // 按行读取字符串
            String str,strTem;
            int tag=0,index=0;
            while ((str = bf.readLine()) != null) {
                index++;
                File file2 = new File(sdcardPath+"a112for21"+".txt");
                InputStreamReader inputReaderTem=new InputStreamReader(new FileInputStream(file2));
                BufferedReader bfTem=new BufferedReader(inputReaderTem);
                while((strTem = bfTem.readLine()) != null) {
                    int finalD=Integer.parseInt(str)+Integer.parseInt(strTem);
                    //进行数据判断
                    if(finalD>49){
                        finalD%=49;
                    }
                    Tools.saveRecordData(finalD+"", "11Change"+index);
                }
                bfTem.close();
                inputReaderTem.close();
            }

            bf.close();
            inputReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        startActivity(new Intent(SelectDataActivity.this,ComputeAllActivity.class));
        finish();


    }

    public static void caculateData(String originFileName,String newFileName,int[] input,String finalFileName){
        try {
            File file = new File(originFileName);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);

            InputStreamReader inputReaderTem=null;
            BufferedReader bfTem=null;

            // 按行读取字符串
            String str,strTem;
            int tag=0;
            while ((str = bf.readLine()) != null) {
                tag++;
                if(bfTem!=null){
                    bfTem.close();
                }
                if(inputReaderTem!=null){
                    inputReaderTem.close();
                }

                inputReaderTem=new InputStreamReader(new FileInputStream(file));
                bfTem= new BufferedReader(inputReaderTem);
                for(int k=0;k<tag;k++){
                    if((strTem = bfTem.readLine()) != null){

                    }else{
                        return;
                        //break;
                    }
                }

                int originD=Integer.parseInt(str);
                while((strTem = bfTem.readLine()) != null) {
                    boolean isDiff=false;
                    int finalD=originD+Integer.parseInt(strTem);
                    //进行数据判断
                    if(finalD>49){
                        finalD%=49;
                        if (originD!=49&&Integer.parseInt(strTem)!=49){
                            if(isDifferent(finalD,input)){
                                isDiff=true;
                            }
                        }
                    }else{
                        if(isDifferent(finalD,input)){

                            isDiff=true;
                        }
                    }
                    Tools.saveRecordData(finalD+"", newFileName);
                    if(isDiff){
                        //保存相同的数据标记
                        Tools.saveRecordData("<font color='red' size='18'>"+finalD+"</font>", finalFileName);
                    }else{
                        Tools.saveRecordData("<font size='18'>"+finalD+"</font>", finalFileName);
                    }
                }
            }
            bf.close();
            inputReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void caculateDataLast(String originFileName,String newFileName){
        try {
            File file = new File(originFileName);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);

            InputStreamReader inputReaderTem=null;
            BufferedReader bfTem=null;


            // 按行读取字符串
            String str,strTem;
            int tag=0;
            while ((str = bf.readLine()) != null) {
                tag++;
                if(bfTem!=null){
                    bfTem.close();
                }
                if(inputReaderTem!=null){
                    inputReaderTem.close();
                }

                inputReaderTem=new InputStreamReader(new FileInputStream(file));
                bfTem= new BufferedReader(inputReaderTem);
                for(int k=0;k<tag;k++){
                    if((strTem = bfTem.readLine()) != null){

                    }else{
                        return;
                    }
                }

                int originD=Integer.parseInt(str);
                while((strTem = bfTem.readLine()) != null) {
                    int finalD=originD+Integer.parseInt(strTem);
                    if (finalD>0) {
                        //进行数据判断
                        if (finalD > 49) {
                            finalD %= 49;
                        }
                        Tools.saveRecordData(finalD + "", newFileName);
                    }else {
                        Tools.saveRecordData(49 + "", newFileName);
                    }
                }
            }
            bf.close();
            inputReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static boolean isDifferent (int currentD,int[]dataSet){
        boolean tag=false;
        for(int i=0;i<dataSet.length;i++){
            if(currentD==dataSet[i]){
                tag=true;
                break;
            }
        }
        return tag;
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



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==11){
            Uri uri=data.getData();
            Log.d("FilePath","选择文件返回1："+uri.getPath());
            final String chooseFilePath= FileChooseUtil.getInstance(SelectDataActivity.this).getChooseFileResultPath(uri);
            Log.d("FilePath","选择文件返回2："+chooseFilePath);
            sevenSourcePath=chooseFilePath;
            String ffName=chooseFilePath.substring(chooseFilePath.lastIndexOf("/")+1);
            tv_seven.setText(ffName);

        }else if (requestCode==12){
            Uri uri=data.getData();
            Log.d("FilePath","选择文件返回1："+uri.getPath());
            final String chooseFilePath= FileChooseUtil.getInstance(SelectDataActivity.this).getChooseFileResultPath(uri);
            Log.d("FilePath","选择文件返回2："+chooseFilePath);
            tweenSourcePath=chooseFilePath;
            String ffName=chooseFilePath.substring(chooseFilePath.lastIndexOf("/")+1);
            tv_tween.setText(ffName);

        }
    }

}
