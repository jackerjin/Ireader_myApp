package com.example.tarena.ireader_myapp.app;

import android.app.Application;
import android.content.Context;
import android.view.WindowManager;
import android.widget.RadioGroup;


import java.util.ArrayList;

import cn.bmob.push.BmobPush;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobInstallation;

/**
 * Created by tarena on 2017/7/5.
 */

public class MyApp extends Application {
    public static MyApp CONTEXT;
    public static int KScreenW;
    public static int KScreenH;
    public static String user;
//    public static MediaPlayer player;
    public static RadioGroup mainRG;
    public static ArrayList<String> requests = new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();

        CONTEXT = this;
        WindowManager wm = (WindowManager)
                getSystemService(Context.WINDOW_SERVICE);

        KScreenW = wm.getDefaultDisplay().getWidth();
        KScreenH = wm.getDefaultDisplay().getHeight();
        //个人账户：303fa54fc82a1ba90bf104de07594b15
        Bmob.initialize(this, "303fa54fc82a1ba90bf104de07594b15");
        // 使用推送服务时的初始化操作
        BmobInstallation.getCurrentInstallation(this).save();
        // 启动接受服务器推送服务
        BmobPush.startWork(this);
        //创建默认的ImageLoader配置参数

    }
}
