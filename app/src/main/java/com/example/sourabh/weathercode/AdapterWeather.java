package com.example.sourabh.weathercode;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by sourabh on 23/05/2017.
 */

public class AdapterWeather extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataWeather> data = Collections.emptyList();
    DataWeather current;
    int currentPos = 0;


    public AdapterWeather(Context context, List<DataWeather> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        MyHolder myHolder = (MyHolder) holder;
        DataWeather current = data.get(position);
        myHolder.txtname.setText(current.name);
        myHolder.txtweather.setText("Size: " + current.weather);
        myHolder.txtcoord.setText("Category: " + current.coord);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder {

        TextView txtname;
        TextView txtweather;
        TextView txtcoord;


        public MyHolder(View itemView) {
            super(itemView);
            txtname = (TextView) itemView.findViewById(R.id.txtname);
            txtcoord = (TextView) itemView.findViewById(R.id.txtcoord);
            txtweather = (TextView) itemView.findViewById(R.id.txtweather);
        }
    }
}