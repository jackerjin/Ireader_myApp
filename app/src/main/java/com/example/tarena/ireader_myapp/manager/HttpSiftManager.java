package com.example.tarena.ireader_myapp.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tarena.ireader_myapp.constant.IURL;
import com.example.tarena.ireader_myapp.entity.Cartoon;
import com.example.tarena.ireader_myapp.entity.Sift;
import com.google.gson.Gson;

/**
 * Created by tarena on 2017/7/5.
 */

public class HttpSiftManager {
    public static RequestQueue queue = null;

    public static void LoadSift(Context context, final SiftLoadListener listener) {

        try {
            String url = "http://japi.juhe.cn/rank/getRankInfo?key=cad9f2e0e99355fca7d5f9bdf9fd6fda&contentType=1&rankType=1&rankTime=1";

            if (queue == null) {
                queue = Volley.newRequestQueue(context);
            }
            StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("TAG:response", response);
                    Gson gson = new Gson();
                    Sift sift = gson.fromJson(response, Sift.class);
                    //把数据通知给Activity
                    listener.onSiftLoadEnd(sift);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("TAG:response", error + "");
                }
            });
            queue.add(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface SiftLoadListener {
        public void onSiftLoadEnd(Sift sift);


    }
    public static void LoadImage(String url, final ImageView imageView) {
        //创建图片请求对象
        ImageRequest request = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, 0, 0, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

    }
}
