package com.example.sachin.giristourstravels;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    public static Retrofit retrofit=null;

//    private static String URL="http://192.168.0.130/TravleGiri/";
//    private static String URL="http://192.168.31.76/TravleGiri/";
//    private static String URL="http://192.168.43.102/TravleGiri/";
    private static String URL="https://pesmcoe.000webhostapp.com/";

    public static Retrofit getRetrofitApi(){
        if (retrofit==null);{

            retrofit =new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }


}
