package com.example.androidthree.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.example.androidthree.R;
import com.example.androidthree.data.entity.weather.CurrentWeatherEntity;
import com.example.androidthree.data.network.RetrofitBuilder;
import com.example.androidthree.ui.FirstFragment;
import com.example.androidthree.ui.SecondFragment;
import com.example.androidthree.ui.ViewPagerAdapterFragment;
import com.example.androidthree.ui.WeatherForecastFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.androidthree.BuildConfig.WEATHER_KEY;

public class MainActivity extends AppCompatActivity  {  ///implements DialogCallBack
    private Fragment firstFragment, secondFragment, forcastFragment;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager_Fragment);
        setViewPager();

    }

    public void setViewPager() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ViewPagerAdapterFragment viewPagerAdapter = new ViewPagerAdapterFragment(getSupportFragmentManager(), 0);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        forcastFragment = new WeatherForecastFragment();
        viewPagerAdapter.addFragment(firstFragment);
        viewPagerAdapter.addFragment(secondFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }

    public static void start(Context context){
        context.startActivity(new Intent(context,MainActivity.class));
    }


}
