package com.example.mytest;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 17630 on 2019/3/24.
 */

public  class AnimalAdapter extends BaseAdapter {
    List<Map<String,Object>> list;
    LayoutInflater inflater;
    ViewHolder viewHolder=null;

    public AnimalAdapter(List<Map<String, Object>> list) {
        this.list = list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }
    public AnimalAdapter(Context context) {
        this.inflater=LayoutInflater.from(context);
        //构造方法
    }
    public int getCount(){
        return list.size();
    }
    public Object getItem(int position){
        return list.get(position);
    }
    public long getItemId(int position) {
        return position;//当前项的id
    }
    public View getView(int i, View view, ViewGroup viewGroup){
        if(view==null){

            view=inflater.inflate(R.layout.fruit,null);
            viewHolder.imageView=view.findViewById(R.id.fruitImage1);
            viewHolder.textView=view.findViewById(R.id.fruitName1);
            view.setTag(viewHolder);
        }
        else{
            view.getTag();
        }
        Map map=list.get(i);
        viewHolder.imageView.setImageResource((Integer)map.get("img"));
        viewHolder.textView.setText((String)map.get("name"));
        return view;
    }
    public class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}

