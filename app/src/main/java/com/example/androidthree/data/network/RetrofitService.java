package com.example.androidthree.data.network;

import com.example.androidthree.data.entity.fiveDayWeather.ForecastWeather;
import com.example.androidthree.data.entity.weather.CurrentWeatherEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET(ApiEndPoint.CURRENT_WEATHER)
    Call<CurrentWeatherEntity>  getCurrentWeather(@Query("q") String city,
                                                 @Query("appid") String appId,
                                                 @Query("units") String metric);


    @GET(ApiEndPoint.FORECAST)
    Call<ForecastWeather> getFiveWeather(@Query("q") String city,
                                         @Query("appid") String appId,
                                         @Query("units") String metric);


//    @GET(ApiEndPoint.EXCHANGE)
//    Call<Exchange> getExchangeRate(@Query("q") String latest,
//                                   @Query("appid") String appId);
//
//    @GET("latest")
//    Call<Exchange> loadCurrencyExchange();

}

//http://api.openweathermap.org/data/2.5/
//forecast/?id=524901&appid=b1b15e88fa797225412429c1c50c122a1