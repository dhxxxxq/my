package com.example.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {

    int[] p={R.drawable.background,R.drawable.backgroundone,R.drawable.view1,R.drawable.view2,R.drawable.view3,R.drawable.view2};
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
      /* ImageSwitcher imageSwitcher=findViewById(R.id.imageSwitcher);
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(Main3Activity.this,android.R.anim.fade_out));
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(Main3Activity.this,android.R.anim.fade_in));
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(Main3Activity.this);
                imageView.setImageResource(R.drawable.background);

                return imageView;
            }
        });
        imageSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ImageSwitcher)view).setImageResource(R.drawable.backgroundone);
            }
        });
        */
      gridView=findViewById(R.id.gridView);
      List<Map<String,Object>> listItem = new ArrayList<Map<String,Object>>();
        for(int i=0;i<p.length;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("imge",p[i]);
            listItem.add(map);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItem,R.layout.imge,new String[]{"imge"},new int[]{R.id.imge});
        gridView.setAdapter(simpleAdapter);

        String[] str={"全部","美术","音乐","文学"};
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner=findViewById(R.id.spinner);
        spinner.setAdapter(arrayAdapter);
        String str3=spinner.getSelectedItem().toString();
        Toast.makeText(Main3Activity.this,str3,Toast.LENGTH_SHORT).show();
    }
}
