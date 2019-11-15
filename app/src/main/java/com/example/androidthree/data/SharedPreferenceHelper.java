package com.example.androidthree.data;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferenceHelper {
    private Context context;
    private SharedPreferences preference;
    private final String PREFERENCE_NAME = "android";
    private final String IS_FIRST_LAUNCH = "isFirstLaunch";

    public SharedPreferenceHelper(Context context) {
        this.context = context;
        createSharedPreference();
    }

    public void createSharedPreference() {
        preference = context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE);
    }
    public void setFirstLaunch(){
        preference.edit().putBoolean(IS_FIRST_LAUNCH, false).apply();
    }
    public boolean getFirstLaunch(){
        return preference.getBoolean(IS_FIRST_LAUNCH, true);
    }
}
