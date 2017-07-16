package com.tarena.jin.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tarena.jin.R;

/**
 * Created by tarena on 2017/5/23.
 */

public class MyStackAdapter extends RecyclerView.Adapter<MyStackAdapter.ViewHolder> {
    private String[] mDataset;
    private int[] mImages;
    private int[] mImages1;
    //借助holder对象记录item中view元素的位置
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public ImageView mImageView;
        public ImageView mImageView1;



        public ViewHolder(View view) {
            super(view);
            mImageView= (ImageView) view.findViewById(R.id.imageview_stack);
            mImageView1=(ImageView) view.findViewById(R.id.imageview_stack1);
            mTextView = (TextView) view.findViewById(R.id.textviewId);
        }
    }

    public MyStackAdapter(String[] myDataset, int[] images,int[] mimages1) {
        mDataset = myDataset;
        mImages=images;
        mImages1=mimages1;
    }

    @Override
    public MyStackAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item_stack, parent, false);

        return new ViewHolder(view);
    }

    public void onBindViewHolder(MyStackAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
        holder.mImageView.setImageResource(mImages[position]);
        holder.mImageView1.setImageResource(mImages1[position]);
    }

    @Override
    public int getItemCount() {

        return mDataset.length;
    }
}