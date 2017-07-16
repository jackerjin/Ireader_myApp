//package com.example.tarena.ireader_myapp.Adapter;
//
//import android.content.Context;
//import android.util.TypedValue;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.ViewTreeObserver;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.example.tarena.ireader_myapp.R;
//import com.example.tarena.ireader_myapp.entity.Comment;
//
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
///**
// * Created by tarena on 2017/6/28.
// */
//
//public class CommentAdapter extends MyBaseAdapter<Comment> {
//    public CommentAdapter(Context context, List<Comment> datas) {
//        super(context, datas);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        final ViewHolder holder;
//        if (convertView == null) {
//            convertView = inflater.inflate(R.layout.bookbrack_item_jsoup_layout, parent, false);
//            holder = new ViewHolder(convertView);
//            holder.llContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//                @Override
//                public void onGlobalLayout() {
//                    int width = holder.llContainer.getWidth();
//                    int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, context.getResources().getDisplayMetrics());
//                    int size = (width - 2 * margin) / 3;
//                    for (int i = 0; i < holder.llContainer.getChildCount(); i++) {
//                        ImageView iv = (ImageView) holder.llContainer.getChildAt(i);
//                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
//                        if (i != 0) {
//                            params.setMargins(margin, 0, 0, 0);
//                        }
//                        iv.setLayoutParams(params);
//                        iv.setScaleType(ImageView.ScaleType.FIT_XY);
//
//                    }
//                    holder.llContainer.requestLayout();
//                }
//            });
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        Comment comment = getItem(position);
//        HttpUtil.loadImage(comment.getAvatar(), holder.ivAvatar);
//        holder.tvName.setText(comment.getName());
//        holder.tvDate.setText(comment.getDate());
//        holder.tvPrice.setText(comment.getPrice());
//
//
//        holder.ivRating.setImageResource(resIds[resId]);
//
//        holder.tvContent.setText(comment.getContent());
//
//        return convertView;
//    }
//
//
//
//   public class ViewHolder {
//        @BindView(R.id.iv_bb_item_header)
//        ImageView ivBbItemHeader;
//        @BindView(R.id.iv_bb_item_introduce)
//        TextView ivBbItemIntroduce;
//        @BindView(R.id.tv_bb_item_count)
//        TextView tvBbItemCount;
//
//        ViewHolder(View view) {
//            ButterKnife.bind(this, view);
//        }
//    }
//}
