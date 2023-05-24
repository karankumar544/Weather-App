package com.example.weather.Models;

import java.util.List;

public class MausamData {
     public List<weather> weather;
    public main main;
    public wind wind;
    public sys sys;
    public String name;

    public MausamData(List<com.example.weather.Models.weather> weather,
                      com.example.weather.Models.main main, com.example.weather.Models.wind wind,
                      com.example.weather.Models.sys sys, String name) {
        this.weather = weather;
        this.main = main;
        this.wind = wind;
        this.sys = sys;
        this.name = name;
    }

    public void setWeather(List<com.example.weather.Models.weather> weather) {
        this.weather = weather;
    }

    public void setMain(com.example.weather.Models.main main) {
        this.main = main;
    }

    public void setWind(com.example.weather.Models.wind wind) {
        this.wind = wind;
    }

    public void setSys(com.example.weather.Models.sys sys) {
        this.sys = sys;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.example.weather.Models.weather> getWeather() {
        return weather;
    }

    public com.example.weather.Models.main getMain() {
        return main;
    }

    public com.example.weather.Models.wind getWind() {
        return wind;
    }

    public com.example.weather.Models.sys getSys() {
        return sys;
    }

    public String getName() {
        return name;
    }
}
