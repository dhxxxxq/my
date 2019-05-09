package com.example.mytest;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Spinner spinner1=findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String str=adapterView.getItemAtPosition(i).toString();

                Toast.makeText(Main4Activity.this,str,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        String[] ctr={"美术","音乐","减少"};
        ListView listView=findViewById(R.id.list_item);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,ctr);
        listView.setAdapter(adapter);


        String[] name={"妞儿","网三","李四","张三","王五"};
        int[] img={R.drawable.view3,R.drawable.view2,R.drawable.view3,R.drawable.view1,R.drawable.view2};
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        for(int i=0;i<img.length;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("name",name[i]);
            map.put("img",img[i]);
            list.add(map);
        }

        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.simple,new String[]{"img","name"},new int[]{R.id.image1,R.id.name1});
        ListView listView2=findViewById(R.id.listView);
        listView2.setAdapter(simpleAdapter);
    }

}
