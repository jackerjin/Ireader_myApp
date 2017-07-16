package com.example.tarena.volleytest01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
    }

    public void test1(View view) {
        String url = "http://172.60.25.77:8080/MusicServer/loadMusics.jsp";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("TAG", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("TAG", error.getMessage());
            }
        });
        //将请求对象添加到请求队列中
        queue.add(request);
    }

    public void test2(View view) {
        String url = "http://172.60.25.77:8080/EmployeeServer/regist.do";
        StringRequest request = new StringRequest(Request.Method.POST,url, new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                Log.i("TAG", response + "");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("TAG", error + "");
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String loginname = "jerry";
                String password = "11111";
                String realname = "jin";
                String email = "123@126.com";
                Map<String, String> params = new HashMap<>();
                params.put("loginname", loginname);
                params.put("password", password);
                params.put("realname", realname);
                params.put("email", email);
                return params;
            }
        };
        queue.add(request);
    }
    public void test3(View view){
        String url = "http://172.60.25.77:8080/MusicServer/loadMusics.jsp";
        JsonRequest request=new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
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
