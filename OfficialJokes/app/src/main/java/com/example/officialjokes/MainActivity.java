package com.example.officialjokes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Joke> jokeList;
    Adapter adapter;
    private static String JSON_URL = "https://official-joke-api.appspot.com/jokes/ten";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        jokeList = new ArrayList<>();

        loadJokes();
    }

    private void loadJokes()
    {

      RequestQueue requestQueue = Volley.newRequestQueue(this);
      JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
          @Override
          public void onResponse(JSONArray response) {

              for (int i = 0; i <response.length(); i++)
              {
                  try {
                      JSONObject jsonObject = response.getJSONObject(i);

                      Joke joke = new Joke();

                      joke.setId(jsonObject.getString("id").toString());
                      joke.setSetup(jsonObject.getString("setup").toString());
                      joke.setPunchline(jsonObject.getString("punchline").toString());
                      joke.setType(jsonObject.getString("type").toString());

                      jokeList.add(joke);

                  } catch (JSONException e) {
                      e.printStackTrace();
                  }
              }

              //Set Objects to RecyclerView

              recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
              adapter = new Adapter(getApplicationContext(),jokeList);
              recyclerView.setAdapter(adapter);


          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
              Log.d("Error", error + "");
          }
      });

    requestQueue.add(jsonArrayRequest);


    }
}