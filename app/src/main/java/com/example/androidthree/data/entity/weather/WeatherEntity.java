package com.example.androidthree.data.entity.weather;

public class WeatherEntity {
    public String icon;

    public String description;

    public String main;

    public int id;

    public String getIcon ()
    {
        return icon;
    }

    public void setIcon (String icon)
    {
        this.icon = icon;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getMain ()
    {
        return main;
    }

    public void setMain (String main)
    {
        this.main = main;
    }

    public int getId ()
    {
        return id;
    }

    public void setId (int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return new StringBuilder("[").append(this.icon).append(',').append(this.id).append(',').append(this.description).append(',').append(this.main).append("]").toString();
    }
    public WeatherEntity(String description, String icon, String main, int id) {
        this.description = description;
        this.icon = icon;
        this.main = main;
        this.id = id;
    }
}
