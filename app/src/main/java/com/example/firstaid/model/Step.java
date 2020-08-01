package com.example.firstaid.model;

public class Step {
    private String mImageLink, mStep;
    public String getmImageLink() {
        return mImageLink;
    }

    public void setmImageLink(String mImageLink) {
        this.mImageLink = mImageLink;
    }

    public String getmStep() {
        return mStep;
    }

    public void setmStep(String mStep) {
        this.mStep = mStep;
    }

    public Step() {
    }

    public Step( String mStep, String mImageLink) {
        this.mImageLink = mImageLink;
        this.mStep = mStep;
    }
}
