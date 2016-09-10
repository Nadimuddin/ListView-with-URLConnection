package com.bridgelabz.urlconnectionwithlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nadimuddin on 8/9/16.
 * purpose: android tutorial(for learning android)
 */
public class MyAdapter extends BaseAdapter
{

    ArrayList<CountryInfo> mArrayList;
    LayoutInflater inflater;
    MyAdapter(Context context, ArrayList<CountryInfo> arrayList)
    {
        mArrayList = arrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup)
    {
        //TextView to display rank, name & population of country
        TextView rank, country, population;

        //ImageView to display flag of country
        ImageView imageView;

        if(view == null)
            view = inflater.inflate(R.layout.list_layout, viewGroup, false);

        /*
        * get component object from xml
         */
        rank = (TextView)view.findViewById(R.id.rank);
        country = (TextView)view.findViewById(R.id.country);
        population = (TextView)view.findViewById(R.id.population);
        imageView = (ImageView)view.findViewById(R.id.imageView);

        //set current rank on TextView
        rank.setText("Rank#"+mArrayList.get(position).getRank());

        //set current name on TextView
        country.setText(mArrayList.get(position).getCountry());

        //set current population on TextView
        population.setText("Population: "+mArrayList.get(position).getPopulation());

        //set bitmap image on ImageView
        imageView.setImageBitmap(mArrayList.get(position).getImageBitmap());

        return view;
    }
}
