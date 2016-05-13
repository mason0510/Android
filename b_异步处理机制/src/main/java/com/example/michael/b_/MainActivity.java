package com.example.michael.b_;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);// 创建ProgressDialog对象
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条风格，风格为圆形，旋转的
        progressDialog.setTitle("提示");// 设置ProgressDialog 标题
        progressDialog.setMessage("这是一个圆形进度条对话框");// 设置ProgressDialog提示信息
        progressDialog.setIcon(R.drawable.icon);// 设置ProgressDialog标题图标
             // 设置ProgressDialog 的进度条是否不明确 false 就是不设置为不明确
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true); // 设置ProgressDialog 是否可以按退回键取消
       // progressDialog.setButton("确定", new Bt1DialogListener()); // 设置ProgressDialog 的一个Button
        progressDialog.show(); // 让ProgressDialog显示
//        new DownloadTask().execute();//执行
    }
    class DownloadTask extends AsyncTask<Void,Integer,Boolean>{//背后的进程


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
          //  progressDialog.show();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            progressDialog.dismiss();
            //在主线程运行
            if(aBoolean){
                Toast.makeText(getApplicationContext(),"下载完了",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(getApplicationContext(),"下载失败",Toast.LENGTH_LONG).show();
            }
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //在这里更新下载
            progressDialog.setMessage(values[0]+"100");
        }
        @Override
        protected Boolean doInBackground(Void... params) {//下载的逻辑
            try{
                while(true){
                    //执行下载任务
                    int downloadPercent=doDownload();
                    publishProgress(downloadPercent);
                    if(downloadPercent>=100){
                        break;
                    }
                }
            }catch(Exception e){
                return false;
            }


            return true;
        }
    }
    public int doDownload(){
        return 100;
    }
}
