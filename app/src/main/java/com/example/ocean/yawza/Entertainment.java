package com.example.ocean.yawza;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Entertainment extends AppCompatActivity {

    ArrayList<String> result = new ArrayList<>();
    //private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment);
        final TextView mTextView = findViewById(R.id.displayText);

        final ProgressBar progressBar = findViewById(R.id.progressBar);

                // Instantiate the RequestQueue with Volley.
        RequestQueue queue = Volley.newRequestQueue(this);
        final String url ="https://newsapi.org/v2/top-headlines?country=ng&category=entertainment&apiKey=40f233687a574369b42c8cd177ab60e0";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);

                        try {
                            JSONObject obj = new JSONObject(response);
                            JSONArray arr = obj.getJSONArray("articles");
                            for (int i = 0; i < arr.length(); i++)
                            {
                                String title = arr.getJSONObject(i).getString("title");
                                String author = arr.getJSONObject(i).getString("author");
                                result.add(title+"\n"+author.toUpperCase()+"\n======================\n");
                            }
                            //Log.d(TAG, result.toString());
                            mTextView.setText(result.toString());
                        } catch (JSONException e) {}


                        /*/ parse the response
                        try {
                                progressBar.setVisibility(View.GONE);
                                JSONObject object = (JSONObject) new JSONTokener(response).nextValue();
                                String title = object.getString("title");
                                mTextView.setText(title);

                        } catch (JSONException e) {}*/
                        // Display the first 500 characters of the response string.
                        //mTextView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
} // end of entertainment class
