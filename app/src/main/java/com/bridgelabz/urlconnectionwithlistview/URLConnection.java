package com.bridgelabz.urlconnectionwithlistview;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Nadimuddin on 7/9/16.
 */
public class URLConnection extends AsyncTask<String, Void, ArrayList> {
    HttpURLConnection urlConnection;
    private static final String TAG = "URLConnection";
    String mJsonString,mURL;
    ArrayList<CountryInfo> mArrayList;



    @Override
    protected ArrayList doInBackground(String... strings)
    {
        String strTemp,jsonString="";
        mURL = strings[0];
        try
        {
            //declaring object of URL with a given url
            URL url = new URL(mURL);

            //open connection to the URL
            urlConnection = (HttpURLConnection) url.openConnection();

            //get stream i.e. content from URL
            InputStream in = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            //read stream line by line
            while ((strTemp = br.readLine()) != null)
                jsonString = jsonString + strTemp;

            /*make JSON object,
            * retrieve data from downloaded JSON string
            * and store data in ArrayList*/
            mArrayList = makeArrayListFromJson(jsonString);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return mArrayList;
    }

    private ArrayList makeArrayListFromJson(String jsonString)
    {
        ArrayList<CountryInfo> arrayList = new ArrayList<>();
        Bitmap bitmap;
        try
        {
            JSONObject obj=new JSONObject(jsonString);
            JSONArray array = obj.optJSONArray("worldpopulation");

            int rank;
            String country;
            String population;
            String flag;

            /*
            * get JSON object
            * and convert to appropriate data type
            * */
            for(int i=0; i<array.length(); i++)
            {
                JSONObject object = (JSONObject)array.get(i);
                rank = object.getInt("rank");
                country = object.getString("country");
                population = object.getString("population");
                flag = object.getString("flag");

                Log.i(TAG, "rank: "+rank+"\ncountry: "+country+
                        "\npopulation: "+population+"\nflag: "+flag);

                //initializing object of DownloadImage class
                DownloadImage downloadImage = new DownloadImage();

                //download a bitmap image by passing url of that image
                bitmap = downloadImage.downloadImage(flag);

                //add all data & bitmap image to ArrayList
                arrayList.add(new CountryInfo(rank, country, population, bitmap));
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        return  arrayList;
    }
}
