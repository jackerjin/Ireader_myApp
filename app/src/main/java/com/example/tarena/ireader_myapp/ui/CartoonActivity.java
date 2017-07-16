package com.example.tarena.ireader_myapp.ui;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.tarena.ireader_myapp.Adapter.CartoonAdapter;
import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.entity.Cartoon;
import com.example.tarena.ireader_myapp.manager.HttpCartoonManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartoonActivity extends AppCompatActivity {
RecyclerView recyclerView_Cartoon;
    List<Cartoon.Result.BookList> cartoons=null;
    @BindView(R.id.imageView_cartoon_back)
    ImageView ivBack;
    private CartoonAdapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartoon);
        ButterKnife.bind(this);
        LoadCartoon();
        initialUI();


    }
    private void initialUI() {
   recyclerView_Cartoon= (RecyclerView) findViewById(R.id.recyclerView_Cartoon);
        //定义一个布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_Cartoon.setLayoutManager(layoutManager);
        adapter=new CartoonAdapter(this);
        recyclerView_Cartoon.setAdapter(adapter);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    private void LoadCartoon() {

        HttpCartoonManager.LoadCartoon(this, new HttpCartoonManager.CartoonLoadListener() {

            @Override
            public void onCartoonLoadEnd(Cartoon cartoon) {
                cartoons=new ArrayList<>();
                cartoons=cartoon.getResult().getBookList();
                adapter.addCartoon(cartoons);
            }
        });
    }
}
