package com.example.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Main6Activity extends AppCompatActivity implements View.OnClickListener {

    private Button button1,button2,button3,button4;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        recyclerView=findViewById(R.id.recyclerView);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        recyclerView.setOnClickListener(this);
        initDate();

    }

    private void initDate() {
        //设置布局管理器


        //设置数据
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                break;
            case R.id.button4 :
                break;
        }
    }
}
