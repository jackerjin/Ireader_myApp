//package com.example.tarena.ireader_myapp.siftchild;
//
//import android.graphics.Color;
//import android.os.PersistableBundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.LoaderManager;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseExpandableListAdapter;
//import android.widget.ExpandableListAdapter;
//import android.widget.ExpandableListView;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.tarena.ireader_myapp.Adapter.MyBookRankAdapter;
//import com.example.tarena.ireader_myapp.R;
//import com.example.tarena.ireader_myapp.entity.BookRank;
//import com.example.tarena.ireader_myapp.manager.HttpBookRankManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BookRankActivity extends AppCompatActivity {
//     ListView listView;
//     MyBookRankAdapter adapter = null;
//   List<BookRank.ResultBean.GetRankTypeRspBean> bookRanks;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_book_rank);
//        LoadBookRank();
//        initialUI();
//
//    }
//
//    private void initialUI() {
//        listView = (ListView) findViewById(R.id.listView_bookRank);
//
////        listView.setCacheColorHint(Color.RED);
//
//        adapter = new MyBookRankAdapter(BookRankActivity.this);
//        listView.setAdapter(adapter);
//
//
//
//    }
//
//    private void LoadBookRank() {
//        HttpBookRankManager.LoadBookRankFromHttp(this, new HttpBookRankManager.BookRankLoadListener() {
//            @Override
//            public void onBookRanKLoadEnd(BookRank bookRank) {
//                Log.i("TAG",bookRank.getResult().getGetRankTypeRsp().getRankList().toString());
//
//                bookRanks = new ArrayList<BookRank.ResultBean.GetRankTypeRspBean>();
//
//                 bookRanks = (List<BookRank.ResultBean.GetRankTypeRspBean>) bookRank.getResult().getGetRankTypeRsp().getRankList();
//                adapter.addBookRankAdapter(bookRanks);
//
//            }
//        });
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//}
//    //
////    private String[] groups={"本地音乐","最近播放","下载管理","我的电台","我的收藏"};
////    private String[][] childs={{"凉凉","安静了"},{"原因我"},{"凉凉","安静了"},{"FM876","FM900"},{"秋城"}};
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_book_rank);
////        ExpandableListView expandableListView= (ExpandableListView) findViewById(R.id.expandId);
////        //构建适配器
////        ExpandableListAdapter adapter=new InnerExpandableListAdapter();
////        //关联适配器
////        expandableListView.setAdapter(adapter);
////        //创建监听器
////        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
////            @Override
////            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
////                Toast.makeText(BookRankActivity.this,childs[groupPosition][childPosition],Toast.LENGTH_SHORT).show();
////                return false;
////            }
////        });
////    }
////    class InnerExpandableListAdapter extends BaseExpandableListAdapter {
////
////
////        @Override
////        public int getGroupCount() {
////            return groups.length;
////        }
////
////        @Override
////        public int getChildrenCount(int groupPosition) {
////            return childs[groupPosition].length
////                    ;
////        }
////
////        @Override
////        public Object getGroup(int groupPosition) {
////            return groups[groupPosition];
////        }
////
////        @Override
////        public Object getChild(int groupPosition, int childPosition) {
////            return childs[childPosition];
////        }
////
////        @Override
////        public long getGroupId(int groupPosition) {
////            return groupPosition;
////        }
////
////        @Override
////        public long getChildId(int groupPosition, int childPosition) {
////            return groupPosition;
////        }
////        /*此方法确定返回值是否稳定*/
////        @Override
////        public boolean hasStableIds() {
////            return false;
////        }
////
////        @Override
////        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
////            //1 item view
////            TextView textView= (TextView) LayoutInflater.from(parent.getContext())
////                    .inflate(android.R.layout.simple_expandable_list_item_1,parent,false);
////            //2 item data
////            String item=groups[groupPosition];
////            //3bind data
////            textView.setText(item);
////            return textView;
////        }
////
////        @Override
////        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
////            TextView textView= (TextView) LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
////            String item=childs[groupPosition][childPosition];
////            textView.setText(item);
////            return textView;
////        }
////
////        @Override
////        public boolean isChildSelectable(int groupPosition, int childPosition) {
////            return true;
////        }
////    }
//
