package com.example.tarena.ireader_myapp.HttpUitl;

import android.os.Handler;
import android.os.Looper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by tarena on 2017/6/29.
 */

public class JsoupManager {
    public static void getBookbrack(final String url, final OnResponseListener<Document> listener){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    final Document document = Jsoup.connect(url).get();
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onResponse(document);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
    public interface OnResponseListener<T>{
        void onResponse(T t);
    }
}
