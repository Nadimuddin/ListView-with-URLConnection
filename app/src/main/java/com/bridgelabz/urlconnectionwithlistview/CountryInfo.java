package com.bridgelabz.urlconnectionwithlistview;

import android.graphics.Bitmap;

/**
 * Created by Nadimuddin on 8/9/16.
 * purpose: android tutorial(for learning android)
 */
public class CountryInfo
{
    int mRank;
    Bitmap mBitmapImage;
    String mCountry, mPopulation;

    //Constructor to store country info
    CountryInfo(int rank, String country, String population, Bitmap bitmapImage)
    {
        mRank = rank;
        mCountry = country;
        mPopulation = population;
        mBitmapImage = bitmapImage;
    }

    //method to return rank of country
    String getRank()
    {
        return Integer.toString(mRank);
    }

    //method to return name of country
    String getCountry()
    {
        return mCountry;
    }

    //method to return population of country
    String getPopulation()
    {
        return mPopulation;
    }

    //method to return resource id of image of country's flag
    Bitmap getImageBitmap()
    {
        return mBitmapImage;
    }

}

