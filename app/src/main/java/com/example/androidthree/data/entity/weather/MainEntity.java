package com.example.androidthree.data.entity.weather;

public class MainEntity extends CurrentWeatherEntity {
    private double temp;

    private double temp_min;

    private int humidity;

    private int pressure;

    private double temp_max;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    @Override
    public String toString()
    {
        return new StringBuilder("[").append(this.temp).append(',').append(this.temp_min).append(',').append(this.temp_max)
                .append(',').append(this.humidity).append(this.pressure).append("]").toString();

//        return "Main [temp = "+temp+", temp_min = "+temp_min+", humidity = "+humidity+", pressure = "+pressure+", temp_max = "+temp_max+"]";
    }
}
