package com.company;

//this is our coordinates object
public class LocationClass {

    private int hor = 5;
    private int vert = 5;

    public LocationClass() {
    }


    public LocationClass(int hor, int vert) {
        this.hor = hor;
        this.vert = vert;
    }

    public int getHor() {
        return hor;
    }

    public void setHor(int hor) {
        this.hor = hor;
    }

    public int getVert() {
        return vert;
    }

    public void setVert(int vert) {
        this.vert = vert;
    }
}
