package com.bridgelabz.urlconnectionwithlistview;

/**
 * Created by Nadimuddin on 8/9/16.
 * purpose: android tutorial(for learning android)
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    ListView mListView;
    MyAdapter mAdapter;

    //this method is called when activity first created
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting object of ListView from XML
        mListView = (ListView)findViewById(R.id.list_item);

        //initializing object of AsyncTask class
        URLConnection urlConn = new URLConnection(){
            @Override
            protected void onPostExecute(ArrayList arrayList) {

                Log.i(TAG,"mJsonString in PostExecute"+mJsonString);

                //pass Context of MainActivity & object of ArrayList to MyAdapter class
                mAdapter = new MyAdapter(MainActivity.this, arrayList);

                //set adapter to ListView
                mListView.setAdapter(mAdapter);
            }
        };

        //call doInBackground method of AsyncTask class to fetch the content from URL
        urlConn.execute("http://www.androidbegin.com/tutorial/jsonparsetutorial.txt");
    }
}