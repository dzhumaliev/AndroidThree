package com.example.androidthree.data.entity.weather;

public class WindEntity {
    private double deg;

    private double speed;

    public double getDeg ()
    {
        return deg;
    }

    public void setDeg (double deg)
    {
        this.deg = deg;
    }

    public double getSpeed ()
    {
        return speed;
    }

    public void setSpeed (double speed)
    {
        this.speed = speed;
    }

    @Override
    public String toString()
    {
        return new StringBuilder("[").append(this.deg).append(',').append(this.speed).append("]").toString();

//        return "Wind [deg = "+deg+", speed = "+speed+"]";
    }
}
