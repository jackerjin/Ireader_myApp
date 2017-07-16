package com.example.tarena.ireader_myapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.tarena.ireader_myapp.Adapter.MyStackAdapter;
import com.example.tarena.ireader_myapp.ui.MainActivity;
import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.ui.SearchActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class StackFragment extends BaseFragment {
    private String[] myDataset = {"小说", "文学", "青春文学", "管理", "经济", "成功励志"};
    private int[] images={R.mipmap.shuku1, R.mipmap.shuku2,
            R.mipmap.shuku3, R.mipmap.shuku4, R.mipmap.shuku5, R.mipmap.shuku6};
    private int[] images1 = {R.mipmap.shukua, R.mipmap.shukub,
            R.mipmap.qingchun, R.mipmap.shukud, R.mipmap.shukue, R.mipmap.shukuc};
    private RecyclerView mRecyclerView;


    public StackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        contentView= inflater.inflate(R.layout.fragment_stack, container, false);
        mRecyclerView = (RecyclerView) contentView.findViewById(R.id.stack_recyclerviewId);
        ImageView imageView_Stack = (ImageView) contentView.findViewById(R.id.image_acitonBar_id);
        ImageView iv_AcitonBar_Search = (ImageView) contentView.findViewById(R.id.image_acitonBar_search_id);
        //为了性能一般设置此选项
        mRecyclerView.setHasFixedSize(true);
        //构建一个layoutManager对象
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        //构建适配器，关联适配器
        MyStackAdapter mAdapter = new MyStackAdapter(myDataset, images,images1);
        mRecyclerView.setAdapter(mAdapter);
        iv_AcitonBar_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        imageView_Stack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.show();
            }
        });
        initialUI();
        return contentView;
    }

    @Override
    public void initialUI() {
        actionbar= (LinearLayout) contentView.findViewById(R.id.stack_toolbarId);
        initialActionbar(R.drawable.ic_sy_yh2x,"图书库",R.drawable.ic_sy_ss2x);
    }
}
