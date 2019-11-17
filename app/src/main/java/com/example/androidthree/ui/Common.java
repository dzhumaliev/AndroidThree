package com.example.androidthree.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    public static String convertUnixToHour(long dt) {
        Date date = new Date(dt * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String formatted= sdf.format(date);
        return formatted;
    }

    public static String convertUnixToHour(String sunrise) {
        return sunrise;
    }
}
