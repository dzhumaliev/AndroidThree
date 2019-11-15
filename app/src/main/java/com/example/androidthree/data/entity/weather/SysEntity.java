package com.example.androidthree.data.entity.weather;

public class SysEntity {
    private String country;

    private int sunrise;

    private int sunset;

    private int id;

    private int type;

    private double message;

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public int getSunrise ()
    {
        return sunrise;
    }

    public void setSunrise (int sunrise)
    {
        this.sunrise = sunrise;
    }

    public int getSunset ()
    {
        return sunset;
    }

    public void setSunset (int sunset)
    {
        this.sunset = sunset;
    }

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    public int getType ()
    {
        return type;
    }

    public void setType (int type)
    {
        this.type = type;
    }

    public double getMessage ()
    {
        return message;
    }

    public void setMessage (double message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return new StringBuilder("[").append(this.country).append(',').append(this.sunrise).append(',').append(this.sunset)
                .append(',').append(this.id).append(this.type).append(this.message).append("]").toString();

//        return "Sys [country = "+country+", sunrise = "+sunrise+", sunset = "+sunset+", id = "+id+", type = "+type+", message = "+message+"]";
    }
}

