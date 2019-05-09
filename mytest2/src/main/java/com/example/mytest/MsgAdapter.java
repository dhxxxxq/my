package com.example.mytest;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 17630 on 2019/3/26.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    private List<Msg> mMsgList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout,rightLayout;

        TextView leftMsg,rightMsg;

        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout= itemView.findViewById(R.id.left_layout);
            rightLayout=itemView.findViewById(R.id.right_layout);
            leftMsg=itemView.findViewById(R.id.left_msg );
            rightMsg=itemView.findViewById(R.id.right_msg);

        }
    }


    public MsgAdapter(List<Msg>  mlist) {
        mMsgList=mlist;

    }
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }
    public void onBindViewHolder(ViewHolder holder,int position){
        //获取当前的项
        Msg msg=mMsgList.get(position);
        if(msg.getType()==Msg.TYPE_RECEIVED){
            //如果是收到消息，则显示左边的消息布局，将右边的消息布局隐藏
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());

        }else if(msg.getType()==Msg.TYPE_SENT){
            //如果是发送消息，则显示右边的消息布局，将左边 的消息布局隐藏
            holder.rightLayout .setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());
        }
    }
    public int getItemCount(){
        return mMsgList.size();
    }
}
