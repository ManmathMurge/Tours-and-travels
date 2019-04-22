package com.example.sachin.giristourstravels;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SpecialServices extends AppCompatActivity {

    Button corporateService, ptoaService, dService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_services);

        corporateService=findViewById(R.id.corporateservice);
        ptoaService=findViewById(R.id.punetoaurgaservice);
        dService=findViewById(R.id.dailyservice);

        //toolbar Back button
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        corporateService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Corporate Service",Toast.LENGTH_SHORT).show();

            }
        });
        ptoaService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(),"Pune To A urangabad Service",Toast.LENGTH_SHORT).show();

            }
        });
        dService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Daily Service",Toast.LENGTH_SHORT).show();


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
