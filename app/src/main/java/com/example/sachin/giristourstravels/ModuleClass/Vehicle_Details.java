package com.example.sachin.giristourstravels.ModuleClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vehicle_Details {
    @SerializedName("v_name")
    @Expose
    private String vName;
    @SerializedName("v_number")
    @Expose
    private String vNumber;
    @SerializedName("sourse")
    @Expose
    private String sourse;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("no_of_seat")
    @Expose
    private String noOfSeat;
    @SerializedName("v_photo")
    @Expose
    private String vPhoto;

    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName = vName;
    }

    public String getVNumber() {
        return vNumber;
    }

    public void setVNumber(String vNumber) {
        this.vNumber = vNumber;
    }

    public String getSourse() {
        return sourse;
    }

    public void setSourse(String sourse) {
        this.sourse = sourse;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNoOfSeat() {
        return noOfSeat;
    }

    public void setNoOfSeat(String noOfSeat) {
        this.noOfSeat = noOfSeat;
    }

    public String getVPhoto() {
        return vPhoto;
    }

    public void setVPhoto(String vPhoto) {
        this.vPhoto = vPhoto;
    }
}
