package com.example.tarena.ireader_myapp.manager;

import android.os.Handler;
import android.os.Looper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by tarena on 2017/7/8.
 */

public class HttpbookbrackJsoup {
    public static void getComment(final String url, final OnResponseListener<Document> listener){
      new Thread(){
          @Override
          public void run() {
              super.run();
              try {
                  final Document document = Jsoup.connect(url).get();
                  new Handler(Looper.getMainLooper()).post(new Runnable() {
                      @Override
                      public void run() {
                          listener.OnResponse(document);
                      }
                  });
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }.start();
    }
    public interface OnResponseListener<T>{
        void OnResponse(T t);
    }
}
