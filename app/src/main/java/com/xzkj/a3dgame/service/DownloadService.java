package com.xzkj.a3dgame.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.util.Log;

import com.xzkj.a3dgame.javadao.News;
import com.xzkj.a3dgame.uitls.FileCache;
import com.xzkj.a3dgame.uitls.GetImageFromSql;
import com.xzkj.a3dgame.uitls.ImageCompression;
import com.xzkj.a3dgame.uitls.JsonHttputils;
import com.xzkj.a3dgame.uitls.MomeryCache;
import com.xzkj.a3dgame.uitls.NewsSqliteOpenHelper;
import com.xzkj.a3dgame.uitls.SaveImage;
import com.xzkj.a3dgame.uitls.UpdateInsert;
import com.xzkj.a3dgame.uitls.WebCache;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class DownloadService extends Service {
    //网络请求数据
    private WebCache webCache;
    //网络请求Json数据
    private JsonHttputils jsonHttputils;
    //保存图片到sd卡
    private FileCache fileCache;
    private SaveImage saveImage;
    //更新数据库数据
    private UpdateInsert updateInsert;
    //图片二次采样
     private ImageCompression imageCompression;
    MomeryCache momeryCache;

    private NewsSqliteOpenHelper newsSqliteOpenHelper;
    private GetImageFromSql getImageFromSql;
    private int row = 15;
    private int typeid = 1;
    private int page = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        newsSqliteOpenHelper = new NewsSqliteOpenHelper(getApplicationContext());
        webCache = new WebCache();
        jsonHttputils  = new JsonHttputils();
        fileCache = new FileCache(getApplicationContext());
        updateInsert = new UpdateInsert(getApplicationContext());
        imageCompression = new ImageCompression();
        momeryCache = new MomeryCache();
        saveImage = new SaveImage();
        getImageFromSql = new GetImageFromSql(getApplicationContext());
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
            final String path = "http://www.3dmgame.com/sitemap/api.php?row="+row+"&typeid="+typeid+"&paging=1&page="+page;
           // final String path = "http://www.3dmgame.com/sitemap/api.php?row="+row+"&typeid="+typeid+"&paging=1&page="+page;
//            if (path!=null){
//                //获取网络请求数据
//                byte[] bs = webCache.getWebFile(path);//百度地图前一天的知识
//                if (bs!=null){
//                    try {
//                        String json = new String(bs,"utf-8");
//                        List<News> data = JsonHttputils.getJson(json);
//                        for (int i=0;i<=9;i++){
//                            News n = data.get(i);
//                            //获取图片路径
//                            String imgurl = n.getLitpic();
//                            //获取压缩图片
//                            byte[] downing = webCache.getWebFile(imgurl);
//                            Bitmap bitmap = ImageCompression.getCompressionImage(downing,50,50);
//                            //将压缩图片转换为字节数组
//                            byte[] bytes = BitmapToBytes(bitmap);
//                            //保存到SDCard中
//                            //保存文件并拿取文件的路径
//                          //  String imgabsolutepath = fileCache.saveFileToSDCardCache(bytes,imgurl);
//                            String fileName = imgurl.substring(imgurl.lastIndexOf("/")+1);
//                            String imgabsolutepath = saveImage.getLength(bytes,fileName);
//                            //保存图片到内存中
//                            momeryCache.addBitmapToLruCache(imgurl,bitmap);
//                            //获取绝对路径，给对象放入数据库做准备
//                            n.setLitpic(imgabsolutepath);
//                            //像数据库中插入数据
//                            updateInsert.insert(n);
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }

                getImageFromSql.getResult(path);
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }
    public byte[] BitmapToBytes(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG,100,baos);
        return baos.toByteArray();
    }
}
