package com.example.firstaid.model;

public class Accident {
    private String mImage;
    private String mTitle;

    @Override
    public String toString() {
        return "Accident{" +
                "mImage=" + mImage +
                ", mTitle='" + mTitle + '\'' +
                '}';
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Accident() {

    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmImage() {
        return mImage;
    }

    public Accident(String mImage, String mTitle) {
        this.mImage = mImage;
        this.mTitle = mTitle;
    }
}
