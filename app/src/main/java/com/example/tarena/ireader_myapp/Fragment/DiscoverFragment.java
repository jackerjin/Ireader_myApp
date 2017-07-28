package com.example.tarena.ireader_myapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.tarena.ireader_myapp.ui.CommentActivity;
import com.example.tarena.ireader_myapp.ui.FreebookActivity;
import com.example.tarena.ireader_myapp.ui.GameActivity;
import com.example.tarena.ireader_myapp.ui.MainActivity;
import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.ui.SearchActivity;
import com.example.tarena.ireader_myapp.ui.UserInfoActivity;
import com.example.tarena.ireader_myapp.ui.VideoActivity;


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
        RelativeLayout rlUserInfo = (RelativeLayout) contentView.findViewById(R.id.rl_userInfo);
        RelativeLayout rlComment = (RelativeLayout) contentView.findViewById(R.id.rl_comment);
        RelativeLayout rlVideo = (RelativeLayout) contentView.findViewById(R.id.rl_video);
        RelativeLayout rlGame = (RelativeLayout) contentView.findViewById(R.id.rl_game);
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
       rlUserInfo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(), UserInfoActivity.class);
               startActivity(intent);
           }
       });
        rlComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CommentActivity.class);
                startActivity(intent);
            }
        });
        rlVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                startActivity(intent);

            }
        });
        rlGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GameActivity.class);
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
