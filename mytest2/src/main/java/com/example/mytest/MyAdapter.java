package com.example.mytest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by 17630 on 2019/3/24.
 */

public class MyAdapter extends BaseAdapter {
    List<Map<String,Object>> list;
    LayoutInflater inflater;//反射器

    public MyAdapter(Context context) {
        this.inflater=LayoutInflater.from(context);
        //构造方法
    }
    public void setList( List<Map<String,Object>> list){
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
        //该方法是返回list的条数就是大小。0是不显示。
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
        //获取项目中的项，i为当前项的下标
    }

    @Override
    public long getItemId(int i) {
        return i;//当前项的id
    }

    @Override
    //该方法就是list中的显示一行的内容，然后的View是什么就显示成怎样的
    public View getView(int i, View view, ViewGroup viewGroup) {//当listView中的一行一行显示的时候就调用getView方法。
        //View view1=inflater.inflate(R.layout.simple,null);//创建一个view，这样要引入intem布局，由于这里item的引用，所以用反射器来反射，然后参数是item的布局，把布局反射成一个对象
       ViewHolder viewHolder=null;
        if(view==null){//convertView的应用，view是从缓冲池中判断
           view=inflater.inflate(R.layout.simple,null);
           viewHolder=new ViewHolder();
           viewHolder.imageView=view.findViewById(R.id.image1);
           viewHolder.textView=view.findViewById(R.id.name1);
           view.setTag(viewHolder);//convertView与ViewHolder关联

       }else{
            viewHolder=(ViewHolder)view.getTag();

        }

        Map map=list.get(i);//从list中取对象map
        viewHolder.imageView.setImageResource((Integer)map.get("img"));//img为key的值
        viewHolder.textView.setText((String)map.get("name"));
        return view;//充满数据的view
    }
    public class ViewHolder{
        //需要赋值的控件
        ImageView imageView;
        TextView textView;
    }
}
