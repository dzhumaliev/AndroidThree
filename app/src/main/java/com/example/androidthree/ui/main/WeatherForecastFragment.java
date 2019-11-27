package com.example.androidthree.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androidthree.R;
import com.example.androidthree.data.entity.fiveDayWeather.ForecastWeather;
import com.example.androidthree.data.network.RetrofitBuilder;
import com.example.androidthree.ui.base.BaseFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.androidthree.BuildConfig.WEATHER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherForecastFragment extends BaseFragment implements Listener {
    private BottomSheetBehavior bottomSheetBehavior;
    ForecastAdapter adapter;



//    @BindView(R.id.forecast_day)
//    TextView forecastDay;



//    @BindView(R.id.forecast_desc)
//    TextView forecastDesc;
//    @BindView(R.id.f_temp_min)
//    TextView rain;
//    @BindView(R.id.f_temp_max)
//    TextView wind;

//
//    @BindView(R.id.ic_forecast)
//    ImageView imageViewForecast;
//

    @BindView(R.id.recyclerView)
    RecyclerView recycler_forecast;


    @Override
    protected int getViewLayout() {
        return R.layout.fragment_test;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        getForecastWeather();
        initAdapter();
    }

    private void initAdapter(){
        adapter = new ForecastAdapter();
        recycler_forecast.setAdapter(adapter);
    }

    private void initView(View view) {
//         View view1 = view.findViewById(R.id.bottom_sheet_forecast);
//        bottomSheetBehavior = BottomSheetBehavior.from(view1);
    }

    private void getForecastWeather() {
        RetrofitBuilder.getInstance().getFiveWeather("Bishkek", WEATHER_KEY, "metric")
                .enqueue(new Callback<ForecastWeather>() {
                    @Override
                    public void onResponse(Call<ForecastWeather> call, Response<ForecastWeather> response) {
                        if (response.body() != null) {
                            displayForecastWeather(response.body());
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
        adapter.update(weatherEntity.list);
    }

    @Override
    public void onItemClick() {

    }
}
