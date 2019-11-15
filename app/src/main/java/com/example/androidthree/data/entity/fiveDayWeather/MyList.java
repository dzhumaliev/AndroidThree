package com.example.androidthree.data.entity.fiveDayWeather;

import android.os.ParcelUuid;

import com.example.androidthree.data.entity.weather.CloudEntity;
import com.example.androidthree.data.entity.weather.MainEntity;
import com.example.androidthree.data.entity.weather.SysEntity;
import com.example.androidthree.data.entity.weather.WeatherEntity;
import com.example.androidthree.data.entity.weather.WindEntity;

import java.util.List;

public class MyList {
    public int dt;
    public MainEntity main;
    public String dt_txt;
    public List<WeatherEntity> weather;
    public CloudEntity cloud;
    public WindEntity wind;
    public Rain rain;
    public SysEntity sys;
}
