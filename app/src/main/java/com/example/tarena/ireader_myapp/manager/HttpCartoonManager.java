package com.example.tarena.ireader_myapp.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.constant.IURL;
import com.example.tarena.ireader_myapp.entity.Cartoon;
import com.google.gson.Gson;

/**
 * Created by tarena on 2017/6/13.
 */

public class HttpCartoonManager {
    public static RequestQueue queue = null;

    public static void LoadCartoon(Context context, final CartoonLoadListener listener) {

        try {
            String url = IURL.ROOT+IURL.APPKEY;

            if (queue == null) {
                queue = Volley.newRequestQueue(context);
            }
            StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("TAG:response", response);
                    Gson gson = new Gson();
                    Cartoon cartoon = gson.fromJson(response, Cartoon.class);
                    //把数据通知给Activity
                    listener.onCartoonLoadEnd(cartoon);
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

    public interface CartoonLoadListener {
        public void onCartoonLoadEnd(Cartoon cartoon);
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
