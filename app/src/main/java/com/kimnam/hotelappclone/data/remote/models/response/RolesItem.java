package com.kimnam.hotelappclone.data.remote.models.response;

import com.google.gson.annotations.SerializedName;

public class RolesItem{

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return
                "RolesItem{" +
                        "name = '" + name + '\'' +
                        ",id = '" + id + '\'' +
                        "}";
    }
}