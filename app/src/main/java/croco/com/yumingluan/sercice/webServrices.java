package croco.com.yumingluan.sercice;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/1/16 0016.
 * 使用okhttp3获取html的服务
 */
public class webServrices {
    String html="0";

    /**
     * 从网络获取html
     * @param url
     * @return
     */
    public String getHtmlByUrl(String url) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        try{
            Response response = okHttpClient.newCall(request).execute();
            byte[] b = response.body().bytes();
            html = new String(b, "GB2312");
        }catch (IOException e){
            e.printStackTrace();
        }
        return html ;
    }
}
