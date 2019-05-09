package com.example.mytest;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button login;
    CheckBox checkBox1,checkBox2,checkBox3;

    Chronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        checkBox1=findViewById(R.id.checkbox1);
         checkBox2=findViewById(R.id.checkbox2);
       checkBox3=findViewById(R.id.checkbox3);
          login.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  String checked="";
                  if(checkBox1.isChecked()){
                      checked+=checkBox1.getText().toString();
                  }
                  if(checkBox2.isChecked()){
                      checked+=checkBox2.getText().toString();
                  }
                  if(checkBox3.isChecked()){
                      checked+=checkBox3.getText().toString();
                  }
                  Toast.makeText(Main2Activity.this,checked,Toast.LENGTH_SHORT).show();
              }
          });
          chronometer.setBase(SystemClock.elapsedRealtime());
          chronometer.setFormat("%s");
          chronometer.start();
          chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
              @Override
              public void onChronometerTick(Chronometer chronometer) {
                  if(SystemClock.elapsedRealtime()-chronometer.getBase()>6000){
                      chronometer.stop();
                  }
              }
          });
        SeekBar seekBar=findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(Main2Activity.this,"进度条开始改变",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Main2Activity.this,"进度条开始拖动",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(Main2Activity.this,"进度条结束拖动",Toast.LENGTH_SHORT).show();

            }
        });

       /* checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox.isChecked()) {

                    Toast.makeText(Main2Activity.this, checkBox.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        */
    }
}
