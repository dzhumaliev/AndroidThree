package com.example.androidthree.data.entity.exchange;


import java.util.List;

public class MainExchange {
    private boolean success;
    private float timestamp;
    private String base;
    private String date;
    private List<Rates> RatesObject;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public float getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(float timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List< Rates> getRatesObject() {
        return RatesObject;
    }

    public void setRatesObject(List<Rates> ratesObject) {
        RatesObject = ratesObject;
    }
}
