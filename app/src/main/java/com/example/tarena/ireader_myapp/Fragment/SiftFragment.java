package com.example.tarena.ireader_myapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.tarena.ireader_myapp.Adapter.SiftAdapter;
import com.example.tarena.ireader_myapp.manager.HttpSiftManager;
import com.example.tarena.ireader_myapp.ui.CartoonActivity;
import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.entity.Sift;
import com.example.tarena.ireader_myapp.ui.MainActivity;
import com.example.tarena.ireader_myapp.ui.SiftDetailActivity;
import com.example.tarena.ireader_myapp.view.MyBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class SiftFragment extends BaseFragment {
    List<Sift.ResultBean.GetSpecifiedRankRspBean.RankContentListBean.RankContentBean> datas;
    SiftAdapter adapter;
    View view;
     ImageView ivBack;

    public SiftFragment() {

    }

    @BindView(R.id.sift_listView)
    ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_sift, container, false);
    //为listview添加若干个头部
        ButterKnife.bind(this, view);
        ivBack = (ImageView) view.findViewById(R.id.sift_toolbar_user_id);
        LoadSiftdatas();
        initListView(inflater);
        return view;
    }

    private void LoadSiftdatas() {
        HttpSiftManager.LoadSift(getActivity(), new HttpSiftManager.SiftLoadListener() {
            @Override
            public void onSiftLoadEnd(Sift sift) {
                datas = new ArrayList<Sift.ResultBean.GetSpecifiedRankRspBean.RankContentListBean.RankContentBean>();
                datas = sift.getResult().getGetSpecifiedRankRsp().getRankContentList().getRankContent();
                adapter.addAll(datas, true);
            }
        });
    }

    private void initListView(LayoutInflater inflater) {

        View listHeader = inflater.inflate(R.layout.sift_header_layout, listView, false);

        datas = new ArrayList<>();
        adapter = new SiftAdapter(getActivity(), datas);
        MyBanner myBanner = new MyBanner(getActivity(), null);
        listView.addHeaderView(myBanner);
        listView.addHeaderView(listHeader);
        listView.setAdapter(adapter);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sift.ResultBean.GetSpecifiedRankRspBean.RankContentListBean.RankContentBean rankContentBean;
                rankContentBean = adapter.getItem(position - 2);
                Intent intent = new Intent(getActivity(), SiftDetailActivity.class);
                intent.putExtra("rankContentBean", rankContentBean);
                startActivity(intent);

            }
        });
        View cartoonBTN = listHeader.findViewById(R.id.item_iv_cartoon);
        cartoonBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CartoonActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initialUI() {
//        actionbar= (LinearLayout) contentView.findViewById(R.id.sift_toolbar);
//        initialActionbar(-1,"短信息",-1);
    }
}
