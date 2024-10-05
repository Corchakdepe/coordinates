package com.example.fileanddots;

import static java.lang.Math.sqrt;

public class Punto {

    private int id;
    private double x;
    private double y;


    public Punto(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }





    public double getX() {
        return x;
    }

    public int getId() {
        return id;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }




}

