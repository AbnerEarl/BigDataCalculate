package com.example.frank.bigdatacalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.frank.bigdatacalculate.config.OriginData;
import com.example.frank.bigdatacalculate.utils.DataResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main3Activity extends AppCompatActivity {

    private TextView originData,firstData,secondData,thirdData;
    private String tag="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        originData=findViewById(R.id.textView3);
        firstData=findViewById(R.id.first_caculate_value);
        secondData=findViewById(R.id.second_caculate_value);
        thirdData=findViewById(R.id.third_caculate_value);
        tag=getIntent().getStringExtra("tag");

        new Thread(new Runnable() {
            @Override
            public void run() {

                if (OriginData.dataMode.equals("7")) {
                    if (tag.equals("1")) {
                        String dd = "";
                        for (int i = 0; i < MainActivity.input1.length; i++) {
                            dd += MainActivity.input1[i] + ",";
                        }
                        System.out.println("原始数据：" + dd);
                        originData.setText(dd);

                        //第一次裂变数据
                        try {
                            File file = new File(MainActivity.sdcardPath + DataResult.af11 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            firstData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第二次裂变数据
                        try {
                            File file = new File(MainActivity.sdcardPath + DataResult.af12 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            secondData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第三次裂变数据
                        try {
                            File file = new File(MainActivity.sdcardPath + DataResult.af13 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            thirdData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (tag.equals("2")) {
                        String dd = "";
                        for (int i = 0; i < MainActivity.input2.length; i++) {
                            dd += MainActivity.input2[i] + ",";
                        }
                        System.out.println("原始数据：" + dd);
                        originData.setText(dd);

                        //第一次裂变数据
                        try {
                            File file = new File(MainActivity.sdcardPath + DataResult.af21 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            firstData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第二次裂变数据
                        try {
                            File file = new File(MainActivity.sdcardPath + DataResult.af22 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            secondData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第三次裂变数据
                        try {
                            File file = new File(MainActivity.sdcardPath + DataResult.af23 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            thirdData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (tag.equals("3")) {
                        String dd = "";
                        for (int i = 0; i < MainActivity.input3.length; i++) {
                            dd += MainActivity.input3[i] + ",";
                        }
                        originData.setText(dd);

                        //第一次裂变数据
                        try {
                            File file = new File(MainActivity.sdcardPath + DataResult.af31 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            firstData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第二次裂变数据
                        try {
                            File file = new File(MainActivity.sdcardPath + DataResult.af32 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            secondData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第三次裂变数据
                        try {
                            File file = new File(MainActivity.sdcardPath + DataResult.af33 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            thirdData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (tag.equals("4")) {
                        String dd = "";
                        for (int i = 0; i < MainActivity.input4.length; i++) {
                            dd += MainActivity.input4[i] + ",";
                        }
                        originData.setText(dd);

                        //第一次裂变数据
                        try {
                            File file = new File(MainActivity.sdcardPath + DataResult.af41 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            firstData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第二次裂变数据
                        try {
                            File file = new File(MainActivity.sdcardPath + DataResult.af42 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            secondData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第三次裂变数据
                        try {
                            File file = new File(MainActivity.sdcardPath + DataResult.af43 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            thirdData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }else if (OriginData.dataMode.equals("21")){
                    if (tag.equals("1")) {
                        String dd = "";
                        for (int i = 0; i < OriginData.input1.length; i++) {
                            dd += OriginData.input1[i] + ",";
                        }
                        System.out.println("原始数据：" + dd);
                        originData.setText(dd);

                        //第一次裂变数据
                        try {
                            File file = new File(MainActivityFor21.sdcardPath + DataResult.af11 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            firstData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第二次裂变数据
                        try {
                            File file = new File(MainActivityFor21.sdcardPath + DataResult.af12 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            secondData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第三次裂变数据
                        try {
                            File file = new File(MainActivityFor21.sdcardPath + DataResult.af13 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            thirdData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (tag.equals("2")) {
                        String dd = "";
                        for (int i = 0; i < OriginData.input2.length; i++) {
                            dd += OriginData.input2[i] + ",";
                        }
                        System.out.println("原始数据：" + dd);
                        originData.setText(dd);

                        //第一次裂变数据
                        try {
                            File file = new File(MainActivityFor21.sdcardPath + DataResult.af21 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            firstData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第二次裂变数据
                        try {
                            File file = new File(MainActivityFor21.sdcardPath + DataResult.af22 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            secondData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第三次裂变数据
                        try {
                            File file = new File(MainActivityFor21.sdcardPath + DataResult.af23 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            thirdData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (tag.equals("3")) {
                        String dd = "";
                        for (int i = 0; i < OriginData.input3.length; i++) {
                            dd += OriginData.input3[i] + ",";
                        }
                        originData.setText(dd);

                        //第一次裂变数据
                        try {
                            File file = new File(MainActivityFor21.sdcardPath + DataResult.af31 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            firstData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第二次裂变数据
                        try {
                            File file = new File(MainActivityFor21.sdcardPath + DataResult.af32 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            secondData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第三次裂变数据
                        try {
                            File file = new File(MainActivityFor21.sdcardPath + DataResult.af33 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            thirdData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (tag.equals("4")) {
                        String dd = "";
                        for (int i = 0; i < OriginData.input4.length; i++) {
                            dd += OriginData.input4[i] + ",";
                        }
                        originData.setText(dd);

                        //第一次裂变数据
                        try {
                            File file = new File(MainActivityFor21.sdcardPath + DataResult.af41 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            firstData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第二次裂变数据
                        try {
                            File file = new File(MainActivityFor21.sdcardPath + DataResult.af42 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            secondData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //第三次裂变数据
                        try {
                            File file = new File(MainActivityFor21.sdcardPath + DataResult.af43 + ".txt");
                            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
                            BufferedReader bf = new BufferedReader(inputReader);

                            String str, finalStr = "";
                            while ((str = bf.readLine()) != null) {
                                finalStr = finalStr + str + ",";
                            }
                            thirdData.setText(Html.fromHtml(finalStr));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }
}
