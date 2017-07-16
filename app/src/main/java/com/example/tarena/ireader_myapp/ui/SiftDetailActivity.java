package com.example.tarena.ireader_myapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.entity.Sift;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SiftDetailActivity extends AppCompatActivity {
    @BindView(R.id.sift_detail_webView)
    WebView webView;
   @BindView(R.id.iv_siftDetail_back)
    ImageView ivBack;
    Sift.ResultBean.GetSpecifiedRankRspBean.RankContentListBean.RankContentBean rankContentBean;
    List<Sift.ResultBean.GetSpecifiedRankRspBean.RankContentListBean.RankContentBean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sift_detail);
        ButterKnife.bind(this);
        rankContentBean = (Sift.ResultBean.GetSpecifiedRankRspBean.RankContentListBean.RankContentBean)
                getIntent().getSerializableExtra("rankContentBean");
        initUI();
    }

    private void initUI() {
        webView.clearCache(true);
        webView.loadUrl(rankContentBean.getWapURL());
        webView.setWebViewClient(new WebViewClient());
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
