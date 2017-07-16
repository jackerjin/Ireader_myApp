package com.example.tarena.volleytest01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.tarena.volleytest01.entity.WeatherBean;
import com.example.tarena.volleytest01.request.WeatherRequest;

public class WeatherActivity extends AppCompatActivity {
RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        queue= Volley.newRequestQueue(this);
    }

    public void loadWeather(View view) {
    String url="http://op.juhe.cn/onebox/weather/query?cityname=%E5%8C%97%E4%BA%AC&dtype=&key=ea8441cb939845649b04948972f34db6";
        WeatherRequest request=new WeatherRequest(url, new Response.Listener<WeatherBean>() {
            @Override
            public void onResponse(WeatherBean response) {
                Log.i("TAG",response+"");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("TAG",error+"");
            }
        });
        queue.add(request);

    }
}
