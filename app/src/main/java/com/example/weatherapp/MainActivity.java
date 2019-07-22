package com.example.weatherapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.pojo.WeatherResponse;
import com.example.weatherapp.retrofit.RetrofitClientInstance;
import com.example.weatherapp.retrofit.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    String zip, units, apiKey, currentCityName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();

        zip = "75243";
        units = "imperial";
        apiKey = "a5167266c7479f05a09c6887661be6c0";

        retrofitRequest(zip, units, apiKey);
            }

    public void retrofitRequest (String zip, String units, String apiKey) {
//        declare ShibeService and initialize it using RetrofitClient Instance
        WeatherService weatherService = RetrofitClientInstance
                .getRetrofit()
                .create(WeatherService.class);

//        2; Declare ShibeService Return ttype and Init it using the ShibeService from step 1
        Call<WeatherResponse> weatherCall = weatherService.loadWeather(zip, units, apiKey);

//        3; Use the shibeCall from step 2 and call the .enqueue method
        weatherCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, retrofit2.Response<WeatherResponse> response) {

                if (response.isSuccessful()){
                    String model = response.body().toString();
                    Log.d(TAG, "onResponse: Success");
                    Log.d(TAG, "onResponse: " + model);
                    currentCityName = response.body().getCity().getName();



                } else {
                    Log.d(TAG, "onResponse: Failure");
                }

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });
    }

    public class weatherData {
        public  String cityNameFromData = currentCityName;

    }




}
