package com.example.androidthree.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.example.androidthree.App;
import com.example.androidthree.R;
import com.example.androidthree.ui.main.MainActivity;
import com.example.androidthree.ui.onboard.OnBoardActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        activitySelectorWithTimer();


    }

    private void activitySelectorWithTimer() {

        int DELAY = 1000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                selectActivity();

            }
        }, DELAY);

    }


    private void selectActivity() {
        if (App.getPreference().getFirstLaunch()) {
            App.getPreference().setFirstLaunch();
            OnBoardActivity.start(this);
        } else {
            OnBoardActivity.start(this);
//            MainActivity.start(this);
        }
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

    }
}
