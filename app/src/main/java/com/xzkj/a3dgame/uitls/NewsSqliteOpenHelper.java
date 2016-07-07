package com.xzkj.a3dgame.uitls;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/7/5.
 */
public class NewsSqliteOpenHelper extends SQLiteOpenHelper{
    public NewsSqliteOpenHelper(Context context) {
        super(context,"news.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists news(" +
                "num integer primary key," +
                "id varchar(20)," +
                "typeid varchar(20)," +
                "typeid2 varchar(20)," +
                "sortrank varchar(20)," +
                "flag varchar(20)," +
                "ismake varchar(20)," +
                "channel varchar(20)," +
                "arcrank varchar(20)," +
                "click varchar(20)," +
                "money varchar(20)," +
                "title varchar(100)," +
                "shorttitle varchar(80)," +
                "color varchar(20)," +
                "writer varchar(20)," +
                "source varchar(20)," +
                "litpic varchar(50)," +
                "pubdate varchar(20)," +
                "senddate varchar(20)," +
                "mid varchar(20)," +
                "keywords varchar(50)," +
                "lastpost varchar(20)," +
                "scores varchar(20)," +
                "goodpost varchar(20)," +
                "badpost varchar(20)," +
                "voteid varchar(20)," +
                "notpost varchar(20)," +
                "description varchar(200)," +
                "filename varchar(20)," +
                "dutyadmin varchar(20)," +
                "tackid varchar(20)," +
                "mtype varchar(20)," +
                "weight varchar(20)," +
                "fby_id varchar(20)," +
                "game_id varchar(20)," +
                "feedback varchar(20)," +
                "typedir varchar(20)," +
                "typename varchar(20)," +
                "corank varchar(20)," +
                "isdefault varchar(20)," +
                "defaultname varchar(20)," +
                "namerule varchar(40)," +
                "namerule2 varchar(50)," +
                "ispart varchar(20)," +
                "moresite varchar(20)," +
                "siteurl varchar(20)," +
                "sitepath varchar(20)," +
                "arcurl varchar(50)," +
                "typeurl varchar(30))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
