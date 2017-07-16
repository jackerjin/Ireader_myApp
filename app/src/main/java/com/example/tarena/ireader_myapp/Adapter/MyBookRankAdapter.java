package com.example.tarena.ireader_myapp.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.entity.BookRank;

import java.util.ArrayList;
import java.util.List;

import static com.example.tarena.ireader_myapp.entity.BookRank.ResultBean.*;

/**
 * 构建排行榜适配器
 * Created by tarena on 2017/6/9.
 */

public class MyBookRankAdapter extends BaseAdapter {
    private List<BookRank.ResultBean.GetRankTypeRspBean> bookRankList=new ArrayList<>();
    Context context;
    public MyBookRankAdapter(Context context){
        this.context=context;
    }
    public void addBookRankAdapter(List<BookRank.ResultBean.GetRankTypeRspBean> bookRanks){
        if (bookRanks!=null){
            bookRankList.addAll(bookRanks);
            notifyDataSetChanged();
        }
    }

    public MyBookRankAdapter() {
    }

    @Override
    public int getCount() {
        return bookRankList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookRankList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (holder==null){
            convertView=View.inflate(context, R.layout.include_bookrank_item_layout,null);
            holder=new ViewHolder();
            holder.textView_RankList= (TextView) convertView.findViewById(R.id.tv_RankList);
            holder.textView_RankTimeList= (TextView) convertView.findViewById(R.id.tv_RankTimeList);
            holder.textView_ContentTypeList= (TextView) convertView.findViewById(R.id.tv_ContentTypeList);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        BookRank bookRank=new BookRank();
        holder.textView_RankList.setText(bookRank.getResult().getGetRankTypeRsp().getRankList().toString());
        holder.textView_RankTimeList.setText(bookRank.getResult().getGetRankTypeRsp().getRankTimeList().toString());
        holder.textView_ContentTypeList.setText(bookRank.getResult().getGetRankTypeRsp().getContentTypeList().toString());
        return convertView;
    }
    public static class ViewHolder{
        TextView textView_RankList;
        TextView textView_RankTimeList;
        TextView textView_ContentTypeList;
    }
}
