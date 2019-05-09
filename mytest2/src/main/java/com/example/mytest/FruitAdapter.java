package com.example.mytest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 17630 on 2019/3/25.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mlist;
    static class ViewHolder extends RecyclerView.ViewHolder{
        //点击事件需要加的以下一行
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View view){
            super(view);
            //点击事件需要加的以下一行
            fruitView=view;
            fruitImage=view.findViewById(R.id.fruitImage2);
            fruitName=view.findViewById(R.id.fruitName2);
        }
    }

    public FruitAdapter(List<Fruit> fruitList){
        mlist=fruitList;//把数据源引进来
    }
    //每一行view的 布局，负责承载每个子项的布局
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_two,parent,false);
        final ViewHolder holder=new ViewHolder(view);//创建一个子视图
        //以下是点击事件需要加的
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Fruit fruit=mlist.get(position);
                Toast.makeText(view.getContext(),"you are clicked view"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Fruit fruit=mlist.get(position);
                Toast.makeText(view.getContext(),"you are clicked image"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;

    }
    //负责将每个子项holder绑定数据
    public void onBindViewHolder(ViewHolder holder,int position){
        Fruit fruit=mlist.get(position);//获取当前项的实例
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }
    public int getItemCount(){
        return mlist.size();
    }
}
