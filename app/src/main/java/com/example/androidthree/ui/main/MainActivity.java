package com.example.androidthree.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.example.androidthree.R;

public class MainActivity extends AppCompatActivity  {  ///implements DialogCallBack
    private Fragment firstFragment, secondFragment;
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
        viewPagerAdapter.addFragment(firstFragment);
        viewPagerAdapter.addFragment(secondFragment);
        viewPager.setAdapter(viewPagerAdapter);
       viewPagerAdapter.notifyDataSetChanged();
    }

    public static void start(Context context){
        context.startActivity(new Intent(context,MainActivity.class));
    }


}
