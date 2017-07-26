package com.example.iot.networkingexamplewithvolley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by iot on 7/12/17.
 */

public class JsonDownloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_download);

        mTextView1 = (TextView) findViewById(R.id.text1);
        mTextView2 = (TextView) findViewById(R.id.text2);
        mTextView3 = (TextView) findViewById(R.id.text3);
        // Create a new JsonObjectRequest.
        JsonObjectRequest request = new JsonObjectRequest("http://demo6983891.mockable.io/contacts", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray contactsArray = response.getJSONArray("contacts");
                            //for (int i = 0; i < contactsArray.length(); i++) {
                            JSONObject c = contactsArray.getJSONObject(0);

                            String id = c.getString("id");
                            String name = c.getString("name");
                            String email = c.getString("email");

                            JSONObject phone = c.getJSONObject("phone");
                            String mobile = phone.getString("mobile");
                            String home = phone.getString("home");
                            //}
                            mTextView1.setText(name);
                            mTextView2.setText(email);
                            mTextView3.setText(mobile);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        mTextView1.setText(error.toString());
                    }
                }
        );

        // With the request created, simply add it to our Application's RequestQueue
        VolleyJsonDownloadHelper.getInstance(this.getApplicationContext()).getRequestQueue().add(request);
    }

    private TextView mTextView1, mTextView2, mTextView3;
}
