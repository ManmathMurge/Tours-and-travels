package com.example.sachin.giristourstravels;

import com.example.sachin.giristourstravels.ModuleClass.Destination;
import com.example.sachin.giristourstravels.ModuleClass.Source;
import com.example.sachin.giristourstravels.ModuleClass.Vehicle_Details;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CustomerApi {
    @GET("travelgiri/registration.php")
    public Call<String> getAllCustomers(@Query("name") String name, @Query("email") String email, @Query("contact") String contact, @Query("password") String password);

    @GET("travelgiri/login.php")
    public Call<String> loginAllCustomers(@Query("email") String email, @Query("password") String password);

    @GET("travelgiri/enquiry.php")
    public Call<String> enquiryAllCustomers(@Query("name") String name, @Query("email") String email, @Query("contact") String contact, @Query("message") String message);

    @GET("travelgiri/feedback.php")
    public Call<String> feedbackAllCustomers(@Query("email") String email, @Query("message") String message);

    @GET("travelgiri/vehiclelist.php")
    public Call<List<Vehicle_Details>> viewVehicle();

    @GET("travelgiri/spinnersource.php")
    public Call<List<Source>>sources();

    @GET("travelgiri/spinnerdestination.php")
    public Call<List<Destination>> destination();

}
