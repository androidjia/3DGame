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
 * Created by Administrator on 2016/7/7.
 */
public class ListViewAdapter extends BaseAdapter{
    private Context context;
    private List<HashMap<String,Object>> list;

    public ListViewAdapter(Context context, List<HashMap<String, Object>> list) {
        this.context = context;
        this.list = list;
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
            view= View.inflate(context, R.layout.activity_main_article_listview,null);
            holder = new ViewHolder();
            holder.iv = (ImageView) view.findViewById(R.id.activity_main_article_listview_iv);
            holder.tv = (TextView) view.findViewById(R.id.activity_main_article_listview_tv);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.iv.setImageBitmap((Bitmap)list.get(i).get("bitmap"));
        holder.tv.setText(list.get(i).get("title").toString());
        return view;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv;
    }
}
