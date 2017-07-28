package com.example.tarena.ireader_myapp.Fragment;


import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tarena.ireader_myapp.Adapter.BookBrackAdapter;
import com.example.tarena.ireader_myapp.Adapter.MyAdapter;
import com.example.tarena.ireader_myapp.HttpUitl.JsoupManager;
import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.entity.BookBrack;
import com.example.tarena.ireader_myapp.manager.HttpbookbrackJsoup;
import com.example.tarena.ireader_myapp.ui.MainActivity;
import com.example.tarena.ireader_myapp.ui.SearchActivity;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookbrackFragment extends Fragment {
     RecyclerView mRecyclerView;
    List<BookBrack> datas;
    BookBrackAdapter adapter;
    List<String> list1;
    List<String> list2;
    public BookbrackFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookbrack, container, false);
        ImageView imageView_bookbrack = (ImageView) view.findViewById(R.id.bookbrack_toolbar_user_id);
        ImageView imageView_bb_search = (ImageView) view.findViewById(R.id.bookbrack_toolbar_search_id);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.bookbrack_recyclerviewId);
        //设置layoutManager
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //设置adapter
        //构建适配器，关联适配器
        datas = new ArrayList<>();
        adapter = new BookBrackAdapter(getActivity(), datas);
        mRecyclerView.setAdapter(adapter);
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(decoration);


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
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.show();
            }
        });
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    private void refresh() {
        String url = "http://r.qidian.com/signnewbook?style=1";
        JsoupManager.getBookbrack(url, new JsoupManager.OnResponseListener<Document>() {
            @Override
            public void onResponse(Document document) {
         //TODO jsoup 解析
                List<BookBrack> bookBracks = new ArrayList<>();
                list1=new ArrayList<String>();
                list2 = new ArrayList<String>();

                Elements elements = document.select("div[class=book-mid-info]");
                for (Element element : elements) {
                    Elements titleElement=element.select("a");
                    Log.i("TAG", "titleElement "+titleElement.text());
                    list1.add(titleElement.text());
                }
                Elements imgElements = document.select("div[class=book-img-box] img");
                for (Element imgElement : imgElements) {
                    Log.i("TAG", "imgElement "+imgElement.attr("src"));
                    list2.add("http:"+imgElement.attr("src")+"");
                }
                for (int i = 0; i <20 ; i++) {
                    BookBrack bookBrack = new BookBrack();
                    bookBrack.setTitle(list1.get(i));
                    bookBrack.setImg_url(list2.get(i));
                    bookBracks.add(bookBrack);

                }
                adapter.addAll(bookBracks,true);

            }
        });
    }
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

        private int space;

        public SpacesItemDecoration(int space) {
            this.space=space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left=space;
            outRect.right=space;
            outRect.bottom=space;
            if(parent.getChildAdapterPosition(view)==0){
                outRect.top=space;
            }
        }
    }
}


