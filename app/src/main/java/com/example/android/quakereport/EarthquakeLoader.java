package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private static final String LOG_TAG=EarthquakeLoader.class.getName();
    private String murl;
    public EarthquakeLoader(Context context, String url)
    {
        super(context);
        murl=url;
    }

    @Override
    protected void onStartLoading() {
        Log.v(LOG_TAG,"TEST onStartLoading");
    forceLoad();//triggers loadInBackground() to execute
    }


    @Override
    public List<Earthquake> loadInBackground() {
        Log.v(LOG_TAG,"TEST loadInBackground");
     if(murl==null)
     {
         return null;
     }
     List<Earthquake>earthquakes=QueryUtils.fetchEarthquakeData(murl);
     return earthquakes;
    }
}
