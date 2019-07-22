package com.example.weatherapp.retrofit;

import com.example.weatherapp.pojo.WeatherResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("forecast")
    Call<WeatherResponse> loadWeather(@Query("zip") String zip,
                                      @Query("units") String units,
                                      @Query("APPID") String apiKey);
//    RETURN-TYPE            METHOD NAME        METHOD-PAREMETERS
}
