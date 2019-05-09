package com.example.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FruitActivity extends AppCompatActivity {
    private List<Fruit> fruitList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        initFruits();


    }
    private void initFruits(){
        for(int i=0;i<2;i++){
            Fruit apple=new Fruit("Apple",R.drawable.view3);
            fruitList.add(apple);
            Fruit a=new Fruit("Apple",R.drawable.view2);
            fruitList.add(apple);
            Fruit ap=new Fruit("Apple",R.drawable.view1);
            fruitList.add(apple);

        }
    }
}
