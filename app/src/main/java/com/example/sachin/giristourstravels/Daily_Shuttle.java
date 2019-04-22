package com.example.sachin.giristourstravels;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Daily_Shuttle extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    android.support.v7.widget.Toolbar toolbar;
    Spinner pickdaily,dropdaily,passanger,vtype;
    Button dailybooking;
    TextView dailydate;
    private DatePickerDialog.OnDateSetListener datesetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily__shuttle);

        pickdaily=findViewById(R.id.daily_pickup);
        dropdaily=findViewById(R.id.daily_droppoint);
        passanger=findViewById(R.id.noofpassanger);
        vtype=findViewById(R.id.vehicletype);
        dailybooking=findViewById(R.id.daily_booking);
        dailydate=findViewById(R.id.daily_date);

        //Calender Dialogbox
        dailydate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int year=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(Daily_Shuttle.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        datesetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        datesetListener= new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
               // Log.d(TAG,"onDataSet: dd/mm/yyyy: " +dayOfMonth+"/" +month+"/"+year);
                String date=dayOfMonth+"/"+month+"/"+year;
                dailydate.setText(date);
            }
        };

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);

        //Pick up Array Adapter
        ArrayAdapter<CharSequence> pickadapter=ArrayAdapter.createFromResource(this,R.array.city,android.R.layout.simple_spinner_item);
        pickadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pickdaily.setAdapter(pickadapter);
        pickdaily.setOnItemSelectedListener(this);

        //Drop Array Adapter
        ArrayAdapter<CharSequence> dropadapter=ArrayAdapter.createFromResource(this,R.array.city,android.R.layout.simple_spinner_item);
        dropadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdaily.setAdapter(dropadapter);
        dropdaily.setOnItemSelectedListener(this);

        //No of Passanger Array Adapter
        ArrayAdapter<CharSequence> noofpassanger=ArrayAdapter.createFromResource(this,R.array.passanger,android.R.layout.simple_spinner_item);
        noofpassanger.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        passanger.setAdapter(noofpassanger);
        passanger.setOnItemSelectedListener(this);

        //Vehiccle type Array Adapter
        ArrayAdapter<CharSequence> vehicletype=ArrayAdapter.createFromResource(this,R.array.vehiletype,android.R.layout.simple_spinner_item);
        vehicletype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vtype.setAdapter(vehicletype);
        vtype.setOnItemSelectedListener(this);

    }
    //Select BackButton on Toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        onBackPressed();
        finish();
        return true;
    }

    //Pickup Spinner Item Selected onclick Method
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String string=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),string,Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
