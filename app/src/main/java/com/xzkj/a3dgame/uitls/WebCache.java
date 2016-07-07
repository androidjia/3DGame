package com.xzkj.a3dgame.uitls;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/7/5.
 */
public class WebCache {
    public void getWebCache(final String urlStr,final CallBack callBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] b = getWebFile(urlStr);
                callBack.getResult(b);
            }
        }).start();
    }
    public byte[] getWebFile(String string ){
        try {
            URL url = new URL(string);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            //HttpURLConnection.HTTP_OK
            if (connection.getResponseCode()==200){
                InputStream inputStream = connection.getInputStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(bytes))!=-1){
                    outputStream.write(bytes,0,len);
                }
                if (inputStream!=null){
                    inputStream.close();
                }
                return outputStream.toByteArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public interface CallBack{
        public void getResult(byte[] data);
    }
}
