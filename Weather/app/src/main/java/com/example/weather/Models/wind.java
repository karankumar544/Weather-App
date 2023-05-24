package com.example.weather.Models;

public class wind {

    private double speed;
    private int deg;
    private double gust;

    public wind(double speed, int deg, double gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }

    public double getGust() {
        return gust;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public void setGust(double gust) {
        this.gust = gust;
    }
}
