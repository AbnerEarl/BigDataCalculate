package com.example.frank.bigdatacalculate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.frank.bigdatacalculate.config.OriginData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StepComputeActivity extends AppCompatActivity {

    //public static ConcurrentHashMap<String,String> computeDataResult=new ConcurrentHashMap<>();
//    public static HashMap<String,String> computeDataResult=new HashMap<>();
   /* public static HashMap<String,String> computeDataResult1=new HashMap<>();
    public static HashMap<String,String> computeDataResult2=new HashMap<>();
    public static HashMap<String,String> computeDataResult3=new HashMap<>();*/

    private TextView computeResultText;
    private String tagFile="";
    private  String dd="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_compute);

        computeResultText=findViewById(R.id.textView9);

        /*if (!OriginData.lookAllResult) {
            //查看部分结果
            tagFile = getIntent().getStringExtra("tag");
            computeData(tagFile);
        }else {
            //查看所有的结果
            Toast.makeText(StepComputeActivity.this,"查看所有的结果",Toast.LENGTH_LONG).show();
            OriginData.lookAllResult=false;
            for (int i=1;i<211;i++){
                computeDataAll(i+"");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //computeDataAll(times+"");
        }*/


        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<211;i++){
                    computeDataAll(i+"");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (OriginData.index<211){
                    computeDataAll(OriginData.index+"");
                }else {
                    //startActivity(new Intent(StepComputeActivity.this,StepComputeActivity.class));
                    startActivity(new Intent(StepComputeActivity.this,ResultActivity.class));
                    finish();
                }
            }
        }).start();




    }

    public  void computeData(final String tag){


        new Thread(new Runnable() {
            @Override
            public void run() {

                String saveFileNameFinal[]=new String[11];
                for (int k=0;k<11;k++){
                    saveFileNameFinal[k]=SelectDataActivity.sdcardPath+(k+1)+"ChangeFinal"+tag+".txt";
                    System.out.println("保存路径："+saveFileNameFinal[k]);
                }
                try{
                    File file1 = new File(saveFileNameFinal[0]);
                    InputStreamReader inputReader1 = new InputStreamReader(new FileInputStream(file1));
                    BufferedReader bf1 = new BufferedReader(inputReader1);

                    File file2 = new File(saveFileNameFinal[1]);
                    InputStreamReader inputReader2 = new InputStreamReader(new FileInputStream(file2));
                    BufferedReader bf2 = new BufferedReader(inputReader2);

                    File file3 = new File(saveFileNameFinal[2]);
                    InputStreamReader inputReader3 = new InputStreamReader(new FileInputStream(file3));
                    BufferedReader bf3 = new BufferedReader(inputReader3);

                    File file4 = new File(saveFileNameFinal[3]);
                    InputStreamReader inputReader4 = new InputStreamReader(new FileInputStream(file4));
                    BufferedReader bf4 = new BufferedReader(inputReader4);

                    File file5 = new File(saveFileNameFinal[4]);
                    InputStreamReader inputReader5 = new InputStreamReader(new FileInputStream(file5));
                    BufferedReader bf5 = new BufferedReader(inputReader5);

                    File file6 = new File(saveFileNameFinal[5]);
                    InputStreamReader inputReader6 = new InputStreamReader(new FileInputStream(file6));
                    BufferedReader bf6 = new BufferedReader(inputReader6);

                    File file7 = new File(saveFileNameFinal[6]);
                    InputStreamReader inputReader7 = new InputStreamReader(new FileInputStream(file7));
                    BufferedReader bf7 = new BufferedReader(inputReader7);

                    File file8 = new File(saveFileNameFinal[7]);
                    InputStreamReader inputReader8 = new InputStreamReader(new FileInputStream(file8));
                    BufferedReader bf8 = new BufferedReader(inputReader8);

                    File file9 = new File(saveFileNameFinal[8]);
                    InputStreamReader inputReader9 = new InputStreamReader(new FileInputStream(file9));
                    BufferedReader bf9 = new BufferedReader(inputReader9);

                    File file10 = new File(saveFileNameFinal[9]);
                    InputStreamReader inputReader10 = new InputStreamReader(new FileInputStream(file10));
                    BufferedReader bf10 = new BufferedReader(inputReader10);

                    File file11 = new File(SelectDataActivity.sdcardPath+"11Change"+tag+".txt");
                    InputStreamReader inputReader11 = new InputStreamReader(new FileInputStream(file11));
                    BufferedReader bf11 = new BufferedReader(inputReader11);

                    String str1="",str2="",str3="",str4="",str5="",str6="",str7="",str8="",str9="",str10="",str11="";

                    while ((str1 = bf1.readLine()) != null) {
                        str2=bf2.readLine();
                        str3=bf3.readLine();
                        str4=bf4.readLine();
                        str5=bf5.readLine();
                        str6=bf6.readLine();
                        str7=bf7.readLine();
                        str8=bf8.readLine();
                        str9=bf9.readLine();
                        str10=bf10.readLine();
                        str11=bf11.readLine();

                        if(computeFrequency(str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11)){
                            String key="10/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str2,str3,str4,str5,str6,str7,str8,str9,str10,str11)){
                            String key="9/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str3,str4,str5,str6,str7,str8,str9,str10,str11)){
                            String key="8/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str4,str5,str6,str7,str8,str9,str10,str11)){
                            String key="7/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str5,str6,str7,str8,str9,str10,str11)){
                            String key="6/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str6,str7,str8,str9,str10,str11)){
                            String key="5/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str7,str8,str9,str10,str11)){
                            String key="4/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str8,str9,str10,str11)){
                            String key="3/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str9,str10,str11)){
                            String key="2/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }

                    }
                    /*inputReader1.close();
                    bf1.close();

                    inputReader2.close();
                    bf2.close();

                    inputReader3.close();
                    bf3.close();

                    inputReader4.close();
                    bf4.close();

                    inputReader5.close();
                    bf5.close();

                    inputReader6.close();
                    bf6.close();

                    inputReader7.close();
                    bf7.close();

                    inputReader8.close();
                    bf8.close();

                    inputReader9.close();
                    bf9.close();

                    inputReader10.close();
                    bf10.close();

                    inputReader11.close();
                    bf11.close();*/

                }catch(Exception e){
                    e.printStackTrace();
                }

                OriginData.index++;
                if (OriginData.index>=211){
                    String dd="";
                    Iterator iter =OriginData.computeDataResult.entrySet().iterator();
                    while (iter.hasNext()) {
                        Map.Entry entry = (Map.Entry) iter.next();
                        dd=dd + entry.getKey()+entry.getValue()+"\n";
                    }
                    //dd=dd+"第 "+tag+" 次裂变统计完成！";
                    computeResultText.setText(dd);
                }
            }
        }).start();

    }

    public synchronized void computeDataAll(final String tag){


        new Thread(new Runnable() {
            @Override
            public void run() {

                String saveFileNameFinal[]=new String[11];
                for (int k=0;k<11;k++){
                    saveFileNameFinal[k]=SelectDataActivity.sdcardPath+(k+1)+"ChangeFinal"+tag+".txt";
                    System.out.println("保存路径："+saveFileNameFinal[k]);
                }
                try{
                    File file1 = new File(saveFileNameFinal[0]);
                    InputStreamReader inputReader1 = new InputStreamReader(new FileInputStream(file1));
                    BufferedReader bf1 = new BufferedReader(inputReader1);

                    File file2 = new File(saveFileNameFinal[1]);
                    InputStreamReader inputReader2 = new InputStreamReader(new FileInputStream(file2));
                    BufferedReader bf2 = new BufferedReader(inputReader2);

                    File file3 = new File(saveFileNameFinal[2]);
                    InputStreamReader inputReader3 = new InputStreamReader(new FileInputStream(file3));
                    BufferedReader bf3 = new BufferedReader(inputReader3);

                    File file4 = new File(saveFileNameFinal[3]);
                    InputStreamReader inputReader4 = new InputStreamReader(new FileInputStream(file4));
                    BufferedReader bf4 = new BufferedReader(inputReader4);

                    File file5 = new File(saveFileNameFinal[4]);
                    InputStreamReader inputReader5 = new InputStreamReader(new FileInputStream(file5));
                    BufferedReader bf5 = new BufferedReader(inputReader5);

                    File file6 = new File(saveFileNameFinal[5]);
                    InputStreamReader inputReader6 = new InputStreamReader(new FileInputStream(file6));
                    BufferedReader bf6 = new BufferedReader(inputReader6);

                    File file7 = new File(saveFileNameFinal[6]);
                    InputStreamReader inputReader7 = new InputStreamReader(new FileInputStream(file7));
                    BufferedReader bf7 = new BufferedReader(inputReader7);

                    File file8 = new File(saveFileNameFinal[7]);
                    InputStreamReader inputReader8 = new InputStreamReader(new FileInputStream(file8));
                    BufferedReader bf8 = new BufferedReader(inputReader8);

                    File file9 = new File(saveFileNameFinal[8]);
                    InputStreamReader inputReader9 = new InputStreamReader(new FileInputStream(file9));
                    BufferedReader bf9 = new BufferedReader(inputReader9);

                    File file10 = new File(saveFileNameFinal[9]);
                    InputStreamReader inputReader10 = new InputStreamReader(new FileInputStream(file10));
                    BufferedReader bf10 = new BufferedReader(inputReader10);

                    File file11 = new File(SelectDataActivity.sdcardPath+"11Change"+tag+".txt");
                    InputStreamReader inputReader11 = new InputStreamReader(new FileInputStream(file11));
                    BufferedReader bf11 = new BufferedReader(inputReader11);

                    String str1="",str2="",str3="",str4="",str5="",str6="",str7="",str8="",str9="",str10="",str11="";

                    while ((str1 = bf1.readLine()) != null) {
                        str2=bf2.readLine();
                        str3=bf3.readLine();
                        str4=bf4.readLine();
                        str5=bf5.readLine();
                        str6=bf6.readLine();
                        str7=bf7.readLine();
                        str8=bf8.readLine();
                        str9=bf9.readLine();
                        str10=bf10.readLine();
                        str11=bf11.readLine();
                        if (Integer.parseInt(str11)<1){
                            continue;
                        }

                        if(computeFrequency(str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11)){
                            String key="10/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str2,str3,str4,str5,str6,str7,str8,str9,str10,str11)){
                            String key="9/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str3,str4,str5,str6,str7,str8,str9,str10,str11)){
                            String key="8/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str4,str5,str6,str7,str8,str9,str10,str11)){
                            String key="7/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str5,str6,str7,str8,str9,str10,str11)){
                            String key="6/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str6,str7,str8,str9,str10,str11)){
                            String key="5/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str7,str8,str9,str10,str11)){
                            String key="4/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str8,str9,str10,str11)){
                            String key="3/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }else if(computeFrequency(str9,str10,str11)){
                            String key="2/"+str11+"/";
                            String value=OriginData.computeDataResult.get(key);
                            if(value!=null&&!"".equals(value)){
                                int v=Integer.parseInt(value)+1;
                                OriginData.computeDataResult.put(key, v+"");
                            }else{
                                OriginData.computeDataResult.put(key, "1");
                            }
                        }

                    }
                    inputReader1.close();
                    bf1.close();

                    inputReader2.close();
                    bf2.close();

                    inputReader3.close();
                    bf3.close();

                    inputReader4.close();
                    bf4.close();

                    inputReader5.close();
                    bf5.close();

                    inputReader6.close();
                    bf6.close();

                    inputReader7.close();
                    bf7.close();

                    inputReader8.close();
                    bf8.close();

                    inputReader9.close();
                    bf9.close();

                    inputReader10.close();
                    bf10.close();

                    inputReader11.close();
                    bf11.close();

                }catch(Exception e){
                    e.printStackTrace();
                }

                OriginData.index++;
                if (OriginData.index>=210){
                    //Toast.makeText(StepComputeActivity.this,"查看所有的结果",Toast.LENGTH_LONG).show();
                    Iterator iter =OriginData.computeDataResult.entrySet().iterator();
                    while (iter.hasNext()) {
                        Map.Entry entry = (Map.Entry) iter.next();
                        dd=dd + entry.getKey()+entry.getValue()+"\n";
                    }
                    //dd=dd+"第 "+tag+" 次裂变统计完成！";
                    /*computeResultText.setText(dd);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            computeResultText.setText(dd);
                        }
                    });*/
                    OriginData.result=dd;
                    startActivity(new Intent(StepComputeActivity.this,ResultActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(StepComputeActivity.this,StepComputeActivity.class));
                    finish();
                }


               /* if (index<211){
                    computeDataAll(index+"");
                }*/
            }
        }).start();

    }


    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")&&h.contains("color=")&&i.contains("color=")&&j.contains("color=")){
            tag=true;
        }
        return tag;
    }

    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")&&h.contains("color=")&&i.contains("color=")){
            tag=true;
        }
        return tag;
    }

    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h,String i){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")&&h.contains("color=")){
            tag=true;
        }
        return tag;
    }

    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g,String h){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")&&g.contains("color=")){
            tag=true;
        }
        return tag;
    }
    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f,String g){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")
                &&f.contains("color=")){
            tag=true;
        }
        return tag;
    }
    public static boolean computeFrequency(String a,String b,String c,String d,String e,String f){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")&&e.contains("color=")){
            tag=true;
        }
        return tag;
    }
    public static boolean computeFrequency(String a,String b,String c,String d,String e){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")&&d.contains("color=")){
            tag=true;
        }
        return tag;
    }

    public static boolean computeFrequency(String a,String b,String c,String d){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")&&c.contains("color=")){
            tag=true;
        }
        return tag;
    }


    public static boolean computeFrequency(String a,String b,String c){
        boolean tag=false;
        if(a.contains("color=")&&b.contains("color=")){
            tag=true;
        }
        return tag;
    }


}
