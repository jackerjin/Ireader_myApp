package com.tarena.jin.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tarena.jin.FreebookActivity;
import com.tarena.jin.MainActivity;
import com.tarena.jin.R;
import com.tarena.jin.SearchActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends BaseFragment {


    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        contentView= inflater.inflate(R.layout.fragment_discover, container, false);
        ImageView imageView_free= (ImageView) contentView.findViewById(R.id.iv_discover_free);
        ImageView imageView_Discover = (ImageView) contentView.findViewById(R.id.image_acitonBar_id);
        ImageView iv_AcitonBar_search = (ImageView) contentView.findViewById(R.id.image_acitonBar_search_id);
        iv_AcitonBar_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        imageView_Discover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.show();
            }
        });
        imageView_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), FreebookActivity.class);
                startActivity(intent);
            }
        });
        initialUI();
        return contentView;
    }

    @Override
    public void initialUI() {
        actionbar= (LinearLayout) contentView.findViewById(R.id.discover_toolbarId);
        initialActionbar(R.mipmap.login,"发现",R.mipmap.search);
    }
}
