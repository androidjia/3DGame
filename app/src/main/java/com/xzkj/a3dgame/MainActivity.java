package com.xzkj.a3dgame;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.xzkj.a3dgame.adapter.MainFragmentPagerAdapter;
import com.xzkj.a3dgame.fragment.ArticleFragment;
import com.xzkj.a3dgame.fragment.ForumFragment;
import com.xzkj.a3dgame.fragment.GameFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{
    HorizontalScrollView horizontalScrollView;
    RadioGroup radioGroup_top;
    RadioButton rb01_top,rb02_top,rb03_top,rb04_top,rb05_top,rb06_top,rb07_top,rb08_top,rb09_top,rb10_top;
    ViewPager viewPager;
    RadioGroup radioGroup_bottom;
    RadioButton rb01_buttom,rb02_buttom,rb03_buttom;
    List<Fragment> fragments;
    MainFragmentPagerAdapter mainFragmentPagerAdapter;
    GameFragment gameFragment;
    FragmentManager fragmentManager;
    ForumFragment forumFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
        gameFragment = new GameFragment(getApplicationContext());
        forumFragment = new ForumFragment();
    }
    private void initListener(){
        radioGroup_top.setOnCheckedChangeListener(this);
        radioGroup_bottom.setOnCheckedChangeListener(this);
        viewPager.addOnPageChangeListener(this);
    }
    private void initData(){
        fragments = new ArrayList<>();
        ArticleFragment f1 = new ArticleFragment(1);
        ArticleFragment f2 = new ArticleFragment(2);
        ArticleFragment f3 = new ArticleFragment(3);
        ArticleFragment f4 = new ArticleFragment(4);
        ArticleFragment f5 = new ArticleFragment(5);
        ArticleFragment f6 = new ArticleFragment(6);
        ArticleFragment f7 = new ArticleFragment(7);
        ArticleFragment f8 = new ArticleFragment(8);
        ArticleFragment f9 = new ArticleFragment(9);
        ArticleFragment f10 = new ArticleFragment(10);
        fragments.add(f1);
        fragments.add(f2);
        fragments.add(f3);
        fragments.add(f4);
        fragments.add(f5);
        fragments.add(f6);
        fragments.add(f7);
        fragments.add(f8);
        fragments.add(f9);
        fragments.add(f10);

        mainFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(mainFragmentPagerAdapter);
    }
    //初始化所有的控件
    private void initView(){
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.main_top_hsv);
        radioGroup_top = (RadioGroup) findViewById(R.id.main_top_rg);
        viewPager = (ViewPager) findViewById(R.id.main_center_vp);
        radioGroup_bottom = (RadioGroup) findViewById(R.id.main_buttom_rg);
        rb01_buttom = (RadioButton) findViewById(R.id.main_buttom_rb01);
        rb02_buttom = (RadioButton) findViewById(R.id.main_buttom_rb02);
        rb03_buttom = (RadioButton) findViewById(R.id.main_buttom_rb03);
        rb01_top = (RadioButton) findViewById(R.id.main_top_rb1);
        rb02_top = (RadioButton) findViewById(R.id.main_top_rb2);
        rb03_top = (RadioButton) findViewById(R.id.main_top_rb3);
        rb04_top = (RadioButton) findViewById(R.id.main_top_rb4);
        rb05_top = (RadioButton) findViewById(R.id.main_top_rb5);
        rb06_top = (RadioButton) findViewById(R.id.main_top_rb6);
        rb07_top = (RadioButton) findViewById(R.id.main_top_rb7);
        rb08_top = (RadioButton) findViewById(R.id.main_top_rb8);
        rb09_top = (RadioButton) findViewById(R.id.main_top_rb9);
        rb10_top = (RadioButton) findViewById(R.id.main_top_rb10);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (i){
            case R.id.main_top_rb1:
                viewPager.setCurrentItem(0);
                Toast.makeText(MainActivity.this,"top rb01",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb2:
                viewPager.setCurrentItem(1);
                Toast.makeText(MainActivity.this,"top rb02",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb3:
                viewPager.setCurrentItem(2);
                Toast.makeText(MainActivity.this,"top rb03",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb4:
                viewPager.setCurrentItem(3);
                Toast.makeText(MainActivity.this,"top rb04",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb5:
                viewPager.setCurrentItem(4);
                Toast.makeText(MainActivity.this,"top rb05",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb6:
                viewPager.setCurrentItem(5);
                Toast.makeText(MainActivity.this,"top rb06",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb7:
                viewPager.setCurrentItem(6);
                Toast.makeText(MainActivity.this,"top rb07",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb8:
                viewPager.setCurrentItem(7);
                Toast.makeText(MainActivity.this,"top rb08",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb9:
                viewPager.setCurrentItem(8);
                Toast.makeText(MainActivity.this,"top rb09",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_top_rb10:
                viewPager.setCurrentItem(9);
                Toast.makeText(MainActivity.this,"top rb10",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_buttom_rb01:
                transaction.remove(gameFragment);
                transaction.remove(forumFragment);
                transaction.commit();
                viewPager.setCurrentItem(0);
                Toast.makeText(MainActivity.this,"rb01",Toast.LENGTH_SHORT).show();
                horizontalScrollView.smoothScrollTo(0,0);
                break;
            case R.id.main_buttom_rb02:
                Toast.makeText(getApplicationContext(),"论坛界面",Toast.LENGTH_SHORT).show();
                transaction.replace(R.id.activity_main_fragment1,forumFragment);
                transaction.commit();
                break;
            case R.id.main_buttom_rb03:
                Toast.makeText(getApplicationContext(),"游戏界面",Toast.LENGTH_SHORT).show();
               transaction.replace(R.id.activity_main_fragment1,gameFragment);
               transaction.commit();

                break;

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //顶部移动条出现滚动效果
        horizontalScrollView.setVisibility(View.VISIBLE);
        radioGroup_top.setVisibility(View.VISIBLE);
        //获得当前ViewPager对应的RadioButton
        RadioButton radioButton = (RadioButton) radioGroup_top.getChildAt(position);
        radioButton.setChecked(true);
        //让顶部的RadioButton随着ViewPager一起滚动
        int left = radioButton.getLeft();
        horizontalScrollView.smoothScrollTo(left,0);
    }
    @Override
    public void onPageScrollStateChanged(int state) {
    }

}
