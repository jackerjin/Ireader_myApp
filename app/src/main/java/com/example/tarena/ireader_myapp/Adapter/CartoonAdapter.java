package com.example.tarena.ireader_myapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tarena.ireader_myapp.R;
import com.example.tarena.ireader_myapp.entity.Cartoon;
import com.example.tarena.ireader_myapp.manager.HttpCartoonManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarena on 2017/6/13.
 */

public class CartoonAdapter extends RecyclerView.Adapter<CartoonAdapter.ViewHolder> {
    public Context context;
    private List<Cartoon.Result.BookList> cartoons = new ArrayList<>();

    public CartoonAdapter(Context context) {
        this.context = context;
    }
    //实现对天气数据集合的访问
    public void addCartoon(List<Cartoon.Result.BookList> cartoonlist) {
        if (cartoonlist!=null) {
            //在添加数据
            cartoons.addAll(cartoonlist);
            notifyDataSetChanged();
        }

    }
    @Override
    public CartoonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder=null;
        View view= LayoutInflater.from(context).inflate(R.layout.include_cartoon_layout,parent,false);
        holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(CartoonAdapter.ViewHolder holder, int position) {
    Cartoon.Result.BookList bookList=cartoons.get(position);
        String name=bookList.getName();
        String type=bookList.getType();
        String area=bookList.getArea();
        boolean finish=bookList.isFinish();
        if (finish){
            holder.textView_Finish.setText("完结");
        }else {
            holder.textView_Finish.setText("未完结");
        }
        String update= String.valueOf(bookList.getLastUpdate());

        holder.textView_Name.setText(name);
        holder.textView_Area.setText(area);
        holder.textView_Type.setText(type);
        if (update!=null){holder.textView_Lastupdate.setText(update);}else {
            holder.textView_Lastupdate.setText(" ");
        }
        //设置未加载的图片
//        holder.imageView_Header.setDefaultImageResId(R.drawable.default_icon);
        String url= bookList.getCoverImg();
//        holder.imageView_Header.setImageURI(url, Volley.get);
       HttpCartoonManager.LoadImage(url,holder.imageView_Header);

    }

    @Override
    public int getItemCount() {
        return cartoons.size();
    }

    //自定义一个viewholder类，实现控件的封装
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView_Header;
        TextView textView_Name;
        TextView textView_Type;
        TextView textView_Finish;
        TextView textView_Area;
        TextView textView_Lastupdate;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView_Header= (ImageView) itemView.findViewById(R.id.iv_cartoonList_albumpic);
            textView_Name= (TextView) itemView.findViewById(R.id.tv_cartoonList_name);
            textView_Type= (TextView) itemView.findViewById(R.id.tv_cartoonList_type);
            textView_Finish= (TextView) itemView.findViewById(R.id.tv_cartoonList_finish);
            textView_Area= (TextView) itemView.findViewById(R.id.tv_cartoonList_area);
            textView_Lastupdate= (TextView) itemView.findViewById(R.id.tv_cartoonList_update);
        }
    }
}
