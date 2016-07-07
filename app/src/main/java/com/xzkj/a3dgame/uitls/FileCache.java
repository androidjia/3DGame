package com.xzkj.a3dgame.uitls;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/7/5.
 */
public class FileCache {
    private Context context;
    public FileCache(Context context){
        this.context = context;
    }
    private static final File SD_ROOT = Environment.getExternalStorageDirectory();

    private String cache_folder = "file_cache";
    boolean isMounted = false;
    private static File CACHE_FOLDER = null;
    public FileCache(){
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            Log.i("aaa","sdcard没有挂载");
        }else {
            isMounted = true;
            CACHE_FOLDER = new File(SD_ROOT,cache_folder);
            if (!CACHE_FOLDER.exists()){
                CACHE_FOLDER.mkdirs();
            }
        }
    }
    //保存图片到缓存目录中
    public synchronized String saveFileToSDCardCache(byte[] data,String str ){
        FileOutputStream outputStream = null;
        String stringPath = null;
        if (isMounted){
            if (!CACHE_FOLDER.exists()){
                Toast.makeText(context,"文件夹不存在",Toast.LENGTH_SHORT).show();
            }
            String fileName = str.substring(str.lastIndexOf("/")+1);
            File saveFile = new File(CACHE_FOLDER,fileName);
            try {
                outputStream = new FileOutputStream(saveFile);
                outputStream.write(data,0,data.length);
                //获取绝对路径
                 stringPath = saveFile.getAbsolutePath();
                Log.i("aaa","stringpath"+stringPath);
                return stringPath;
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (outputStream!=null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
    public Bitmap getFileFromSDcard(String string ){
        Bitmap bitmap = null;
        if (isMounted){
            if (string!=null){
                String fileName = string.substring(string.lastIndexOf("/"+1));
                File getFile = new File(CACHE_FOLDER,fileName);
                if (getFile.exists()){
                    bitmap = BitmapFactory.decodeFile(getFile.getAbsolutePath());
                }
            }
        }
        return bitmap;
    }
    //从SDcard中移除某个文件
    public boolean deleteFileFromSDCard(String string ){
        if(isMounted){
            if (string!=null){
                String fileName =string.substring(string.lastIndexOf("/")+1);
                File deleteFile = new File(CACHE_FOLDER,fileName);
                if (deleteFile.exists()){
                    return deleteFile.delete();
                }
            }
        }
        return false;
    }
    //从SDCard中清空缓存
    public void clear(){
        if (isMounted){
            File[] allCacheFile = CACHE_FOLDER.listFiles();
            for (File file:allCacheFile){
                file.delete();
            }
        }
    }
}
