package com.example.mp2weatherfinalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FirstFragment extends Fragment {

    private RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ArrayList<ConsolidatedWeather_> wList;
    String a="montreal";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getArguments()!=null){
            a=getArguments().getString("Label");
        }
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ConsolidatedWeather> call;
        switch (a){
            case "montreal": call = service.getMontreal();
                getData(call);
                break;
            case "london":  call = service.getLondon();
                getData(call);
                break;
            case "hyderabad":  call = service.getHyderabad();
                getData(call);
                break;
            case "newYork":  call = service.getNewyork();
                getData(call);
                break;
            case "chicago":  call = service.getChicago();
                getData(call);
                break;
            case "delhi":  call = service.getDelhi();
                getData(call);
                break;
        }
    }

    private void getData(Call<ConsolidatedWeather> call) {
        call.enqueue(new Callback<ConsolidatedWeather>() {
            @Override
            public void onResponse(Call<ConsolidatedWeather> call, Response<ConsolidatedWeather> response) {
                System.out.println("Response From URL :" + response.body());
                try {
                    ConsolidatedWeather weather = response.body();

                    wList = new ArrayList<>(weather.getConsolidatedWeather());
                    generateView(wList,weather.getTitle());

                }catch (NullPointerException e)
                {
                    System.out.println("Nullpointer Exception :"+e.getMessage());
                }
            }

            @Override
            public void onFailure(Call<ConsolidatedWeather> call, Throwable t) {

                System.out.println("In Failure :" + t.getMessage());

            }
        });

    }
    public void generateView(ArrayList<ConsolidatedWeather_> weatherS, String title){
        recyclerAdapter = new RecyclerAdapter(weatherS, getActivity().getApplicationContext(),title);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView = getView().findViewById(R.id.main_recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
}