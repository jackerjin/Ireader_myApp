package com.example.tarena.volleytest01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.tarena.volleytest01.request.PullParseRequest;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.net.URL;
import java.net.URLEncoder;

public class PullParserActivity extends AppCompatActivity {
    RequestQueue queue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_parser);
        queue = Volley.newRequestQueue(this);
    }

    /**
     *
     * @param view
     */
    public void testParser(View view) {
        String url = "http://flash.weather.com.cn/wmaps/xml/china.xml";
        PullParseRequest request = new PullParseRequest(url, new Response.Listener<XmlPullParser>() {
            @Override
            public void onResponse(XmlPullParser parser) {
                try {
                    int eventType=parser.getEventType();
                    while (eventType!=XmlPullParser.END_DOCUMENT){
                        switch (eventType){
                            case XmlPullParser.START_TAG:
                                String nodeName=parser.getName();
                                if (nodeName.equals("city")){
                                    String quName=parser.getAttributeValue(0);
                                    String pyName=parser.getAttributeValue(1);
                                    String cityname=parser.getAttributeValue(2);
                                    Log.i("TAG:quName",quName);
                                    Log.i("TAG:pyName",pyName);
                                    Log.i("TAG:cityname",cityname);
                                }
                                break;
                        }
                        //移动文件指针，指向下一个标签
                        eventType=parser.next();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
}
