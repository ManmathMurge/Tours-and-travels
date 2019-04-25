package com.example.sachin.giristourstravels;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.sachin.giristourstravels.comman.Commans;
import com.example.sachin.giristourstravels.comman.SharedPreferencesUtility;

public class MainActivity extends AppCompatActivity {
private static int SPLASH_TIME_OUT=3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences(Login_Activity.MyPREFERENCES, Context.MODE_PRIVATE);

                if(SharedPreferencesUtility.getPrefBoolean(MainActivity.this, Commans.LOGIN_STATUS)) {
                    Intent intent = new Intent(getBaseContext(), Home_Activity.class);
                    finish();
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getBaseContext(), Login_Activity.class);
                    finish();
                    startActivity(intent);
                }


            }
        },SPLASH_TIME_OUT);
    }

}
