package com.example.tarena.ireader_myapp.Fragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tarena.ireader_myapp.R;


/**
 * Created by tarena on 2017/5/18.
 */

public abstract class BaseFragment extends Fragment {
    protected LinearLayout actionbar;
    protected View contentView=null;
    //定义一个方法实现对标题三个控件的初始化设置
    public void initialActionbar(int leftId,String title,int rightId){
        if (actionbar==null){
            return;
        }
        //获得标题栏当中的各个控件
        ImageView imageView_left= (ImageView) actionbar.findViewById(R.id.image_acitonBar_id);
        TextView textView_title= (TextView) actionbar.findViewById(R.id.textView_title_id);
        ImageView imageView_right= (ImageView) actionbar.findViewById(R.id.image_acitonBar_search_id);
        //如果第一个参数小于等0说明左边图不显示
        if (leftId<=0){
            imageView_left.setVisibility(View.INVISIBLE);
        }else{
            imageView_left.setVisibility(View.VISIBLE);
            imageView_left.setImageResource(leftId);
        }
        if (TextUtils.isEmpty(title)){
            textView_title.setVisibility(View.INVISIBLE);
        } else {
            textView_title.setVisibility(View.VISIBLE);
            textView_title.setText(title);
        }
        if (rightId<=0){
            imageView_right.setVisibility(View.INVISIBLE);
        }else {
            imageView_right.setVisibility(View.VISIBLE);
            imageView_right.setImageResource(rightId);
        }

    }
    public abstract void initialUI();

}
