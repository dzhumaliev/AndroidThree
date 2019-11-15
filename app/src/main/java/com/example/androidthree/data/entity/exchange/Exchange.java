package com.example.androidthree.data.entity.exchange;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Exchange extends Rates {
    public MainExchange mainExchange;
    public Rates rates;
    private String name;
    private float rate;

    public MainExchange getMainExchange() {
        return mainExchange;
    }

    public void setMainExchange(MainExchange mainExchange) {
        this.mainExchange = mainExchange;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public Exchange(String name, float rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public float getRate() {
        return rate;
    }
}

