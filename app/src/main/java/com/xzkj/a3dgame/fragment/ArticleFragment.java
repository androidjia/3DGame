package com.xzkj.a3dgame.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xzkj.a3dgame.R;
import com.xzkj.a3dgame.adapter.ListViewAdapter;
import com.xzkj.a3dgame.adapter.MainArticleFramentViewPagerAdapter;
import com.xzkj.a3dgame.customview.MainArticleFragmentViewPager;
import com.xzkj.a3dgame.javadao.News;
import com.xzkj.a3dgame.uitls.UpdateInsert;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class ArticleFragment extends Fragment {
    //定义文章类型
    private  int typeid;
    List<News> data = null;
    ListView lv;
    List<HashMap<String,Object>> list;
    ListViewAdapter adapter;
    private UpdateInsert updateInsert;

    MainArticleFramentViewPagerAdapter mainArticleFramentViewPagerAdapter;
    public ArticleFragment(){}
    public ArticleFragment(int typeid){
        this.typeid=typeid;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取Fragment中的整体布局
        View view = inflater.inflate(R.layout.activity_main_articlefragment,null);
        //获取Fragment中的ViewPager
        MainArticleFragmentViewPager  mainArticleFragmentViewPager = (MainArticleFragmentViewPager) view.findViewById(R.id.main_articlefragment_viewpager);
        int imageRsId[] = {R.drawable.default1,R.drawable.default2,R.drawable.default3};
        //初始化ViewPager的数据
        List<ImageView> imageViews = new ArrayList<>();
        for (int i=0;i<3;i++){
            ImageView imageView = new ImageView(getActivity());
            //设置图片的缩放类型 铺满全屏
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(imageRsId[i]);
            imageViews.add(imageView);
        }
        mainArticleFramentViewPagerAdapter = new MainArticleFramentViewPagerAdapter(imageViews);
        mainArticleFragmentViewPager.setAdapter(mainArticleFramentViewPagerAdapter);
        //TextView tv = (TextView) view.findViewById(R.id.activity_main_articlefragment_tv);
        //tv.setText(typeid+"");

        updateInsert = new UpdateInsert(getContext());
        lv = (ListView) view.findViewById(R.id.ativity_main_articlefragment_lv);
        data = updateInsert.getAllStudentList();
        list = new ArrayList<>();
        for(News news:data){
            String title = news.getTitle();
            String litpic = news.getLitpic();
            File file = new File(litpic);
            if (file.exists()){
                Bitmap bitmap = BitmapFactory.decodeFile(litpic);
                HashMap<String,Object> map = new HashMap<>();
                map.put("title",title);
                map.put("bitmap",bitmap);
                list.add(map);
            }else {
                Log.i("aaa","图片无法取出");
            }
        }
        adapter = new ListViewAdapter(getContext(),list);
        lv.setAdapter(adapter);

        return view;
    }
}
