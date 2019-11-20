package com.example.androidthree.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.androidthree.R;
import com.example.androidthree.data.entity.fiveDayWeather.MyList;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;

public class ForecastViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.forecast_desc)
    TextView forecastDesc;
    @BindView(R.id.f_temp_min)
    TextView fTempMin;
    @BindView(R.id.f_temp_max)
    TextView fTempMax;
    @BindView(R.id.ic_forecast)
    ImageView imageViewForecast;


    public void bind(MyList myList) {
//        fTempMin.setText(String.valueOf(myList.main.getTemp_min()));
//        fTempMax.setText(String.valueOf(myList.main.getTemp_max()));
//        forecastDesc.setText(String.valueOf(myList.weather.get(0).description));

        Picasso.get().load("https://www.openweathermap.org/img/w/" + myList.weather.get(0).icon
                + ".png").into(imageViewForecast);

    }

    public ForecastViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}