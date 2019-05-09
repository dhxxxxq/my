package com.example.mytest;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    DatePicker datePicker;
    int year,month,day;
    ProgressBar progressBar;
    int mprogress=0;
    Handler mhandler;
    Message message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar a=getSupportActionBar();
        if(a!=null){setTheme(R.style.bgTheme);
            a.hide();
        }
        rg = findViewById(R.id.radio);
        Button button = findViewById(R.id.resetOne);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                for(int i=0;i<rg.getChildCount();i++){
                    RadioButton radio=(RadioButton)rg.getChildAt(i);
                    if(radio.isChecked()){
                        if(radio.getText().equals("男")){
                            Toast.makeText(MainActivity.this,"回答正确",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"回答错误",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
                 */
                //Intent intent = new Intent(MainActivity.this, Main4Activity.class);
                //startActivity(intent);
                switch (view.getId()){
                    case R.id.resetOne:
                        AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("警告");
                        dialog.setMessage("这是要确定跳转界面吗！");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MainActivity.this, Main8Activity.class);
                                startActivity(intent);
                            }
                        });
                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        dialog.show();
                        break;
                        default:break;
                }
            }
        });


        progressBar=findViewById(R.id.progressBar);
        mhandler=new Handler(){

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(message.what==0x111){
                    progressBar.setProgress(mprogress);
                }else{
                    Toast.makeText(MainActivity.this,"进度已经完成",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){
                    mprogress=doWork();
                    message=new Message();
                    if(mprogress<100){
                        message.what=0x111;
                        mhandler.sendMessage(message);
                    }else{
                        message.what=0x110;
                        mhandler.sendMessage(message);
                        break;
                    }
                }
            }
            private int doWork(){

                mprogress+=Math.random()*10;
                try {
                    Thread.sleep(200);
                }catch (InterruptedException e){

                    e.printStackTrace();
                }
                return mprogress;
            }
        }).start();


    }
}
