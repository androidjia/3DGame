package com.xzkj.a3dgame.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.xzkj.a3dgame.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/7/7.
 */
public class GameFragment extends Fragment {

    Context context;
    SimpleAdapter simpleAdapter ;
    List<HashMap<String,Object>> list;
    GridView gridView ;

    public GameFragment(Context context,List<HashMap<String,Object>> list){
        this.context = context;
        this.list = list;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.activity_main_gamefragment,null);

        simpleAdapter = new SimpleAdapter(context,list,R.layout.activity_gridview_item,new String[]{"image","title"},new int[]{R.id.activity_gridview_iv,R.id.activity_gridview_tv});
        gridView = (GridView) view.findViewById(R.id.main_fragment_gridview);
        gridView.setAdapter(simpleAdapter);
        return view;
    }
}
