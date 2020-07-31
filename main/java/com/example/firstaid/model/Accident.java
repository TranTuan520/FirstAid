package com.example.firstaid.model;

import java.util.ArrayList;

public class Accident {
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
