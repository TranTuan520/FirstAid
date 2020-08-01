package com.example.firstaid.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Accident implements Serializable {
    private String key="";
    private String mName, mImgLink;
    private ArrayList<Step> listSteps;

    public Accident() {
    }

    public Accident(String mName, String mImgLink, ArrayList<Step> steps) {
        this.mName = mName;
        this.mImgLink = mImgLink;
        this.listSteps = steps;
    }
    public String getKey(){
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }


    public String getmImgLink() {
        return mImgLink;
    }

    public void setmImgLink(String mImgLink) {
        this.mImgLink = mImgLink;
    }


    public ArrayList<Step> getSteps() {
        return listSteps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.listSteps = steps;
    }

}
