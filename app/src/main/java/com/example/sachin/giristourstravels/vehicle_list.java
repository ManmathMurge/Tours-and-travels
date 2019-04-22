package com.example.sachin.giristourstravels;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.sachin.giristourstravels.AdapterFile.ViewVehicleAdapter;
import com.example.sachin.giristourstravels.ModuleClass.Vehicle_Details;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class vehicle_list extends AppCompatActivity {

    RecyclerView recyclerView;
    RetrofitApi retrofitApi;
    ViewVehicleAdapter recyclerViewAdapter;

    private List<Vehicle_Details> vehicle_detailsArrayList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_list);

        //Toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);


        //Recycler View

        recyclerView = findViewById(R.id.vehicleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerViewAdapter = new ViewVehicleAdapter(getApplicationContext(), vehicle_detailsArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
        retrofitApi = new RetrofitApi();

        view();

    }
    private void view() {

        final Retrofit retrofit = RetrofitApi.getRetrofitApi();
        final CustomerApi customerApi = retrofit.create(CustomerApi.class);
        Call<List<Vehicle_Details>> employeeCall = customerApi.viewVehicle();
        employeeCall.enqueue(new Callback<List<Vehicle_Details>>() {
            @Override
            public void onResponse(Call<List<Vehicle_Details>> call, Response<List<Vehicle_Details>> response) {
                List<Vehicle_Details> call1 = response.body();
                String[] emails = new String[0];
                vehicle_detailsArrayList.addAll(call1);
                recyclerViewAdapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<List<Vehicle_Details>> call, Throwable t) {
                //Toast.makeText(getApplicationContext(), "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();

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
