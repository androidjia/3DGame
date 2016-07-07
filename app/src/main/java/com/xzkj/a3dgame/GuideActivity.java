package com.xzkj.a3dgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xzkj.a3dgame.adapter.GuideViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    ViewPager guideviewPager;
    GuideViewPagerAdapter guideViewPagerAdapter;
    List<View> views;
    ImageView[] dots;
    int currentIndex;//当前的页面索引
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initDot();
    }
    private void initView(){
        guideviewPager = (ViewPager) findViewById(R.id.guide_viewpager);
        views = new ArrayList<>();
        View view1 = LayoutInflater.from(this).inflate(R.layout.guidepage01,null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.guidepage02,null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.guidepage03,null);
        views.add(view1);
        views.add(view2);
        views.add(view3);
        guideViewPagerAdapter = new GuideViewPagerAdapter(views);
        guideviewPager.setAdapter(guideViewPagerAdapter);
        guideviewPager.addOnPageChangeListener(this);
    }
    private void initDot(){
        LinearLayout ll = (LinearLayout) findViewById(R.id.guide_dot_ll);
        dots = new ImageView[views.size()];
        for (int i=0;i<views.size();i++){
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(true);
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(false);
    }

    private void setGuide(){
        SharedPreferences sharedPreferences = getSharedPreferences("isFistLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLogin",true);
        editor.commit();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //设置底部显示点的颜色
        if (position<0||position+1>views.size()){
            return;
        }
        //设置当前位置为选中状态
        dots[position].setEnabled(false);
        //设置之前的为非选中状态
        dots[currentIndex].setEnabled(true);
        currentIndex = position;

        //添加最后一个引导界面的监听
        if (position==views.size()-1){
            Button button = (Button) views.get(position).findViewById(R.id.page03_btn);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //保存一个登陆的记录
                    setGuide();
                    Intent mainIntent = new Intent(GuideActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            });
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
