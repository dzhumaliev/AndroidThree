package com.example.androidthree.ui.main;


import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.androidthree.R;
import com.example.androidthree.data.entity.weather.CurrentWeatherEntity;
import com.example.androidthree.data.network.RetrofitBuilder;
import com.example.androidthree.ui.Common;
import com.example.androidthree.ui.base.BaseFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.androidthree.BuildConfig.WEATHER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BaseFragment implements LocationListener {


    @BindView(R.id.textDesc)
    TextView textDesc;
    @BindView(R.id.pressure)
    TextView presh;
    @BindView(R.id.textCelsius)
    TextView textCelsius;
    @BindView(R.id.humidity)
    TextView humidity;
    @BindView(R.id.sunrise)
    TextView sunrise;
    @BindView(R.id.sunset)
    TextView sunset;
    @BindView(R.id.wind)
    TextView wind;
    @BindView(R.id.temp_min)
    TextView temp_min;
    @BindView(R.id.temp_max)
    TextView temp_max;
    @BindView(R.id.tvDay)
    TextView tvDay;
    @BindView(R.id.tvMonth)
    TextView tvMonth;
    @BindView(R.id.tvYear)
    TextView tvYear;
    @BindView(R.id.imageView)
    ImageView imageView1;

    TextView forecastDay, fTempMin, fTempMax, fDesc;


    private BottomSheetBehavior bottomSheetBehavior;


    @Override
    protected int getViewLayout() {
        return R.layout.fragment_first;


    }

    public FirstFragment() {
        RetrofitBuilder.getInstance().getCurrentWeather("Bishkek", WEATHER_KEY, "metric")
                .enqueue(new Callback<CurrentWeatherEntity>() {
                    @Override
                    public void onResponse(Call<CurrentWeatherEntity> call, Response<CurrentWeatherEntity> response) {
                        CurrentWeatherEntity data = response.body();
                        data.getWeather();
                        try {
                            setters(data);
                            calendarFormat();

                        } finally {

                        }
                    }

                    @Override
                    public void onFailure(Call<CurrentWeatherEntity> call, Throwable t) {

                    }

                });


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setupFragment();
    }

    private void setupFragment() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new WeatherForecastFragment())
                .commit();
    }

    private void initViews(View v) {
        ConstraintLayout bottomSheetLayout = v.findViewById(R.id.bottom_sheet_forecast);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);

//        forecastDay = v.findViewById(R.id.forecast_day);
        fTempMin = v.findViewById(R.id.f_temp_min);
        fTempMax = v.findViewById(R.id.f_temp_max);
        fDesc = v.findViewById(R.id.forecast_desc);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    private void calendarFormat() {

        Calendar calendar1 = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
        String formatted_day = sdf1.format(calendar1.getTime());
        tvDay.setText(formatted_day);

        Calendar calendar2 = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf2 = new SimpleDateFormat("MMMM");
        String formatted_month = sdf2.format(calendar2.getTime());
        tvMonth.setText(formatted_month);

        Calendar calendar3 = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf3 = new SimpleDateFormat("YYYY");
        String formatted_year = sdf3.format(calendar3.getTime());
        tvYear.setText(formatted_year);

    }

    @SuppressLint("StringFormatMatches")
    private void setters(final CurrentWeatherEntity data) {
//        Picasso.get().load("https://www.openweathermap.org/img/w/" + data.getWeather()
//                .get(0).getIcon() + ".png").into(imageView1);
//
//
//        textDesc.setText(new StringBuilder(String.valueOf(data.getWeather().get(0).getDescription())));
//        textCelsius.setText(data.getMain().getTemp() + "ºC");
//        presh.setText(data.getMain().getPressure() + " hpa");
//        humidity.setText(data.getMain().getHumidity() + " %");
//        sunrise.setText(Common.convertUnixToHour(data.getSys().getSunrise()));
//        sunset.setText(Common.convertUnixToHour(data.getSys().getSunset()));
//        wind.setText(new StringBuilder(String.valueOf(data.getWind().getSpeed())));
//        temp_min.setText((String.valueOf(data.getMain().getTemp_min())));
//        temp_max.setText((String.valueOf(data.getMain().getTemp_max())));


    }


}

