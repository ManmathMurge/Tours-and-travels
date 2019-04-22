package com.example.sachin.giristourstravels;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static android.content.Intent.ACTION_CALL;
import static android.os.Build.VERSION_CODES.P;

public class contact_us extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;

    TextView number1,number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setTitle("Giri's Tours & Travels");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        number1=findViewById(R.id.number_1);
        number2=findViewById(R.id.number_2);

        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String no = "091754 44433";
                Intent callintent = new Intent(ACTION_CALL);
                callintent.setData(Uri.parse("tel:" +no));
                startActivity(callintent);
            }
        });
        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = "090493 61265";
                Intent callintent = new Intent(ACTION_CALL);
                callintent.setData(Uri.parse("tel:" +no));
                startActivity(callintent);
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        finish();
        return true;
    }
}
