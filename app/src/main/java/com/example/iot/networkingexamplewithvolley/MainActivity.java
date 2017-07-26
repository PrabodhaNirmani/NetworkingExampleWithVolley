package com.example.iot.networkingexamplewithvolley;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private Bitmap bitmap = null;
    Button btnDownloadImage;
    Button btnDownloadJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDownloadImage = (Button) findViewById(R.id.button);

        btnDownloadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (checkInternetConenction()) {
//                    downloadImage("http://www.gstatic.com/webp/gallery/1.jpg");
//                } else {
//                    Toast.makeText(getBaseContext(), " Not Connected ", Toast.LENGTH_LONG).show();
//                }
                Intent intent = new Intent(MainActivity.this, ImageDownloadActivity.class);
                startActivity(intent);
            }
        });


        btnDownloadJson = (Button) findViewById(R.id.buttonNext);
        btnDownloadJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (checkInternetConenction()) {
//                    downloadImage("http://www.gstatic.com/webp/gallery/1.jpg");
//                } else {
//                    Toast.makeText(getBaseContext(), " Not Connected ", Toast.LENGTH_LONG).show();
//                }
                Intent intent = new Intent(MainActivity.this, JsonDownloadActivity.class);
                startActivity(intent);
            }
        });
    }
}
