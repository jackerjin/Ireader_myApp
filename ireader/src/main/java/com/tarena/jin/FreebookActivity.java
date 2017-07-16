package com.tarena.jin;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FreebookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freebook);
    }
    public void onClick01(View v){
        //1创建异步任务
        DomnAsyncTask task=new DomnAsyncTask(v);
        //2启动异步任务
        //task.execute();//顺序执行
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);//并发执行

    }
    public void onClick02(View v){
        //1创建异步任务
        DomnAsyncTask task=new DomnAsyncTask(v);
        //2启动异步任务
        //  task.execute();
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
//class DownAsyncTask extends AsyncTask<Void,Void,String> {
//    private View mView;
//    public DownAsyncTask(View view){
//        mView=view;
//    }
//    //此方法运行在工作线程
//    @Override
//    protected String doInBackground(Void... params) {
//        //模拟下载过程
//        for(int i=0;i<=100;i++){
//            try{Thread.sleep(200);}catch (Exception e){}
//        }
//        return "down-ok";
//    }//void
//
//    /**此方法运行于主线程，用于处理doInbackGround方法的返回结果*/
//    @Override
//    protected void onPostExecute(String result) {
//        super.onPostExecute(result);
//        if(mView!=null&&mView instanceof Button){
//            ((Button) mView).setText(result);
//        }
//    }
//}}
class DomnAsyncTask extends AsyncTask<Void,Integer,String>{
    private View mView;
    public DomnAsyncTask(View view){
        mView=view;
    }
    /**此方法运行于主线程，在doInbackground方法之前，一般用于初始化*/
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //设置按钮不可点击
        mView.setEnabled(false);
    }
    //此方法运行在工作线程(此方法在父类中是抽象方法)

    @Override
    protected String doInBackground(Void... params) {
        //模拟下载过程
        for (int i=0;i<=100;i++){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } //此方法的作用主要用于发布进度
            //进度发布以后会由底层系统调用onProgressUpdate
            publishProgress(i);
        }
        return "down-ok";
    }//void
    /**此方法运行于主线程中，用于更新进度*/
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        MyButton mybtn= (MyButton) mView;
        mybtn.setProgress(values[0]*1.0f/100);
        mybtn.invalidate();
        mybtn.setText(values[0]+"%");
    }

    /**此方法运行于主线程，用于处理doInbackGround方法的返回结果，用于更新UI*/
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (mView!=null&&mView instanceof Button){//判断对象类型
            ((Button) mView).setText(s);
        }
    }
}
}