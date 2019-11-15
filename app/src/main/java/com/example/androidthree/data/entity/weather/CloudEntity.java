package com.example.androidthree.data.entity.weather;

public class CloudEntity {
    private int all;

    public int getAll ()
    {
        return all;
    }

    public void setAll (int all)
    {
        this.all = all;
    }

    @Override
    public String toString()
    {
        return new StringBuilder("[").append(this.all).append("]").toString();

//        return "Cloud [all = "+all+"]";
    }
}
