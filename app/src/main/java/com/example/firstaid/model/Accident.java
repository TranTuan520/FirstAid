package com.example.firstaid.model;

public class Accident {
    private int mImage;
    private String mTitle;

    @Override
    public String toString() {
        return "Accident{" +
                "mImage=" + mImage +
                ", mTitle='" + mTitle + '\'' +
                '}';
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Accident() {
    }

    public Accident(int mImage, String mTitle) {
        this.mImage = mImage;
        this.mTitle = mTitle;
    }
}
