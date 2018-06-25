package croco.com.yumingluan.sercice;


import okhttp3.*;
import org.junit.Test;


import java.io.IOException;

/**
 * Created by Administrator on 2018/1/16 0016.
 * 使用okhttp3获取html的服务
 */
public class OkHttpServrices {


    public static void main(String[] args) {
        try {
            String string= new OkHttpServrices().run("http://jobs.51job.com/guangzhou-hpq/co4241252.html");
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    OkHttpClient client = new OkHttpClient();
    String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
           return "404";
        }
    }
}
