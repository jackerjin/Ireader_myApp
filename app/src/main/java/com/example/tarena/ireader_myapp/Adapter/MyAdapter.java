package com.example.tarena.ireader_myapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarena.ireader_myapp.R;


/**
 * Created by tarena on 2017/5/23.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;
    private int[] mImages;
    //借助holder对象记录item中view元素的位置
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;



        public ViewHolder(View view) {
            super(view);
            mImageView= (ImageView) view.findViewById(R.id.imageviewId);
            mTextView = (TextView) view.findViewById(R.id.textviewId);
        }
    }

    public MyAdapter(String[] myDataset,int[] images) {
        mDataset = myDataset;
        mImages=images;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item, parent, false);

        return new ViewHolder(view);
    }

    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
        holder.mImageView.setImageResource(mImages[position]);
    }

    @Override
    public int getItemCount() {

        return mDataset.length;
    }
}