package com.example.tarena.ireader_myapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarena.ireader_myapp.R;

public class SplashActivity extends AppCompatActivity {
    private ImageView imageView;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setSplashTimer();
        setSplashImageView();
    }
    /**实现倒计时操作*/
    int count=3;
    public void setSplashTimer(){
        final TextView textView= (TextView) findViewById(R.id.textview_splash_id);
        textView.setText(String.valueOf(3));
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                count--;
                if(count>=0) {
                    textView.setText(String.valueOf(count));
                    handler.postDelayed(this,1000);
                }else{

//                    startActivity(new Intent(SplashActivity.this,
//                            NoviceActivity.class));
                    finish();
                }
            }
        },1000);
        setGoToNextPager();
    }

    private void setGoToNextPager() {
        Handler h = new Handler(){
            public void handleMessage(Message msg) {
                GoToNextPager();
            };
        };
        h.sendMessageDelayed(Message.obtain(), 3000);
    }

    protected void GoToNextPager() {
        SharedPreferences sp = getSharedPreferences("gars", Context.MODE_PRIVATE);
        boolean isUsed = sp.getBoolean("isUsed",false);
        if(isUsed){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else{
            SharedPreferences.Editor et=sp.edit();
            et.putBoolean("isUsed",true);
            et.commit();
            Intent intent = new Intent(this,NoviceActivity.class);
            startActivity(intent);
        }
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    private void setSplashImageView() {
        imageView = (ImageView) findViewById(R.id.image_splash_Id);
        animation = AnimationUtils.loadAnimation(this, R.anim.alpha_animation);}
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//    }

}