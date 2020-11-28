package com.example.homework;

public class People {
    private String name;
    private int imgid;
    public People(String name,int imgid){
        this.name=name;
        this.imgid=imgid;
    }
    public String getName(){
        return name;
    }
    public int getImgid(){
        return imgid;
    }
}
