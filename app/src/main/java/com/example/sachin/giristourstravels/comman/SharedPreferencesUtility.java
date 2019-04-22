package com.example.sachin.giristourstravels.comman;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtility {

    public static String getPrefString(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return prefs.getString(key, null);
    }

    public static void savePrefString(Context context, String key, String value) {
        SharedPreferences prefs = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        prefs.edit().putString(key, value).apply();
    }

    public static int getPrefInt(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return prefs.getInt(key, 0);
    }

    public static void savePrefInt(Context context, String key, int value) {
        SharedPreferences prefs = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        prefs.edit().putInt(key, value).apply();
    }

    public static boolean getPrefBoolean(Context context, String key) {
        SharedPreferences prefs = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        return prefs.getBoolean(key, false);
    }

    public static void savePrefBoolean(Context context, String key, boolean value) {

        SharedPreferences prefs = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        prefs.edit().putBoolean(key, value).apply();

    }

}