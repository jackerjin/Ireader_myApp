package com.example.tarena.ireader_myapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tarena.ireader_myapp.R;

public class NoviceActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novice);
        button = (Button) findViewById(R.id.novice_button_id);
        ViewPager viewPager= (ViewPager) findViewById(R.id.novice_viewPager_id);
        ImageAdapter adapter=new ImageAdapter();
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);

    }
    public void onClick(View v){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    private int imgs[]={R.mipmap.yin1,R.mipmap.yin3,R.mipmap.yin5};

    class ImageAdapter extends PagerAdapter{
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0 == arg1;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.i("TAG", "destroyItem:"+position);
        container.removeView((View)object);
    }
    @Override
    public Object instantiateItem(ViewGroup container,//viewPager
                                  int position) {
        Log.i("TAG", "instantiateItem="+position);
        ImageView imageview = new ImageView(NoviceActivity.this);
        imageview.setScaleType(ImageView.ScaleType.FIT_XY);
        int img=imgs[position];
        imageview.setImageResource(img);
        container.addView(imageview);
        return imageview;
    }

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.novic, menu);
        return true;
    }
    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        if(position==2){
            button.setVisibility(View.VISIBLE);
        }else{
            button.setVisibility(View.GONE);
        }
    }
}
