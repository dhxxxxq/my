package com.example.a17630.mytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 17630 on 2019/3/21.
 */

public class ActivityColletor {

    public static List<Activity> activitylist=new ArrayList<>();
    public static void addActivity(Activity activity){
        activitylist.add(activity);
    }

    public static void removeActivity(Activity activity){
        activitylist.remove(activity);
    }
    public static void finishiAll(){
        for(Activity activity:activitylist){
            if(activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
