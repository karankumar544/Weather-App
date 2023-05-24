package com.example.weather.Models;

public class main {
    private double temp ;
    private double feels_like ;
    private double temp_min;
    private double temp_max;
    private int pressure;
    private int humidity;
    private main(double temp, double feels_like, double temp_min, double temp_max, int pressure, int humidity) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
    }
    public double getTemp() {
        return temp;
    }

   public void setTemp(double temp) {
        this.temp = temp;
    }

    private double getFeels_like() {
        return feels_like;
    }

    private void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    private double getTemp_min() {
        return temp_min;
    }

    private void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    private double getTemp_max() {
        return temp_max;
    }

    private void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

}
