package com.example.tarena.ireader_myapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.tarena.ireader_myapp.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerSimple;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity {
    private JCVideoPlayerSimple jcVideoPlayerSimple;
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        jcVideoPlayerSimple = (JCVideoPlayerSimple) findViewById(R.id.custom_videoplayer);
        /**
         * 第一个参数为视频的URI
         * 第二个参数为视频标题
         */
        jcVideoPlayerSimple.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4",
                "书中自有黄金屋");


        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.custom_videoplayer_standard);
        /**
         * 第一个参数为视频的URI
         * 第二个参数为视频标题
         */
        jcVideoPlayerStandard.setUp("http://2449.vod.myqcloud.com/2449_bfbbfa3cea8f11e5aac3db03cda99974.f20.mp4"
                , "读书破万卷");
        Glide.with(this)
                .load("http://p.qpic.cn/videoyun/0/2449_bfbbfa3cea8f11e5aac3db03cda99974_1/640")
                .into(jcVideoPlayerStandard.ivThumb);

    }
}
