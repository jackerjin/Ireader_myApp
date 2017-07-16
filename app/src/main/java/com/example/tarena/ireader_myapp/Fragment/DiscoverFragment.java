package com.example.tarena.ireader_myapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.tarena.ireader_myapp.ui.FreebookActivity;
import com.example.tarena.ireader_myapp.ui.MainActivity;
import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.ui.SearchActivity;


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
        initialActionbar(R.drawable.ic_sy_yh2x,"发现",R.drawable.ic_sy_ss2x);
    }
}
