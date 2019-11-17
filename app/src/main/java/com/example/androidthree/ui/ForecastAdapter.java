package com.example.androidthree.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidthree.R;
import com.example.androidthree.data.entity.fiveDayWeather.MyList;

import java.util.ArrayList;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {
    private List<MyList> forecastWeather = new ArrayList<>();

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ForecastViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast_weather, parent, false));
    }

    public void update(List<MyList> forecastWeather) {
        this.forecastWeather = forecastWeather;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        holder.bind(forecastWeather.get(position));
    }

    @Override
    public int getItemCount() {
        return forecastWeather.size();
    }
}
