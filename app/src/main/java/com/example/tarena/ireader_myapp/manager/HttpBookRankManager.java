//package com.example.tarena.ireader_myapp.manager;
//
//import android.content.Context;
//import android.util.Log;
//
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//import com.example.tarena.ireader_myapp.entity.BookRank;
//import com.google.gson.Gson;
//
///**
// * Created by tarena on 2017/6/9.
// */
//
//public class HttpBookRankManager {
//   public static RequestQueue  queue=null;
//
//    public static void LoadBookRankFromHttp(Context context, final BookRankLoadListener loadListener){
//if (queue==null){
//        queue= Volley.newRequestQueue(context);}
//        String url="http://japi.juhe.cn/rank/getRankType?key=cad9f2e0e99355fca7d5f9bdf9fd6fda";
//        StringRequest request=new StringRequest(url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Gson gson=new Gson();
//                BookRank bookRank=gson.fromJson(response,BookRank.class);
//                Log.i("TAG:",response+"");
//           loadListener.onBookRanKLoadEnd(bookRank);
//            }
//
//        }, new Response.ErrorListener() {
//
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.i("TAG:",error+"");
//            }
//        });
//        queue.add(request);
//    }
//    public interface BookRankLoadListener{
//        public void onBookRanKLoadEnd(BookRank bookRank);
//    }
//}
