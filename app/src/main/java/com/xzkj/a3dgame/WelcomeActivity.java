package com.xzkj.a3dgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Toast;

import com.xzkj.a3dgame.service.DownloadService;
import com.xzkj.a3dgame.uitls.NetUtils;

import pl.droidsonroids.gif.GifImageView;

public class WelcomeActivity extends AppCompatActivity {
    GifImageView gifImageView ;
    Animation animation;
    //判断网络是否打开
    boolean netOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        gifImageView = (GifImageView) findViewById(R.id.welcome_gif);
        //添加一个动画
        animation = new AlphaAnimation(0,1.0f);
        animation.setDuration(3000);
        gifImageView.startAnimation(animation);
        //给动画添加监听
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //判断网络
                netOpen = NetUtils.netConnect(WelcomeActivity.this);
                if (netOpen){
                    //开始service下载数据
                    Intent downloadServiceIntent = new Intent(WelcomeActivity.this,DownloadService.class);
                    startService(downloadServiceIntent);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!netOpen){
                    Toast.makeText(WelcomeActivity.this,"请连接网络",Toast.LENGTH_SHORT).show();
                }
                isFristLogin();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    private void isFristLogin(){
        //创建sharedPreferences对象
        SharedPreferences sharedPreferences = getSharedPreferences("isFistLogin", Context.MODE_PRIVATE);
        //获取sharedPreferences对象中的isLogin属性
        boolean isLogin = sharedPreferences.getBoolean("isLogin",false);
        //如果第一次登陆，就跳转到引导界面，否则的话跳转到主界面
        if (!isLogin){
            Intent guideIntent = new Intent(WelcomeActivity.this,GuideActivity.class);
            startActivity(guideIntent);
            finish();
        }else {
            Intent mainIntent = new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(mainIntent);
            finish();
        }

    }
}
