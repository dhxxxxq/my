package com.example.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main7Activity extends AppCompatActivity {
    private List<Fruit> fruitList=new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        initFruits();
        RecyclerView recyclerView=findViewById(R.id.recyclerView1);
        FruitAdapter fruitAdapter=new FruitAdapter(fruitList);
     //  LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
      // layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(fruitAdapter);




    }

    private void initFruits() {

            Fruit apple=new Fruit(getRandomlengthName("apple"),R.drawable.view1);
            fruitList.add(apple);
            Fruit banana=new Fruit(getRandomlengthName("banana"),R.drawable.view2);
            fruitList.add(banana);
            Fruit orange=new Fruit(getRandomlengthName("orange"),R.drawable.view3);
            fruitList.add(orange);
            Fruit apple1=new Fruit(getRandomlengthName("apple"),R.drawable.view1);
            fruitList.add(apple1);
            Fruit banana1=new Fruit(getRandomlengthName("banana"),R.drawable.view2);
            fruitList.add(banana1);
            Fruit orange1=new Fruit(getRandomlengthName("orange"),R.drawable.view3);
            fruitList.add(orange1);
            Fruit apple2=new Fruit(getRandomlengthName("apple"),R.drawable.view1);
            fruitList.add(apple2);
            Fruit banana2=new Fruit(getRandomlengthName("banana"),R.drawable.view2);
            fruitList.add(banana2);
            Fruit orange2=new Fruit(getRandomlengthName("orange"),R.drawable.view3);
            fruitList.add(orange2);
            Fruit apple3=new Fruit(getRandomlengthName("apple"),R.drawable.view1);
            fruitList.add(apple3);
            Fruit banana3=new Fruit(getRandomlengthName("banana"),R.drawable.view2);
            fruitList.add(banana3);
            Fruit orange3=new Fruit(getRandomlengthName("orange"),R.drawable.view3);
            fruitList.add(orange3);

    }
    private String getRandomlengthName(String name){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(i);
        }
        return builder.toString();
    }
}
