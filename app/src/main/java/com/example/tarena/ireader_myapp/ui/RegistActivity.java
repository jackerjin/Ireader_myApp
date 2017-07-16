package com.example.tarena.ireader_myapp.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.entity.MyUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.listener.SaveListener;

public class RegistActivity extends AppCompatActivity {
    @BindView(R.id.et_regist_username)
    EditText etRegistUsername;
    @BindView(R.id.et_regist_password)
    EditText etRegistPassword;
    @BindView(R.id.et_regist_okPassword)
    EditText etRegistOkPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btn_regist)
    public void onViewClicked(View v) {

        //3)构建实体类(MyUser)对象
        final MyUser user = new MyUser();

        user.setUsername(etRegistUsername.getText().toString());
        //是否MD5加密？取决于同学自己的设计
        user.setPassword(etRegistPassword.getText().toString());

        //进行注册
        user.signUp(this, new SaveListener() {
            @Override
            public void onSuccess() {
                //进行登录
                user.login(RegistActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        //登录成功
                        //跳转界面，跳转到MainActivity
                        Toast.makeText(RegistActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegistActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(int arg0, String arg1) {
                        Toast.makeText(RegistActivity.this, "登录失败"+arg0+arg1, Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onFailure(int arg0, String arg1) {


                Toast.makeText(RegistActivity.this, "注册失败"+arg0+arg1, Toast.LENGTH_SHORT).show();


            }
        });

    }
}
