package com.tarena.jin.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tarena.jin.MainActivity;
import com.tarena.jin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SiftFragment extends BaseFragment {
    private String[] names = {"父亲决定孩子的一生", "谁都不敢欺负你", "青春", "人海沉浮录", "苏轼墨迹", "我的阅读"};
    private int[] images = {R.mipmap.fuqinjuedinghaizideyisheng, R.mipmap.shuidoubuganqifuni,
            R.mipmap.shuku6, R.mipmap.renhaichenfulu, R.mipmap.sushimoji, R.mipmap.wodeyuedu};


    public SiftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sift, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.sift_gridviewId);
        ImageView imageView_Sift = (ImageView) view.findViewById(R.id.sift_toolbar_user_id);
        ImageAdapter imageAdapter = new ImageAdapter();
        gridView.setAdapter(imageAdapter);
        imageView_Sift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.show();
            }
        });

        return view;
    }

    class ImageAdapter extends BaseAdapter {
        /**
         * 返回要构建的item的个数
         */
        @Override
        public int getCount() {
            return images.length;
        }

        /**
         * 返回当前position位置的item上的数据
         */
        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         * Adapter的作用是什么？构建item的一个工厂
         * Adapter通过哪个方法构建item呢？getView方法
         *
         * @param position    代表要构建的item的位置
         * @param convertView 代表一个可重用的item 列表项对象
         * @param parent      代表一个容器，要呈现item的那个容器
         *                    <p>
         *                    getView方法实现的功能类似包饺子
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Log.i("TAG", "getView.convertView=" + convertView);
            View v = null;
            ViewHolder viewHolder;
            //根据图纸(R.layout.grid_item_01)构建饺子皮对象
            //方法一在imageview布局文件显示
            if (convertView == null) {
                v = View.inflate(getActivity(),
                        R.layout.sift_imageview, null);
                viewHolder=new ViewHolder();
                viewHolder.imageView= (ImageView) v.findViewById(R.id.imageviewId);
                viewHolder.textView= (TextView) v.findViewById(R.id.textviewId);
                //建立itemview与viewholder的关系
                v.setTag(viewHolder);
            } else {
                v = convertView;
                viewHolder= (ViewHolder) v.getTag();
            }
            //方法二创建imageview对象显示图片
            //ImageView imageView=new ImageView(MainActivity.this);
            // imageView.setPadding(16,16,16,16);
            //2.item data (部分饺子馅)
            int imgResId = images[position];
            String name = names[position];
//            // 3.bind data(将饺子馅放到皮包起来)
//            ImageView imageView = (ImageView) v.findViewById(R.id.imageviewId);
//            TextView textView = (TextView) v.findViewById(R.id.textviewId);
            //imageView.setImageResource(imgResId);
            //textView.setText(name);

            viewHolder.imageView.setImageResource(imgResId);
            viewHolder.textView.setText(name);
            return v;
        }

        class ViewHolder {
            //一个对象考属性存储数据
            //牺牲空间（占内存），赢得时间
            ImageView imageView;
            TextView textView;

        }
    }

    @Override
    public void initialUI() {
//        actionbar= (LinearLayout) contentView.findViewById(R.id.sift_toolbar);
//        initialActionbar(-1,"短信息",-1);
    }
}
