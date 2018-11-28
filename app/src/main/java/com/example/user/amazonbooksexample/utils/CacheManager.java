package com.example.user.amazonbooksexample.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class CacheManager {

    Context context;
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public static final String TIME = "time";
    public static final long TIME_LIMIT = 20000;

    @SuppressLint("CommitPrefEdits")
    public CacheManager(Context context) {
        this.context = context;

        sharedPreferences = context.getSharedPreferences("mySharedPref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveTime(long time) {
        editor.putLong(TIME, time);
        editor.commit();
    }

    private long getLasTime() {
        return sharedPreferences.getLong(TIME, 0);

    }

    public Boolean isCacheDirty() {
        long currentTime = System.currentTimeMillis();
        long timeDiff = currentTime - getLasTime();
        return timeDiff > TIME_LIMIT;
    }
}
