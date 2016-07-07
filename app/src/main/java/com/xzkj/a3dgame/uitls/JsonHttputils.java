package com.xzkj.a3dgame.uitls;

import com.xzkj.a3dgame.javadao.News;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/5.
 */
public class JsonHttputils {
    public static List<News> getJson(String strurl){
        List<News> list = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(strurl);
            JSONObject data = root.getJSONObject("data");
            for (int i=0;i<=9;i++){
                News news = new News();
                JSONObject object = data.getJSONObject(i+"");
                news.setId(object.getString("id"));
                news.setTypeid(object.getString("typeid"));
                news.setTypeid2(object.getString("typeid2"));
                news.setSortrank(object.getString("sortrank"));
                news.setFlag(object.getString("flag"));
                news.setIsmake(object.getString("ismake"));
                news.setChannel(object.getString("channel"));
                news.setArcrank(object.getString("arcrank"));
                news.setClick(object.getString("click"));
                news.setMoney(object.getString("money"));
                news.setTitle(object.getString("title"));
                news.setShorttitle(object.getString("shorttitle"));
                news.setColor(object.getString("color"));
                news.setWriter(object.getString("writer"));
                news.setSource(object.getString("source"));
                news.setLitpic("http://www.3dmgame.com" +object.getString("litpic"));
                news.setPubdate(object.getString("pubdate"));
                news.setSenddate(object.getString("senddate"));
                news.setMid(object.getString("mid"));
                news.setKeywords(object.getString("keywords"));
                news.setLastpost(object.getString("lastpost"));
                news.setScores(object.getString("scores"));
                news.setGoodpost(object.getString("goodpost"));
                news.setBadpost(object.getString("badpost"));
                news.setVoteid(object.getString("voteid"));
                news.setNotpost(object.getString("notpost"));
                news.setDescription(object.getString("description"));
                news.setFilename(object.getString("filename"));
                news.setDutyadmin(object.getString("dutyadmin"));
                news.setTackid(object.getString("tackid"));
                news.setMtype(object.getString("mtype"));
                news.setWeight(object.getString("weight"));
                news.setFby_id(object.getString("fby_id"));
                news.setGame_id(object.getString("game_id"));
                news.setFeedback(object.getString("feedback"));
                news.setTypedir(object.getString("typedir"));
                news.setTypename(object.getString("typename"));
                news.setCorank(object.getString("corank"));
                news.setIsdefault(object.getString("isdefault"));
                news.setDefaultname(object.getString("defaultname"));
                news.setNamerule(object.getString("namerule"));
                news.setNamerule2(object.getString("namerule2"));
                news.setIspart(object.getString("ispart"));
                news.setMoresite(object.getString("moresite"));
                news.setSiteurl(object.getString("siteurl"));
                news.setSitepath(object.getString("sitepath"));
                news.setArcurl(object.getString("arcurl"));
                news.setTypeurl(object.getString("typeurl"));
                list.add(news);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
