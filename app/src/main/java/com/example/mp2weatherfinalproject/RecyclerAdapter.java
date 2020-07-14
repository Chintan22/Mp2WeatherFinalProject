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
    String u1="https://www.metaweather.com/static/img/weather/png/";


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
        Glide.with(context).load(u1+arrayListPokemon.get(position).getWeatherStateAbbr()+".png").into(holder.i_main);
        Glide.with(context).load(u1+arrayListPokemon.get(1).getWeatherStateAbbr()+".png").into(holder.i_day1);
        Glide.with(context).load(u1+arrayListPokemon.get(2).getWeatherStateAbbr()+".png").into(holder.i_day2);
        Glide.with(context).load(u1+arrayListPokemon.get(3).getWeatherStateAbbr()+".png").into(holder.i_day3);
        Glide.with(context).load(u1+arrayListPokemon.get(4).getWeatherStateAbbr()+".png").into(holder.i_day4);
        Glide.with(context).load(u1+arrayListPokemon.get(5).getWeatherStateAbbr()+".png").into(holder.i_day5);
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
    public static String getDay(String d){
        String i=d;
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String dayFromDate = null;
        try {
            date = dateformat.parse(i);
            DateFormat dayFormate=new SimpleDateFormat("EEE");
            dayFromDate=dayFormate.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dayFromDate;
    }
    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView i_main,i_day1,i_day2,i_day3,i_day4,i_day5;
        TextView t_cityName,t_State,t_curTemp,t_minTemp,t_maxTemp,t_day1,t_day2,t_day3,t_day4,t_day5,
                t_state1,t_state2,t_state3,t_state4,t_state5,t_predict,t_humid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            i_main = itemView.findViewById(R.id.i_main);
            t_cityName=itemView.findViewById(R.id.city_name);
            t_curTemp = itemView.findViewById(R.id.t_curTemp);
            t_minTemp = itemView.findViewById(R.id.txt_minTemp);
            t_maxTemp = itemView.findViewById(R.id.txt_maxTemp);
            i_day1 = itemView.findViewById(R.id.i_day1);
            i_day2 = itemView.findViewById(R.id.i_day2);
            i_day3 = itemView.findViewById(R.id.i_day3);
            i_day4 = itemView.findViewById(R.id.i_day4);
            i_day5 = itemView.findViewById(R.id.i_day5);
            t_day1 = itemView.findViewById(R.id.t_day1);
            t_day2 = itemView.findViewById(R.id.t_day2);
            t_day3 = itemView.findViewById(R.id.t_day3);
            t_day4 = itemView.findViewById(R.id.t_day4);
            t_day5 = itemView.findViewById(R.id.t_day5);
            t_State = itemView.findViewById(R.id.t_State);
            t_state1 = itemView.findViewById(R.id.t_state1);
            t_state2 = itemView.findViewById(R.id.t_state2);
            t_state3 = itemView.findViewById(R.id.t_state3);
            t_state4 = itemView.findViewById(R.id.t_state4);
            t_state5 = itemView.findViewById(R.id.t_state5);
            t_humid = itemView.findViewById(R.id.t_humid);
            t_predict = itemView.findViewById(R.id.t_predict);

            i_day1.setOnClickListener(click);
            i_day2.setOnClickListener(click);
            i_day3.setOnClickListener(click);
            i_day4.setOnClickListener(click);
            i_day5.setOnClickListener(click);
            itemView.setTag(this);
        }
    }
    View.OnClickListener click =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(v.getContext(),RecycleItem.class);
            switch (v.getId()){
                case R.id.i_day1:
                    intent.putExtra("Day",arrayListPokemon.get(1));
                    v.getContext().startActivity(intent);
                    break;
                case R.id.i_day2:
                    intent.putExtra("Day",arrayListPokemon.get(2));
                    v.getContext().startActivity(intent);
                    break;
                case R.id.i_day3:
                    intent.putExtra("Day",arrayListPokemon.get(3));
                    v.getContext().startActivity(intent);
                    break;
                case R.id.i_day4:
                    intent.putExtra("Day",arrayListPokemon.get(4));
                    v.getContext().startActivity(intent);
                    break;
                case R.id.i_day5:
                    intent.putExtra("Day",arrayListPokemon.get(5));
                    v.getContext().startActivity(intent);
                    break;
            }
        }
    };

}
