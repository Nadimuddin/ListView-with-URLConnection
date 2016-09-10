package com.bridgelabz.urlconnectionwithlistview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Nadimuddin on 8/9/16.
 */
public class DownloadImage
{
    //method to download bitmap image
    Bitmap downloadImage(String urlImage)
    {
        HttpURLConnection urlConnection;
        Bitmap bitmap = null;
        try
        {
            //declaring object of URL with a url of image
            URL url = new URL(urlImage);

            //open connection to the URL
            urlConnection = (HttpURLConnection)url.openConnection();

            //get stream i.e. content from URL
            InputStream in = urlConnection.getInputStream();

            //convert stream into bitmap image
            bitmap = BitmapFactory.decodeStream(new BufferedInputStream(in));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  bitmap;
    }
}