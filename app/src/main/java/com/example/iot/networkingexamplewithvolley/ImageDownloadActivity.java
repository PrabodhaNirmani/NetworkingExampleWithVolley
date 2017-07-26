package com.example.iot.networkingexamplewithvolley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by iot on 7/12/17.
 */

public class ImageDownloadActivity extends AppCompatActivity
    {
        private NetworkImageView mNetworkImageView;
        private ImageLoader mImageLoader;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_download);
        mNetworkImageView = (NetworkImageView) findViewById(R.id
                .networkImageView);
    }

        @Override
        protected void onStart() {
        super.onStart();
        // Instantiate the RequestQueue.
        mImageLoader = VolleyImageDownloadHelper.getInstance(this.getApplicationContext())
                .getImageLoader();
        //Image URL - This can point to any image file supported by Android
        final String url = "http://www.gstatic.com/webp/gallery/1.jpg";
        mImageLoader.get(url, ImageLoader.getImageListener(mNetworkImageView,
                R.mipmap.android, android.R.drawable
                        .ic_dialog_alert));
        mNetworkImageView.setImageUrl(url, mImageLoader);
    }
    }
