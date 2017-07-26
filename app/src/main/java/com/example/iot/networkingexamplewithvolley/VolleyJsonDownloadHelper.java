package com.example.iot.networkingexamplewithvolley;

import android.app.Application;
import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

public class VolleyJsonDownloadHelper {
    private static VolleyJsonDownloadHelper sInstance;
    private static Context mCtx;
    private RequestQueue mRequestQueue;

    private VolleyJsonDownloadHelper(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }
    public static synchronized VolleyJsonDownloadHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new VolleyJsonDownloadHelper(context);
        }
        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // Set up the network to use HttpURLConnection as the HTTP client.
            //An HttpStack based on HttpURLConnection.
            //Network network = new BasicNetwork(new HurlStack());
            mRequestQueue = Volley.newRequestQueue(mCtx);
            // Don't forget to start the volley request queue
            mRequestQueue.start();
        }
        return mRequestQueue;
    }
}
