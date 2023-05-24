package com.example.weather.Models;

public class sys {

    private String country;
    private long sunrise;
    private long sunset;

    public sys(String country, long sunrise, long sunset) {
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }

    public String getCountry() {
        return country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }
}
