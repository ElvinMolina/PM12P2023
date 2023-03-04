package com.example.pm12p2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pm12p2023.RestApiMethods.Methods;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class ActivityCreate extends AppCompatActivity {

    String POSTMethod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        ConsumCreateApi();
    }

    private void ConsumCreateApi() {

        HashMap<String,String> parametros = new HashMap<>();
        parametros.put("nombres","elvin");
        parametros.put("apellidos","Molina");
        parametros.put("fechanac","02-03-2023");
        parametros.put("foto","crervrvrev");

        POSTMethod = Methods.ApiCreate;
        JSONObject jsonAlum = new JSONObject(parametros);

        RequestQueue peticion =  Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,POSTMethod, jsonAlum, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for(int i = 0; i<=jsonArray.length();i++){
                        JSONObject msg = jsonArray.getJSONObject(i);
                    }
                }catch (Exception ex){

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        peticion.add(jsonObjectRequest);
    }
}