package com.example.frank.bigdatacalculate;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.frank.bigdatacalculate.config.OriginData;

import java.util.ArrayList;
import java.util.List;

public class ComputeAllActivity extends AppCompatActivity {

    private ListView lv_trip_info;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compute_all);


        lv_trip_info=findViewById(R.id.lv_compute_result);
        myAdapter=new MyAdapter(ComputeAllActivity.this);
        //Log.i("图片url", "onCreate: "+SecondHInfo.sencondHandInfo.getPicUrl());
        lv_trip_info.setAdapter(myAdapter);
        lv_trip_info.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*OriginData.lookAllResult=true;
                Intent intent=new Intent(ComputeAllActivity.this,StepComputeActivity.class);
                intent.putExtra("tag",(position+1)+"");
                startActivity(intent);*/
            }
        });

        String info="";
        myAdapter.list.add("查看全部统计结果");
        //分组统计结果
        /*for (int i=1;i<212;i++){
            info="第 "+i+" 组统计结果";
            myAdapter.list.add(info);
        }*/

        myAdapter.notifyDataSetChanged();

    }

    private class MyAdapter extends BaseAdapter {

        private LayoutInflater layoutInflater;
        List<String> list=new ArrayList<>();

        public MyAdapter(Context context){
            this.layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView==null){
                convertView=layoutInflater.inflate(R.layout.item_compute,null);
                holder=new ViewHolder();
                holder.computeResult=convertView.findViewById(R.id.btn_item_compute);


                convertView.setTag(holder);
            }
            else {
                holder=(ViewHolder)convertView.getTag();
            }

            holder.computeResult.setText(""+list.get(position));

            holder.computeResult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.computeResult.setEnabled(false);
                    OriginData.lookAllResult=true;
                    Intent intent=new Intent(ComputeAllActivity.this,StepComputeActivity.class);
                    intent.putExtra("tag",(position+1)+"");
                    startActivity(intent);
                }
            });


            return convertView;
        }
    }

    public final class ViewHolder{
        public Button computeResult;

    }
}
