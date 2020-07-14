package com.example.mp2weatherfinalproject;


import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("3534")
    Call<ConsolidatedWeather> getMontreal();

    @GET("44418")
    Call<ConsolidatedWeather> getLondon();

    @GET("2379574")
    Call<ConsolidatedWeather> getChicago();

    @GET("2295414")
    Call<ConsolidatedWeather> getHyderabad();

    @GET("2459115")
    Call<ConsolidatedWeather> getNewyork();

    @GET("28743736")
    Call<ConsolidatedWeather> getDelhi();


}
