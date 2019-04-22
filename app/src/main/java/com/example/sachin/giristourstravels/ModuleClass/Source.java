package com.example.sachin.giristourstravels.ModuleClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source {
    @SerializedName("sourse")
    @Expose
    private String sourse;

    public String getSourse() {
        return sourse;
    }

    public void setSourse(String sourse) {
        this.sourse = sourse;
    }
}
