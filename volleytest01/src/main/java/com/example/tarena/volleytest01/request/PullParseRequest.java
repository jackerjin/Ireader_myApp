package com.example.tarena.volleytest01.request;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.example.tarena.volleytest01.entity.WeatherBean;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.XMLFormatter;

/**
 * Created by tarena on 2017/6/9.
 */

public class PullParseRequest extends Request<XmlPullParser> {
    private final Response.Listener<XmlPullParser> mListener;

    public PullParseRequest(int method, String url, Response.Listener<XmlPullParser> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mListener = listener;
    }

    public PullParseRequest(String url, Response.Listener<XmlPullParser> listener,
                            Response.ErrorListener errorListener) {
        this(Method.GET, url, listener, errorListener);
    }

    @Override
    protected Response<XmlPullParser> parseNetworkResponse(NetworkResponse networkResponse) {
        XmlPullParser parser = null;
        try {
            String parsed = new String(networkResponse.data,
                    HttpHeaderParser.parseCharset(networkResponse.headers));
            //构建一个pull解析器
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            parser = factory.newPullParser();
            //显示中文
            parsed = new String(parsed.getBytes("iso-8859-1"), "utf-8");
            parser.setInput(new StringReader(parsed));//字节转换为流
            return Response.success(parser, HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(new ParseError(e));
        }

    }

    @Override
    protected void deliverResponse(XmlPullParser response) {
        mListener.onResponse(response);
    }
}
