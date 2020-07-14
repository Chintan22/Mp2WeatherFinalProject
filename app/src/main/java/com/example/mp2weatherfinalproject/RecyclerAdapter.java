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


        }
    };
}
