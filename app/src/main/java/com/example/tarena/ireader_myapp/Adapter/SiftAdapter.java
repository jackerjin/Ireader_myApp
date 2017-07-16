package com.example.tarena.ireader_myapp.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.entity.Sift;
import com.example.tarena.ireader_myapp.manager.HttpCartoonManager;
import com.example.tarena.ireader_myapp.manager.HttpSiftManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tarena on 2017/7/5.
 */

public class SiftAdapter extends MyBaseAdapter<Sift.ResultBean.GetSpecifiedRankRspBean.RankContentListBean.RankContentBean> {

    public SiftAdapter(Context context, List<Sift.ResultBean.GetSpecifiedRankRspBean.RankContentListBean.RankContentBean> datas) {
        super(context, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.sift_listview_item,parent,false);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }

       Sift.ResultBean.GetSpecifiedRankRspBean.RankContentListBean.RankContentBean rankContent=getItem(position);
        //呈现图片
        String url= rankContent.getCoverUrl();
//        holder.imageView_Header.setImageURI(url, Volley.get);
        HttpSiftManager.LoadImage(url,vh.ivPic);
//        HttpCartoonManager.LoadImage(url,vh.ivPic);
        vh.tvTitle.setText(rankContent.getContentName());
        vh.tvAuther.setText(rankContent.getAuthorName());
        vh.tvClickCount.setText(rankContent.getClickCount()+"");
        vh.tvFavorCount.setText(rankContent.getFavoriteCount());
        //TODO 距离 vh.tvDistance.setText("xxxx");
        return convertView;
    }
    public class ViewHolder{
        @BindView(R.id.iv_sift_albumpic)
        ImageView ivPic;
        @BindView(R.id.tv_sift_name)
        TextView tvTitle;
        @BindView(R.id.tv_sift_author)
        TextView tvAuther;
        @BindView(R.id.tv_sift_count)
        TextView tvClickCount;
        @BindView(R.id.tv_sift_favorCount)
        TextView tvFavorCount;


        public ViewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }
}
