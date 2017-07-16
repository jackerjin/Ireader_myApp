package com.tarena.jin.manager;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tarena on 2017/6/5.
 */

public class HttpManager {
    public void loadSiftBook(Context context) {

        RequestQueue mQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest("http://japi.juhe.cn/comic/book",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String success=jsonObject.getString("Success!");
                            if ("reason".equals(success)){

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(stringRequest);
        //将输入转换为字符串
        String jsonStr= StreamUtil.createStr(is);
        //将json字符串包装成json对象
        JSONObject jsonObject=new JSONObject(jsonStr);

    }
    //配置您申请的KEY
    public static final String APPKEY ="*************************";

    //1.漫画分类查询
    public static void getRequest1(){
        String result =null;
        String url ="http://japi.juhe.cn/comic/category";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key",APPKEY);//APP Key

        try {
            result =net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

