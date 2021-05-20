package com.example.study;


import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //不显示当前页面标题栏
        setContentView(R.layout.activity_my); // 指定当前窗口的布局文件

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout);

        linearLayout.setBackgroundResource(R.drawable.bg); //设置背景图

        final Intent intent = new Intent(MyActivity.this,MainActivity.class);
        //如果之前启动过这个Activity，并还没有被销毁的话，无论是否存在都重新启动新的窗口
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        //创建一个新的线程来显示欢迎动画，指定时间后结束，跳转至指定界面
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000); //用线程暂停3秒来模拟做了一个耗时3s的检测操作

                    // 获取应用的上下文，生命周期是整个应用，应用结束后才会结束
                    getApplicationContext().startActivity(intent);
                    finish(); //结束本欢迎画面
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
