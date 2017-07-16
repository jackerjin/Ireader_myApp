package com.example.tarena.volleytest02;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class SecondActivity extends AppCompatActivity {
RequestQueue queue=null;
    ImageView imageView_album;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imageView_album= (ImageView) findViewById(R.id.imageView_Album);
        queue= Volley.newRequestQueue(this);
    }
    public void loadAlbum(View view){
        ImageLoader imageLoader=new ImageLoader(queue, new ImageLoader.ImageCache() {
          int maxSize=1024*1024*4;
            LruCache<String,Bitmap> cache=new LruCache<String,Bitmap>(maxSize){
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes()*value.getHeight();
                }
            };

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }
            @Override
            public void putBitmap(String url, Bitmap bitmap) {
             //把缓存的图片加载到集合中
                cache.put(url,bitmap);
            }
        });
        ImageLoader.ImageListener listener=ImageLoader.getImageListener(imageView_album,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        String url= "http://172.60.25.77:8080/MusicServer/images/meiyikedoushizhanxinde.jpg";
        imageLoader.get(url,listener,100,100);
    }
}
