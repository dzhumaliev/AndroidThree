package com.example.androidthree.ui.splashscreen;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidthree.data.entity.fiveDayWeather.ForecastWeather;

public class AdapterForForecast extends RecyclerView.Adapter<AdapterForForecast.MyViewHolder> {
    Context context;
    ForecastWeather forecastWeather;
    public AdapterForForecast(Context context, ForecastWeather forecastWeather) {
        this.context = context;
        this.forecastWeather = forecastWeather;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
