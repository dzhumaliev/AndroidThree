package com.example.androidthree.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidthree.R;
import com.example.androidthree.data.entity.fiveDayWeather.MyList;
import com.example.androidthree.ui.ForecastViewHolder;
import java.util.ArrayList;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {
    private List<MyList> forecastWeather = new ArrayList<>();
    private Listener listener;

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View itemView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast_weather, parent, false);
        return new ForecastViewHolder(itemView, listener);
    }

    public void update(List<MyList> forecastWeather) {
        this.forecastWeather = forecastWeather;
        this.listener = listener;
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
