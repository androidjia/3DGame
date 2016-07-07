package com.xzkj.a3dgame.uitls;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.xzkj.a3dgame.javadao.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/5.
 */
public class UpdateInsert {
    private NewsSqliteOpenHelper helper;
    public UpdateInsert(Context context){
        helper = new NewsSqliteOpenHelper(context);
    }
    public boolean insert(News news){
        SQLiteDatabase db = null;
        try {
            db = helper.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put("id",news.getId());
            values.put("typeid",news.getTypeid());
            values.put("typeid2",news.getTypeid2());
            values.put("sortrank",news.getSortrank());
            values.put("flag",news.getFlag());
            values.put("ismake",news.getIsmake());
            values.put("channel",news.getChannel());
            values.put("arcrank",news.getArcrank());
            values.put("click",news.getClick());
            values.put("money",news.getMoney());
            values.put("title",news.getTitle());
            values.put("shorttitle",news.getShorttitle());
            values.put("color",news.getColor());
            values.put("writer",news.getWriter());
            values.put("source",news.getSource());
            values.put("litpic",news.getLitpic());
            values.put("pubdate",news.getPubdate());
            values.put("senddate",news.getSenddate());
            values.put("mid",news.getMid());
            values.put("keywords",news.getKeywords());
            values.put("lastpost",news.getLastpost());
            values.put("scores",news.getScores());
            values.put("goodpost",news.getGoodpost());
            values.put("badpost",news.getBadpost());
            values.put("voteid",news.getVoteid());
            values.put("notpost",news.getNotpost());
            values.put("description",news.getDescription());
            values.put("filename",news.getFilename());
            values.put("dutyadmin",news.getDutyadmin());
            values.put("tackid",news.getTackid());
            values.put("mtype",news.getMtype());
            values.put("weight",news.getWeight());
            values.put("fby_id",news.getFby_id());
            values.put("game_id",news.getGame_id());
            values.put("feedback",news.getFeedback());
            values.put("typedir",news.getTypedir());
            values.put("typename",news.getTypename());
            values.put("corank",news.getCorank());
            values.put("isdefault",news.getIsdefault());
            values.put("defaultname",news.getDefaultname());
            values.put("namerule",news.getNamerule());
            values.put("namerule2",news.getNamerule2());
            values.put("ispart",news.getIspart());
            values.put("moresite",news.getMoresite());
            values.put("siteurl",news.getSiteurl());
            values.put("sitepath",news.getSitepath());
            values.put("arcurl",news.getArcurl());
            values.put("typeurl",news.getTypeurl());
            db.insert("news",null,values);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (db!=null&&db.isOpen()){
                db.close();
            }
        }
        return false;
    }
    public List<News> getAllStudentList(){
        SQLiteDatabase db = null;
        Cursor cursor = null;
        List<News> data = new ArrayList<>();

        try {
            db = helper.getReadableDatabase();
            cursor = db.query("news",null,null,null,null,null,null);
            while (cursor.moveToNext()){
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String litpic = cursor.getString(cursor.getColumnIndex("litpic"));
                Log.i("aaa","数据库中的图片地址："+litpic);
                News news= new News(title,litpic);
                data.add(news);

            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db!=null&&db.isOpen()){
                db.close();
            }
        }
        return null;
    }
    public List<News> getAllStudentListByPage(int pageSize,int pageIndex){
        SQLiteDatabase db = null;
        Cursor cursor = null;
        List<News> data = new ArrayList<>();

        try {
            db = helper.getReadableDatabase();
            int offest = (pageIndex-1)*pageSize;
            cursor = db.query("news",null,null,null,null,null,null,String.valueOf(offest)+String.valueOf(pageSize));
            while (cursor.moveToNext()){
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String litpic = cursor.getString(cursor.getColumnIndex("litpic"));
                News news= new News(title,litpic);
                data.add(news);
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db!=null&&db.isOpen()){
                db.close();
            }
        }
        return null;
    }
}
