package com.example.tarena.ireader_myapp.ui;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.utils.CleanUtil;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.tarena.ireader_myapp.utils.CleanUtil.getFolderSize;

public class NavigationActivity extends AppCompatActivity {
    @BindView(R.id.tv_navigation_show)
    TextView tvCount;
    @BindView(R.id.btn_navigation_clean)
    Button btnClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {

        double cacheSize = 0;
        try {
            cacheSize = getFolderSize(this.getCacheDir());
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                cacheSize += getFolderSize(this.getExternalCacheDir());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (cacheSize > 0){
            String formatSize = CleanUtil.getFormatSize(cacheSize);
            tvCount.setText(formatSize);
    }
    }
    @OnClick(R.id.btn_navigation_clean)
     public void BtnClean(View v){
         btnClean.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 CleanUtil.clearAllCache(getApplication());
                 tvCount.setText("清理完成");

             }
         });
     }
}
