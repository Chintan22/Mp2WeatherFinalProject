package com.example.mp2weatherfinalproject;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RecycleItem extends AppCompatActivity {
    String url="https://www.metaweather.com/static/img/weather/png/";
    ImageView i_main;
    TextView lbl_cur,t_State,t_curTemp,t_minTemp,t_maxTemp,t_predict,t_humid;
    ConsolidatedWeather_ consolidatedWeather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleitem);
        t_State=findViewById(R.id.t_State);
        i_main = findViewById(R.id.i_main);
        lbl_cur=findViewById(R.id.lbl_cur);
        t_curTemp=findViewById(R.id.t_curTemp);
        t_minTemp=findViewById(R.id.txt_minTemp);
        t_maxTemp=findViewById(R.id.txt_maxTemp);
        t_predict=findViewById(R.id.t_predict);
        t_humid=findViewById(R.id.t_humid);
        consolidatedWeather= getIntent().getParcelableExtra("Day");
        generateview();
    }

    private void generateview() {
        t_State.setText(consolidatedWeather.getWeatherStateName());
        Glide.with(this).load(url+consolidatedWeather.getWeatherStateAbbr()+".png").into(i_main);
        t_curTemp.setText(""+(double)Math.round(consolidatedWeather.getTheTemp() * 100d / 100d)+"°");
        t_minTemp.setText(""+(double)Math.round(consolidatedWeather.getMinTemp() * 100d / 100d)+"°");
        t_maxTemp.setText(""+(double)Math.round(consolidatedWeather.getMaxTemp() * 100d / 100d)+"°");
        lbl_cur.setText(""+getDay(consolidatedWeather.getApplicableDate()));
        t_humid.setText("Humidity: "+(double)Math.round(consolidatedWeather.getHumidity() * 100d) / 100d+"%");
        t_predict.setText("Predictability: "+(double)Math.round(consolidatedWeather.getPredictability() * 100d) / 100d+"%");
    }

    private String getDay(String d) {
        String i=d;
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        String dayFromDate = null;
        try {
            date = dateformat.parse(i);
            DateFormat dayFormate=new SimpleDateFormat("EEEE");
            dayFromDate=dayFormate.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dayFromDate;
    }
}
