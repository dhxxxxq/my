package com.example.a17630.mytest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main2Activity extends MainActivity {
    RadioGroup s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         s=findViewById(R.id.na);
        s.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton=findViewById(i);
                Toast.makeText(Main2Activity.this,"性别："+radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        Button reset=findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view1) {
                for(int i=0;i<s.getChildCount();i++){
                    RadioButton r=(RadioButton)s.getChildAt(i);
                    if(r.isChecked()){
                        Toast.makeText(Main2Activity.this,r.getText(),Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
        Button button1=findViewById(R.id.buttonOne);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this,"点击率按钮1",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void myClick(View view){
        Toast.makeText(Main2Activity.this,"点击了按钮2",Toast.LENGTH_SHORT).show();

    }
}
