package com.tarena.jin.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.tarena.jin.Adapter.MyAdapter;
import com.tarena.jin.LoginActivity;
import com.tarena.jin.MainActivity;
import com.tarena.jin.R;
import com.tarena.jin.SearchActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookbrackFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private String[] myDataset = {"父亲决定孩子的一生", "谁都不敢欺负你", "青春", "人海沉浮录", "苏轼墨迹", "我的阅读"};
    private int[] images = {R.mipmap.fuqinjuedinghaizideyisheng, R.mipmap.shuidoubuganqifuni,
            R.mipmap.qingchun, R.mipmap.renhaichenfulu, R.mipmap.sushimoji, R.mipmap.wodeyuedu};

    public BookbrackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookbrack, container, false);
        ImageView imageView_bookbrack = (ImageView) view.findViewById(R.id.bookbrack_toolbar_user_id);
        ImageView imageView_bb_search = (ImageView) view.findViewById(R.id.bookbrack_toolbar_search_id);
//        WebView infoWebView= (WebView)view.findViewById(R.id.wv_page);
//        infoWebView.getSettings().setUseWideViewPort(true);
//        infoWebView.getSettings().setLoadWithOverviewMode(true);
//        infoWebView.loadUrl("http://dushu.m.baidu.com");
//        infoWebView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
        mRecyclerView = (RecyclerView) view.findViewById(R.id.bookbrack_recyclerviewId);

        //为了性能一般设置此选项
        mRecyclerView.setHasFixedSize(true);
        //构建一个layoutManager对象
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        //构建适配器，关联适配器
        MyAdapter mAdapter = new MyAdapter(myDataset, images);
        mRecyclerView.setAdapter(mAdapter);
        imageView_bb_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        imageView_bookbrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.show();
            }
        });
        return view;

    }
}


