package com.example.weather.Models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class hari {
    public String getSunriseTimestamp(long sunriseTimestamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a", Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        Date sunrise = new Date(sunriseTimestamp * 1000L);
        return formatter.format(sunrise);
    }

    public String getSunsetTimestamp(long sunsetTimestamp) {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a", Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        Date sunrise = new Date(sunsetTimestamp * 1000L);
        return formatter.format(sunrise);
    }

}
