package com.example.mytest;

/**
 * Created by 17630 on 2019/3/24.
 */

public class Fruit {
    private String name;
    private int imageId;
    public void setName(String name){
        this.name=name;
    }
    public void setImageId(int imageId ){
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }

    public Fruit(String name,int imageId) {
        this.name=name;
        this.imageId = imageId;
    }
}
