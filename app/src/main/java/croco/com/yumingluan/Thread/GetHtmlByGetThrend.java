package croco.com.yumingluan.Thread;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.LinkedList;
import java.util.List;

import croco.com.yumingluan.bean.Company;
import croco.com.yumingluan.sercice.webServrices;

/**
 * Created by Administrator on 2018/1/16 0016.
 * 获取html的服务
 */
public class GetHtmlByGetThrend extends Thread {
    String url;
    public GetHtmlByGetThrend(String url){
        this.url=url;
    }

    @Override
    public void run() {
        new webServrices().getHtmlByUrl(url);
    }
}
