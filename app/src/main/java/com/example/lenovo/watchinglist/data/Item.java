package com.example.lenovo.watchinglist.data;

public class Item {
    private String name,type,statue;
    private int ep;

    public Item(String name,String type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }
}
