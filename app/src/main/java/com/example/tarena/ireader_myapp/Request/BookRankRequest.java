//package com.example.tarena.ireader_myapp.Request;
//
//import com.android.volley.NetworkResponse;
//import com.android.volley.ParseError;
//import com.android.volley.Request;
//import com.android.volley.Response;
//import com.android.volley.toolbox.HttpHeaderParser;
//import com.example.tarena.ireader_myapp.entity.BookRank;
//import com.google.gson.Gson;
//
//import java.io.UnsupportedEncodingException;
//
///**
// * Created by tarena on 2017/6/9.
// */
//
//public class BookRankRequest extends Request<BookRank> {
//    private final Response.Listener<BookRank> mlistener;
//
//    public BookRankRequest(int method, String url, Response.Listener listener,Response.ErrorListener errorListener) {
//        super(method, url, errorListener);
//       this.mlistener=listener;
//    }
//    public BookRankRequest( String url, Response.Listener listener,Response.ErrorListener errorListener) {
//        this(0, url, listener,errorListener);
//
//    }
//
//
//    @Override
//    protected Response<BookRank> parseNetworkResponse(NetworkResponse response) {
//        String parsed;
//        try {
//            parsed=new String(response.data, HttpHeaderParser.parseCharset(response.headers));
//            Gson gson=new Gson();
//            BookRank bookRank=gson.fromJson(parsed,BookRank.class);
//            return Response.success(bookRank,HttpHeaderParser.parseCacheHeaders(response));
//        } catch (Exception e) {
//            return Response.error(new ParseError(e));
//        }
//
//    }
//
//    @Override
//    protected void deliverResponse(BookRank response) {
//        this.mlistener.onResponse(response);
//
//    }
//}
