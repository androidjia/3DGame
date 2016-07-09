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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.xzkj.a3dgame.R;
import com.xzkj.a3dgame.adapter.GameFragmentAdapter;
import com.xzkj.a3dgame.javadao.News;
import com.xzkj.a3dgame.uitls.UpdateInsert;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/7/7.
 */
public class GameFragment extends Fragment {
    List<News> data;
    UpdateInsert updateInsert;
    Context context;
    //SimpleAdapter simpleAdapter ;
    List<HashMap<String,Object>> list;
    GridView gridView ;
    Spinner spinner;
    GameFragmentAdapter gameFragmentAdapter;
    public GameFragment(Context context){
        this.context = context;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.activity_main_gamefragment,null);
        gridView = (GridView) view.findViewById(R.id.main_fragment_gridview);
        //获取list集合数据
        spinner = (Spinner) view.findViewById(R.id.activity_main_gamefragment_sp);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) adapterView.getItemAtPosition(i);
                switch (i){
                    case 0:
                        Toast.makeText(context,item,Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(context,item,Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(context,item,Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(context,item,Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(context,item,Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(context,item,Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(context,item,Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(context,item,Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(context,item,Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(context,item,Toast.LENGTH_SHORT).show();
                        break;

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        updateInsert = new UpdateInsert(getContext());
        data = updateInsert.getAllStudentList();
        list = new ArrayList<>();
        for(News news:data){
         //   String title = news.getTitle();
            String litpic = news.getLitpic();
            File file = new File(litpic);
            if (file.exists()){
                Bitmap bitmap = BitmapFactory.decodeFile(litpic);
                HashMap<String,Object> map = new HashMap<>();
               // map.put("title",title);
                map.put("bitmap",bitmap);
                list.add(map);
            }else {
                Log.i("aaa","图片无法取出");
            }
        }

        gameFragmentAdapter = new GameFragmentAdapter(list,context);
       // simpleAdapter = new SimpleAdapter(context,list,R.layout.activity_gridview_item,new String[]{"image","title"},new int[]{R.id.activity_gridview_iv,R.id.activity_gridview_tv});
        gridView.setAdapter(gameFragmentAdapter);
        return view;
    }


}
