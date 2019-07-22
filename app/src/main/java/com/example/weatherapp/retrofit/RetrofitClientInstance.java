package com.example.weatherapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    //    declare and init our base url

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";


    //    Declare Retrofit object
    private static Retrofit retrofit;

    //    create a proivTE constructor
    private RetrofitClientInstance(){};


    //    create a public static method to get instance of the Retrofit object
    public static Retrofit getRetrofit() {


//        this statement creates a new instance of Retrofit if the current instance is null
        if (retrofit== null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;
    }
}
