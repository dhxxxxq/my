package com.example.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Main8Activity extends AppCompatActivity {

    private List<Msg> msgList=new ArrayList<Msg>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        initMsgs();
        inputText=findViewById(R.id.input_text);
        send=findViewById(R.id.send);
        msgRecyclerView=findViewById(R.id.recyclerView1);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        msgAdapter=new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(msgAdapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    //自己输入
                    msgAdapter.notifyItemInserted(msgList.size()-1);
                    //当有新消息时，就会刷新列表的显示
                    msgRecyclerView.scrollToPosition(msgList.size()-1);
                    //将其定义到最后一行
                    inputText.setText("");
                }
            }
        });

    }

    private void initMsgs() {
        Msg msg=new Msg("Hello guy",Msg.TYPE_RECEIVED);
        msgList.add(msg);
        Msg msg2=new Msg("Hello who is that",Msg.TYPE_SENT);//静态变量，通过类名访问
        msgList.add(msg2);
        Msg msg1=new Msg("This is Tom",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
    }
}
