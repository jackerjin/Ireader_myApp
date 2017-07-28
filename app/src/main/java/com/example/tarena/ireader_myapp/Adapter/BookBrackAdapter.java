package com.example.tarena.ireader_myapp.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.entity.BookBrack;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

//Created by tarena on 2017/6/20.


public class BookBrackAdapter extends RecyclerView.Adapter<BookBrackAdapter.MyViewHolder>{
Context context;
    List<BookBrack> datas;
    LayoutInflater inflater;

    public BookBrackAdapter(Context context,List<BookBrack> datas) {
        this.datas=datas;
        this.context=context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_bookbrack_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        if (holder!=null){
//            return;
//        }
        BookBrack bookBrack = datas.get(position);
        holder.tvTitle.setText(bookBrack.getTitle());
       Picasso.with(context).load(bookBrack.getImg_url()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
    //利用butterknife完成对viewholder的赋值
    @Nullable
    @BindView(R.id.bookbrack_item_title)
    TextView tvTitle;
    @Nullable
    @BindView(R.id.bookbrack_item_img)
    ImageView avatar;

    public MyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
public interface OnItemClickListener{
    void OnItemClick(View itemView,int position);
}


    public void addAll(List<BookBrack> list,boolean isClear){
        if (isClear){
            datas.clear();
        }
        datas.addAll(list);
        notifyDataSetChanged();
    }
}
