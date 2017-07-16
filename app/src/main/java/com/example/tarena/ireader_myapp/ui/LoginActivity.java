package com.example.tarena.ireader_myapp.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tarena.ireader_myapp.MyApplication;
import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.app.MyApp;
import com.example.tarena.ireader_myapp.entity.MyUser;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.listener.SaveListener;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.lg_ev_username)
    EditText etUsername;
    @BindView(R.id.lg_ev_password)
    EditText etPassword;
    String username ;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }
    @OnClick(R.id.btn_login)
    public void Onlogin(View view){
        username = etUsername.getText().toString();
        password=etPassword.getText().toString();
        if (TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            Toast.makeText(this, "请输入完整信息", Toast.LENGTH_SHORT).show();
            return;
        }
        login(username,password);


    }
    @OnClick(R.id.btn_register)
    public void Onregist(View view){
        Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
        startActivity(intent);
    }
    private void login(final String username, final String password){
        MyUser user = new MyUser();
        user.setUsername(username);
        user.setPassword(password);
        user.login(this, new SaveListener() {
            @Override
            public void onSuccess() {

                SharedPreferences sharedPreferences = getSharedPreferences("test", Activity.MODE_PRIVATE);
                //实例化SharedPreferences.Editor对象
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //用putString的方法保存数据
                editor.putString("username", username);
                editor.putString("password", password);
                //提交数据
                editor.commit();

               MyApp.user="已登录";
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);


            }

            @Override
            public void onFailure(int i, String s) {
//登录失败
                Toast.makeText(LoginActivity.this, "登录失败，用户名或密码错误", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //点击空白区域收起软键盘
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm!=null){
            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),
                    0);
        }

        return super.onTouchEvent(event);
    }
//    //初始化drawerLayout
//    private void setDrawerLayout(){
//      NavigationView  navigationView = (NavigationView) findViewById(R.id.my_navigation_view);
//        View drawer = navigationView.inflateHeaderView(R.layout.start_drawer_header);
////      ImageView  imageView_login = (ImageView) drawer.findViewById(R.id.imageView_login);
//        TextView textView= (TextView) drawer.findViewById(R.id.tv_navigation_login);
//        Log.i("TAG","header.textView="+textView);
//        textView.setText(MyApp.user="已登录");
//
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}

