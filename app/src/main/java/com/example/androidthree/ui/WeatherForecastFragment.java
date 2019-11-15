package com.example.androidthree.ui;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidthree.R;
import com.example.androidthree.data.entity.fiveDayWeather.ForecastWeather;
import com.example.androidthree.data.network.RetrofitBuilder;
import com.example.androidthree.ui.splashscreen.AdapterForForecast;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.androidthree.BuildConfig.WEATHER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherForecastFragment extends Fragment {


    @BindView(R.id.forecast_day)
    TextView forecastDay;
    @BindView(R.id.forecast_desc)
    TextView forecastDesc;
    @BindView(R.id.f_temp_min)
    TextView rain;
    @BindView(R.id.f_temp_max)
    TextView wind;


    @BindView(R.id.ic_forecast)
    ImageView imageViewForecast;


    @BindView(R.id.recyclerView)
    RecyclerView recycler_forecast;

    Context context;
    ForecastWeather forecastWeather;


    public WeatherForecastFragment() {
        getForecastWeather();
        Log.e("----------", "createview");

//        recycler_forecast.setHasFixedSize(true);
//        recycler_forecast.setLayoutManager(new LinearLayoutManager(getContext(),
//                LinearLayoutManager.VERTICAL, false));
//

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_weather_forecast, container, false);

    }

    private void getForecastWeather() {
        RetrofitBuilder.getInstance().getFiveWeather("Bishkek", WEATHER_KEY, "metric")
                .enqueue(new Callback<ForecastWeather>() {
                    @Override
                    public void onResponse(Call<ForecastWeather> call, Response<ForecastWeather> response) {
                        if (response.body() != null) {
//                            displayForecastWeather(response.body());
                            Log.e("TAG", "onResponse: " + response);


                        }

                    }

                    @Override
                    public void onFailure(Call<ForecastWeather> call, Throwable t) {
                        Log.e("d", "onFailure: ");
                    }
                });
    }

    private void displayForecastWeather(ForecastWeather weatherEntity) {

//        AdapterForForecast adapter = new AdapterForForecast(getContext(), weatherEntity);
//        recycler_forecast.setAdapter(adapter);

    }


}
