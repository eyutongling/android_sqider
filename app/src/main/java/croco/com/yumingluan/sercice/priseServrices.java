package croco.com.yumingluan.sercice;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.LinkedList;
import java.util.List;

import croco.com.yumingluan.bean.Company;

/**
 * Created by Administrator on 2018/1/17 0017.
 * 解析html的服务
 */
public class priseServrices {

    /**
     * 获取符合条件的公司的地址列表
     * @param company_list_html
     * @return
     */
    public  List<String> getCompanyUrlList(String company_list_html){
        Document doc = Jsoup.parse(company_list_html);
        Elements links = doc.getElementsByClass("detlist gbox").select("div").select(".e");
        List<String> company_urls=new LinkedList<>();
        for (Element e:links){

            company_urls.add(e.getElementsByClass("info").select(".name").attr("href"));
            //System.out.println(e.getElementsByClass("info").select(".name").attr("href"));
        }
        return company_urls;
    }

    /**
     * 获取公司信息
     * @param company_html
     * @return
     */
    public Company getCompany(String company_html){
        Company company=new Company();
        Document doc = Jsoup.parse(company_html);
        Elements elements=doc.getElementById("joblistdata").select(".el");
        company.setItem(elements.size());
        List<String> job_list=new LinkedList<>();
        for (Element e:elements){
            //System.out.println(e.html());
            job_list.add(e.getElementsByClass("t1").select("a").first().attr("title"));
        }
        company.setName(doc.getElementsByTag("h1").first().text());
        company.setUrl(doc.getElementsByTag("head").select("link").last().attr("href"));
        company.setJob_list(job_list);
        //System.out.println(company);
        return company;
    }

    public static void main(String[] args) {
        new priseServrices().getCompany(new webServrices().getHtmlByUrl("http://jobs.51job.com/guangzhou-hzq/co2327731.html"));
        //System.out.println(new webServrices().getHtmlByUrl("http://jobs.51job.com/guangzhou/jisuanjiruanjian/p1"));
    }
}
