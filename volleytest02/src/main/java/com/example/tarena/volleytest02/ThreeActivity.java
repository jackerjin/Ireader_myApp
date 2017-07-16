package com.example.tarena.volleytest02;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

public class ThreeActivity extends AppCompatActivity {
NetworkImageView imageView_Network;
    RequestQueue queue=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        imageView_Network= (NetworkImageView) findViewById(R.id.newwork_ImageView);
        queue= Volley.newRequestQueue(this);
        imageView_Network.setDefaultImageResId(R.mipmap.ic_launcher);
        imageView_Network.setErrorImageResId(R.mipmap.ic_launcher_round);
    }

    public void LoadNetWork(View view) {
        String url= "http://172.60.25.77:8080/MusicServer/images/meiyikedoushizhanxinde.jpg";
        ImageLoader imageLoader=new ImageLoader(queue, new ImageLoader.ImageCache() {
           int maxSize=1024*1024*4;
            LruCache<String,Bitmap> cache=new LruCache<String,Bitmap>(maxSize){
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes()*value.getRowBytes();
                }
            };
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
              cache.put(url,bitmap);
            }
        });

        imageView_Network.setImageUrl(url,imageLoader);

    }
}
