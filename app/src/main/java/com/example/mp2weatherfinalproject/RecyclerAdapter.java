package com.example.mp2weatherfinalproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<ConsolidatedWeather_> arrayListPokemon;
    private Context context;
    String title;
    String url="https://www.metaweather.com/static/img/weather/png/";
    String u2=".png";

    public RecyclerAdapter(ArrayList<ConsolidatedWeather_> arrayListPokemon, Context context, String title) {
        this.arrayListPokemon = arrayListPokemon;
        this.context = context;
        this.title=title;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem,parent,false);

        return new ViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(url+arrayListPokemon.get(position).getWeatherStateAbbr()+u2).into(holder.i_main);
        Glide.with(context).load(url+arrayListPokemon.get(1).getWeatherStateAbbr()+u2).into(holder.i_day1);
        Glide.with(context).load(url+arrayListPokemon.get(2).getWeatherStateAbbr()+u2).into(holder.i_day2);
        Glide.with(context).load(url+arrayListPokemon.get(3).getWeatherStateAbbr()+u2).into(holder.i_day3);
        Glide.with(context).load(url+arrayListPokemon.get(4).getWeatherStateAbbr()+u2).into(holder.i_day4);
        Glide.with(context).load(url+arrayListPokemon.get(5).getWeatherStateAbbr()+u2).into(holder.i_day5);
        holder.t_cityName.setText(title);
        holder.t_curTemp.setText(""+(double)Math.round(arrayListPokemon.get(position).getTheTemp() * 100d) / 100d+"°");
        holder.t_minTemp.setText(""+(double)Math.round(arrayListPokemon.get(position).getMinTemp() * 100d) / 100d+"°");
        holder.t_maxTemp.setText(""+(double)Math.round(arrayListPokemon.get(position).getMaxTemp() * 100d) / 100d+"°");
        holder.t_humid.setText("Humidity:"+(double)Math.round(arrayListPokemon.get(position).getHumidity() * 100d) / 100d+"%");
        holder.t_predict.setText("Predictability:"+(double)Math.round(arrayListPokemon.get(position).getPredictability() * 100d) / 100d+"%");
        holder.t_day1.setText(""+(getDay(arrayListPokemon.get(1).getApplicableDate())));
        holder.t_day2.setText(""+(getDay(arrayListPokemon.get(2).getApplicableDate())));
        holder.t_day3.setText(""+(getDay(arrayListPokemon.get(3).getApplicableDate())));
        holder.t_day4.setText(""+(getDay(arrayListPokemon.get(4).getApplicableDate())));
        holder.t_day5.setText(""+(getDay(arrayListPokemon.get(5).getApplicableDate())));

        holder.t_State.setText(arrayListPokemon.get(position).getWeatherStateName());
        holder.t_state1.setText(arrayListPokemon.get(1).getWeatherStateName());
        holder.t_state2.setText(arrayListPokemon.get(2).getWeatherStateName());
        holder.t_state3.setText(arrayListPokemon.get(3).getWeatherStateName());
        holder.t_state4.setText(arrayListPokemon.get(4).getWeatherStateName());
        holder.t_state5.setText(arrayListPokemon.get(5).getWeatherStateName());

    }

}
