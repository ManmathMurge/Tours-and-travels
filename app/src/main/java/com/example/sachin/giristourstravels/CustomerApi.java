package com.example.sachin.giristourstravels;

import com.example.sachin.giristourstravels.ModuleClass.Destination;
import com.example.sachin.giristourstravels.ModuleClass.Source;
import com.example.sachin.giristourstravels.ModuleClass.Vehicle_Details;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CustomerApi {
    @GET("registration.php")
    public Call<String> getAllCustomers(@Query("name") String name, @Query("email") String email, @Query("contact") String contact, @Query("password") String password);

    @GET("login.php")
    public Call<String> loginAllCustomers(@Query("email") String email, @Query("password") String password);

    @GET("enquiry.php")
    public Call<String> enquiryAllCustomers(@Query("name") String name, @Query("email") String email, @Query("contact") String contact, @Query("message") String message);

    @GET("feedback.php")
    public Call<String> feedbackAllCustomers(@Query("email") String email, @Query("message") String message);

    @GET("vehiclelist.php")
    public Call<List<Vehicle_Details>> viewVehicle();

    @GET("spinnersource.php")
    public Call<List<Source>>sources();

    @GET("spinnerdestination.php")
    public Call<List<Destination>> destination();

}
