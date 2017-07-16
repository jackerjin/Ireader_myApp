package com.tarena.jin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tarena.jin.Fragment.BookbrackFragment;
import com.tarena.jin.Fragment.DiscoverFragment;
import com.tarena.jin.Fragment.SiftFragment;
import com.tarena.jin.Fragment.StackFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {
    private RadioGroup mRadioGroup;
    private RadioButton radioButton;
    private ImageView imageView_login;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //初始化toolbar
//        //1.设置toolbar为页面的actionbar
//        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
//        setSupportActionBar(toolbar);
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroupId);
        navigationView = (NavigationView) findViewById(R.id.my_navigation_view);
        View drawer = navigationView.inflateHeaderView(R.layout.start_drawer_header);
        imageView_login = (ImageView) drawer.findViewById(R.id.imageView_login);
        //添加监听
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout_Main_Id);
        navigationView.setNavigationItemSelectedListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
        imageView_login.setOnClickListener(this);
        radioButton = (RadioButton) mRadioGroup.findViewById(R.id.radio0);
        //让第零个默认选中
        Log.i("TAG", "radio");

        //radioButton.setChecked(true);
        onCheckedChanged(mRadioGroup, R.id.radio0);
        //initialFragment();

    }


    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        Log.i("TAG", "radio1");
        //获得fragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //添加fragment
        switch (checkedId) {
            case R.id.radio0:
                Log.i("TAG", "radio0");
                fragmentTransaction.replace(R.id.main_framelayout, new BookbrackFragment(), "radio0");

                break;
            case R.id.radio1:
                fragmentTransaction.replace(R.id.main_framelayout, new SiftFragment(), "radio1");
                break;
            case R.id.radio2:
                fragmentTransaction.replace(R.id.main_framelayout, new StackFragment(), "radio2");
                break;
            case R.id.radio3:
                fragmentTransaction.replace(R.id.main_framelayout, new DiscoverFragment(), "radio3");
                break;
        }
        fragmentTransaction.commit();
    }

    public void show() {
        DrawerLayout drawerLayout_main = (DrawerLayout) findViewById(R.id.drawerlayout_Main_Id);
        drawerLayout_main.openDrawer(GravityCompat.START);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.nav_sub_6){
            //1.执行退出操作
            //2.关闭drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }else if(item.getItemId()==R.id.nav_item_1||item.getItemId()==R.id.nav_item_2
                ||item.getItemId()==R.id.nav_item_3||item.getItemId()==R.id.nav_sub_1
                ||item.getItemId()==R.id.nav_sub_2||item.getItemId()==R.id.nav_sub_3||
                item.getItemId()==R.id.nav_sub_4||item.getItemId()==R.id.nav_sub_5){
            startActivity(new Intent(this,NavigationActivity.class));
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        return true;
    }
}
//private void initFragment() {
//    //首页(书架)
//    BookbrackFragment bookbrackFragment =new BookbrackFragment();
//    //精选(精选)
//    SiftFragment  siftFragment =new SiftFragment();
//
//    //书库
//    StackFragment stackFragment =new StackFragment();
//    //个人中心
//
//    DiscoverFragment discoverFragment =new DiscoverFragment();
//
//    //添加到数组
//
//
//    mFragments = new Fragment[]{bookbrackFragment,siftFragment,stackFragment,discoverFragment};
//
//    //开启事务
//
//    FragmentTransaction ft =
//            getSupportFragmentManager().beginTransaction();
//
//    //添加首页
//    ft.add(R.id.bookbrackFragment_layout,bookbrackFragment).commit();
//
//    //默认设置为第0个
//    setIndexSelected(0);
//
//
//}
//    private void setIndexSelected(int index) {
//
//        if(mIndex==index){
//            return;
//        }
//        FragmentManager    fragmentManager = getSupportFragmentManager();
//        FragmentTransaction ft              = fragmentManager.beginTransaction();
//
//
//        //隐藏
//        ft.hide(mFragments[mIndex]);
//        //判断是否添加
//        if(!mFragments[index].isAdded()){
//            ft.add(R.id.content,mFragments[index]).show(mFragments[index]);
//        }else {
//            ft.show(mFragments[index]);
//        }
//
//        ft.commit();
//        //再次赋值
//        mIndex=index;
//
//    }
//
//    @OnClick({R.id.rbHome, R.id.rbShop, R.id.rbMessage, R.id.rbMine})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.rbHome:
//                setIndexSelected(0);
//                break;
//            case R.id.rbShop:
//                setIndexSelected(1);
//                break;
//            case R.id.rbMessage:
//                setIndexSelected(2);
//                break;
//            case R.id.rbMine:
//                setIndexSelected(3);
//                break;
//        }
//
//    }
