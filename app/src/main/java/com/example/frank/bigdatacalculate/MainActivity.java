package com.example.frank.bigdatacalculate;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.frank.bigdatacalculate.config.OriginData;
import com.mic.etoast2.EToast2;
import com.mic.etoast2.Toast;

import com.example.frank.bigdatacalculate.utils.CheckPermissionUtils;
import com.example.frank.bigdatacalculate.utils.DataResult;
import com.example.frank.bigdatacalculate.utils.Tools;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2,et3,et4,et5;
    private TextView loadingText;
    public static int []input1=new int[7];
    public static int []input2=new int[7];
    public static int []input3=new int[7];
    public static int []input4=new int[7];
    public static int []input5=new int[7];
    private int calculateResult=0,computeResult=0;
    public static String sdcardPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/BigDataCalculate7/";
    public static HashMap<String,String> computeDataResult1=new HashMap<>();
    public static HashMap<String,String> computeDataResult2=new HashMap<>();
    public static HashMap<String,String> computeDataResult3=new HashMap<>();

    private Button calculateStart;
    private int isExecute=10;
    private String tagOP="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tagOP=getIntent().getStringExtra("tag");
        et1=findViewById(R.id.editText);
        et2=findViewById(R.id.editText2);
        et3=findViewById(R.id.editText3);
        et4=findViewById(R.id.editText4);
        et5=findViewById(R.id.editText5);
        loadingText=findViewById(R.id.textView);
        loadingText.setVisibility(View.INVISIBLE);

        CheckPermissionUtils.verifyStoragePermissions(MainActivity.this);
        deleteDir(sdcardPath);

        String myString = "2028-12-16";
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

        calculateStart=findViewById(R.id.button);
        if (tagOP!=null&&tagOP.equals("21")){
            calculateStart.setText("下一步，输入21个自定义数据");
        }
        calculateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tagOP != null && tagOP.equals("21")) {
                    String[] str1 = et1.getText().toString().trim().split(",");
                    String[] str2 = et2.getText().toString().trim().split(",");
                    String[] str3 = et3.getText().toString().trim().split(",");
                    String[] str4 = et4.getText().toString().trim().split(",");
                    String[] str5 = et5.getText().toString().trim().split(",");
                    if (str1.length >= 7 && str2.length >= 7 && str3.length >= 7 && str4.length >= 7 && str5.length >= 7) {

                        loadingText.setVisibility(View.VISIBLE);
                        //calculateStart.setVisibility(View.INVISIBLE);
                        calculateStart.setEnabled(false);
                        for (int i = 0; i < str1.length; i++) {
                            OriginData.input1[i] = Integer.parseInt(str1[i]);
                            OriginData.input2[i] = Integer.parseInt(str2[i]);
                            OriginData.input3[i] = Integer.parseInt(str3[i]);
                            OriginData.input4[i] = Integer.parseInt(str4[i]);
                            OriginData.input5[i] = Integer.parseInt(str5[i]);
                        }
                        startActivity(new Intent(MainActivity.this, MainActivityFor21.class));
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "数据输入不合法，请检查", EToast2.LENGTH_LONG).show();

                    }

                } else {
                    if (isExecute > 0) {
                        String[] str1 = et1.getText().toString().trim().split(",");
                        String[] str2 = et2.getText().toString().trim().split(",");
                        String[] str3 = et3.getText().toString().trim().split(",");
                        String[] str4 = et4.getText().toString().trim().split(",");
                        String[] str5 = et5.getText().toString().trim().split(",");
                        if (str1.length >= 7 && str2.length >= 7 && str3.length >= 7 && str4.length >= 7 && str5.length >= 7) {

                            isExecute=-10;
                            loadingText.setVisibility(View.VISIBLE);
                            //calculateStart.setVisibility(View.INVISIBLE);
                            calculateStart.setEnabled(false);
                            for (int i = 0; i < str1.length; i++) {
                                input1[i] = Integer.parseInt(str1[i]);
                                input2[i] = Integer.parseInt(str2[i]);
                                input3[i] = Integer.parseInt(str3[i]);
                                input4[i] = Integer.parseInt(str4[i]);
                                input5[i] = Integer.parseInt(str5[i]);
                            }

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

                                            Tools.saveRecord(finalD + "", DataResult.a11);
                                            if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af11);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af11);
                                            }
                                        }
                                    }

                                    //第二次裂变
                                    caculateData(sdcardPath + DataResult.a11 + ".txt", DataResult.a12, input2, DataResult.af12);
                                    //第三次裂变
                                    caculateData(sdcardPath + DataResult.a12 + ".txt", DataResult.a13, input2, DataResult.af13);

                                    calculateResult++;
                                    if (calculateResult >= 5) {
                                        computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
                                        computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
                                        computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

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

                                            Tools.saveRecord(finalD + "", DataResult.a21);
                                            if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af21);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af21);
                                            }
                                        }
                                    }

                                    //第二次裂变
                                    caculateData(sdcardPath + DataResult.a21 + ".txt", DataResult.a22, input3, DataResult.af22);
                                    //第三次裂变
                                    caculateData(sdcardPath + DataResult.a22 + ".txt", DataResult.a23, input3, DataResult.af23);

                                    calculateResult++;
                                    if (calculateResult >= 5) {
                                        computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
                                        computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
                                        computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

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

                                            Tools.saveRecord(finalD + "", DataResult.a31);
                                            if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af31);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af31);
                                            }
                                        }
                                    }

                                    //第二次裂变
                                    caculateData(sdcardPath + DataResult.a31 + ".txt", DataResult.a32, input4, DataResult.af32);
                                    //第三次裂变
                                    caculateData(sdcardPath + DataResult.a32 + ".txt", DataResult.a33, input4, DataResult.af33);

                                    calculateResult++;
                                    if (calculateResult >= 5) {
                                        computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
                                        computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
                                        computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

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

                                            Tools.saveRecord(finalD + "", DataResult.a41);
                                            if (isDiff) {
                                                //保存相同的数据标记
                                                Tools.saveRecord("<font color='red' size='18'>" + finalD + "</font>", DataResult.af41);
                                            } else {
                                                Tools.saveRecord("<font size='18'>" + finalD + "</font>", DataResult.af41);
                                            }
                                        }
                                    }

                                    //第二次裂变
                                    caculateData(sdcardPath + DataResult.a41 + ".txt", DataResult.a42, input5, DataResult.af42);
                                    //第三次裂变
                                    caculateData(sdcardPath + DataResult.a42 + ".txt", DataResult.a43, input5, DataResult.af43);

                                    calculateResult++;
                                    if (calculateResult >= 5) {
                                        computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
                                        computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
                                        computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);

                                    }
                                }
                            }).start();

                            new Thread(new Runnable() {
                                @Override
                                public void run() {

                                    //第一次裂变
                                    for (int i = 0; i < input5.length; i++) {
                                        for (int j = i + 1; j < input5.length; j++) {
                                            int finalD = (input5[i] + input5[j]);
                                            if (finalD > 49) {
                                                finalD %= 49;
                                            }
                                            Tools.saveRecord(finalD + "", DataResult.a51);
                                        }
                                    }

                                    //第二次裂变
                                    caculateDataLast(sdcardPath + DataResult.a51 + ".txt", DataResult.a52);
                                    //第三次裂变
                                    caculateDataLast(sdcardPath + DataResult.a52 + ".txt", DataResult.a53);

                                    calculateResult++;
                                    if (calculateResult >= 5) {
                                        computeData(sdcardPath + DataResult.af11 + ".txt", sdcardPath + DataResult.af21 + ".txt", sdcardPath + DataResult.af31 + ".txt", sdcardPath + DataResult.af41 + ".txt", sdcardPath + DataResult.a51 + ".txt", computeDataResult1);
                                        computeData(sdcardPath + DataResult.af12 + ".txt", sdcardPath + DataResult.af22 + ".txt", sdcardPath + DataResult.af32 + ".txt", sdcardPath + DataResult.af42 + ".txt", sdcardPath + DataResult.a52 + ".txt", computeDataResult2);
                                        computeData(sdcardPath + DataResult.af13 + ".txt", sdcardPath + DataResult.af23 + ".txt", sdcardPath + DataResult.af33 + ".txt", sdcardPath + DataResult.af43 + ".txt", sdcardPath + DataResult.a53 + ".txt", computeDataResult3);
                                    }
                                }
                            }).start();

                        } else {
                            Toast.makeText(MainActivity.this, "数据输入不合法，请检查", EToast2.LENGTH_LONG).show();
                            //Toast.makeText(MainActivity.this,"数据输入不合法，请检查",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
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
                    Tools.saveRecord(finalD+"", newFileName);
                    if(isDiff){
                        //保存相同的数据标记
                        Tools.saveRecord("<font color='red' size='18'>"+finalD+"</font>", finalFileName);
                    }else{
                        Tools.saveRecord("<font size='18'>"+finalD+"</font>", finalFileName);
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
                    //进行数据判断
                    if(finalD>49){
                        finalD%=49;
                    }
                    Tools.saveRecord(finalD+"", newFileName);
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


    public  void computeData(final String fileName1, final String fileName2, final String fileName3, final String fileName4, final String fileName5, final HashMap<String,String> computeDataResult){

        new Thread(new Runnable() {
            @Override
            public void run() {
        try{
            File file1 = new File(fileName1);
            InputStreamReader inputReader1 = new InputStreamReader(new FileInputStream(file1));
            BufferedReader bf1 = new BufferedReader(inputReader1);

            File file2 = new File(fileName2);
            InputStreamReader inputReader2 = new InputStreamReader(new FileInputStream(file2));
            BufferedReader bf2 = new BufferedReader(inputReader2);

            File file3 = new File(fileName3);
            InputStreamReader inputReader3 = new InputStreamReader(new FileInputStream(file3));
            BufferedReader bf3 = new BufferedReader(inputReader3);

            File file4 = new File(fileName4);
            InputStreamReader inputReader4 = new InputStreamReader(new FileInputStream(file4));
            BufferedReader bf4 = new BufferedReader(inputReader4);

            File file5 = new File(fileName5);
            InputStreamReader inputReader5 = new InputStreamReader(new FileInputStream(file5));
            BufferedReader bf5 = new BufferedReader(inputReader5);

            String str1="",str2="",str3="",str4="",str5="";
           
            while ((str1 = bf1.readLine()) != null) {
                str2=bf2.readLine();
                str3=bf3.readLine();
                str4=bf4.readLine();
                str5=bf5.readLine();

                if(computeFrequency(str1,str2,str3,str4)){
                    String key="4/"+str5+"/";
                    String value=computeDataResult.get(key);
                    if(value!=null&&!"".equals(value)){
                        int v=Integer.parseInt(value)+1;
                        computeDataResult.put(key, v+"");
                    }else{
                        computeDataResult.put(key, "1");
                    }
                }else if(computeFrequency(str2,str3,str4)){
                    String key="3/"+str5+"/";
                    String value=computeDataResult.get(key);
                    if(value!=null&&!"".equals(value)){
                        int v=Integer.parseInt(value)+1;
                        computeDataResult.put(key, v+"");
                    }else{
                        computeDataResult.put(key, "1");
                    }
                }

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        computeResult++;
        if (computeResult>=3){
            //Toast.makeText(MainActivity.this,"数据计算完成",EToast2.LENGTH_LONG).show();
            loadingText.setVisibility(View.INVISIBLE);
            OriginData.dataMode="7";
            computeResult=-10;
            OriginData.computeDataResult1for7=computeDataResult1;
            OriginData.computeDataResult2for7=computeDataResult2;
            OriginData.computeDataResult3for7=computeDataResult3;
            startActivity(new Intent(MainActivity.this,Main2Activity.class));
            finish();
            //calculateStart.setVisibility(View.VISIBLE);
            //calculateStart.setEnabled(true);
        }

            }
        }).start();

    }


    public static boolean computeFrequency(String a,String b,String c,String d){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")){
            tag=true;
        }
        return tag;
    }


    public static boolean computeFrequency(String a,String b,String c){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")){
            tag=true;
        }
        return tag;
    }

    public static int appearFrequency(int a,int b,int c,int d){
        int tag=0;
        if(isEqualData(a,b)){
            tag++;
        }
        if(isEqualData(a,c)){
            tag++;
        }
        if(isEqualData(a,d)){
            tag++;
        }
        return tag;
    }


    public static boolean isEqualData(int a,int b){
        if(a==b){
            return true;
        }else{
            return false;
        }
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
