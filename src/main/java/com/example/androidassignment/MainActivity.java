package com.example.androidassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidassignment.Adapter.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String jsonUrl="https://raw.githubusercontent.com/Amar2107/codechef/master/Notice.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Notice> noticeList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noticeList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewid);
        jsonrequest();

    }

    private void jsonrequest() {
        request = new JsonArrayRequest(jsonUrl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i = 0; i<response.length();i++)
                {
                    try {
                        jsonObject = response.getJSONObject(i);

                        Log.d("display1", "onResponse: "+jsonObject);

                        Notice notice = new Notice();
                        notice.setTitle(jsonObject.getString("title"));
                        notice.setDate(jsonObject.getString("date"));
                        notice.setNoticeText(jsonObject.getString("text"));
                        notice.setTeacher_name(jsonObject.getString("teacher"));
                        notice.setImg_url(jsonObject.getString("img"));

                        noticeList.add(notice);

                    }catch (JSONException e)
                    { e.printStackTrace(); }
                }
              setupRecyclerView(noticeList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);
    }

    private void setupRecyclerView(List<Notice> noticeList) {

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,noticeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

    }


}