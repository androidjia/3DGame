package com.xzkj.a3dgame.uitls;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2016/6/24.
 */
public class SaveImage {
    public String getLength(byte[] bt,String fileName ){
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            File root = Environment.getExternalStorageDirectory();
            File file= new File(root,fileName);
            try {
                FileOutputStream outputStream = new FileOutputStream(file);
                outputStream.write(bt,0,bt.length);
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return root+"/"+fileName;
        }else {
            Log.i("aaa",""+Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()));
            Log.i("aaa","sd卡无法启动");
        }
        return null;
    }

}
