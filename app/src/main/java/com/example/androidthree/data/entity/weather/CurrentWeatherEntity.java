package com.example.androidthree.data.entity.weather;

import android.widget.WrapperListAdapter;

import java.util.List;

public class CurrentWeatherEntity {

    private int dt;

    private CoordEntity coord;

    private int visibility;

    private List<WeatherEntity> weather;

    private String name;

    private int cod;

    private MainEntity main;

    private CloudEntity clouds;

    private int id;

    private SysEntity sys;

    private String base;

    private WindEntity wind;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public CoordEntity getCoord() {
        return coord;
    }

    public void setCoord(CoordEntity coord) {
        this.coord = coord;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public List<WeatherEntity> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherEntity> weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public MainEntity getMain() {
        return main;
    }

    public void setMain(MainEntity main) {
        this.main = main;
    }

    public CloudEntity getClouds() {
        return clouds;
    }

    public void setClouds(CloudEntity clouds) {
        this.clouds = clouds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SysEntity getSys() {
        return sys;
    }

    public void setSys(SysEntity sys) {
        this.sys = sys;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public WindEntity getWind() {
        return wind;
    }

    public void setWind(WindEntity wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return new StringBuilder("[").append(this.dt).append(',').append(this.coord).append(',').append(this.visibility)
                .append(',').append(this.weather).append(',').append(this.name).append(',').append(this.cod).append(',')
                .append(this.main).append(',').append(this.clouds).append(',').append(this.id).append(',').append(this.sys)
                .append(',').append(this.base).append(',').append(this.wind).append("]").toString();

//        return "Weather [dt = " + dt + ", coord = " + coord + ", visibility = " + visibility + ", weather = " + weather + ", name = " + name + ", cod = " + cod + ", main = " + main + ", clouds = " + clouds + ", id = " + id + ", sys = " + sys + ", base = " + base + ", wind = " + wind + "]";
    }

    public void getDouble(String temp) {

    }

    public String getString(String description) {
        return null;
    }
}

