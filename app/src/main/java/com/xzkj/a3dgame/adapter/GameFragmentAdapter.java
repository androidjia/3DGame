package com.xzkj.a3dgame.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xzkj.a3dgame.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
public class GameFragmentAdapter extends BaseAdapter {
    int i = 1;
    List<HashMap<String,Object>> list;
    Context context;

    public GameFragmentAdapter(List<HashMap<String, Object>> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view==null){
            view =View.inflate(context, R.layout.activity_gridview_item,null);
            holder = new ViewHolder();
            holder.iv = (ImageView) view.findViewById(R.id.activity_gridview_item_iv);
            holder.tv = (TextView) view.findViewById(R.id.activity_gridview_item_tv);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.iv.setImageBitmap((Bitmap) list.get(i).get("bitmap"));
        holder.tv.setText("game0"+i);
        return view;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv;
    }
}
