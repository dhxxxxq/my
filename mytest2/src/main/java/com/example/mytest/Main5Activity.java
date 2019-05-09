package com.example.mytest;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main5Activity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        /*
        Button button=findViewById(R.id.buttonOne);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog p=new ProgressDialog(Main5Activity.this);
                p.setTitle("请耐心等待！");
                p.setMessage("加载中...");
                p.setCancelable(true);
                p.show();
            }
        });
        */
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("img",R.drawable.background);
        map.put("name","静静地");

        list.add(map);
        map=new HashMap<String,Object>();
        map.put("img",R.drawable.view1);
        map.put("name","中国话");

        list.add(map);
        map=new HashMap<String,Object>();
        map.put("img",R.drawable.view2);
        map.put("name","暗精灵");

        list.add(map);
        map=new HashMap<String,Object>();
        map.put("img",R.drawable.view3);
        map.put("name","越高");

        list.add(map);
        map=new HashMap<String,Object>();
        map.put("img",R.drawable.view1);
        map.put("name","中国话");

        list.add(map);
        map=new HashMap<String,Object>();
        map.put("img",R.drawable.view1);
        map.put("name","中国话");
        map.put("button2","下载");
        list.add(map);
        map=new HashMap<String,Object>();
        map.put("img",R.drawable.view2);
        map.put("name","暗精灵");
        list.add(map);
        map=new HashMap<String,Object>();
        map.put("img",R.drawable.view3);
        map.put("name","越高");

        list.add(map);
        map=new HashMap<String,Object>();
        map.put("img",R.drawable.view1);
        map.put("name","中国话");

        list.add(map);
        /*
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.simple,new String[]{"img","name"},new int[]{R.id.image1,R.id.name1});
        ListView listView=findViewById(R.id.listViewOne);
        listView.setAdapter(simpleAdapter);
        */
        AnimalAdapter myAdapter=new AnimalAdapter(this);//this就是Main5Activity,然后生成放射器
        myAdapter.setList(list);
        ListView listView=findViewById(R.id.listViewOne);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(this,"点击事件"+i,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,"长按事件"+i,Toast.LENGTH_SHORT).show();
        return false;
    }
}
