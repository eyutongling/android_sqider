package croco.com.yumingluan;

import java.util.LinkedList;
import java.util.List;

import croco.com.yumingluan.bean.Company;
import croco.com.yumingluan.sercice.priseServrices;
import croco.com.yumingluan.sercice.webServrices;


public class App {
    public static void main(String[] args) {
        String company_list_url="https://jobs.51job.com/guangzhou/cs05/jisuanjiruanjian/p";
        List<String> company_url_list=new LinkedList<String>();
        for (int i=1;i<38;i++){
            company_url_list = new priseServrices().getCompanyUrlList(
                    new webServrices().getHtmlByUrl(company_list_url+i));
            for (int j=0;j<company_url_list.size();j++){
                //System.out.println(j);
                String company_html=new webServrices().getHtmlByUrl(company_url_list.get(j));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!company_html.equals("0")){
                    Company company= new priseServrices().getCompany(company_html);
                    System.out.println(company);
                }
            }
        }
    }
/*    @Test
    public  void f() {
        String company_list_url="http://119.188.115.14/guangzhou/jisuanjiruanjian/p";
        for (int i=1;i<22;i++){
            List<String> company_url_list=new priseServrices().getCompanyUrlList(
                    new webServrices().getHtmlByUrl(company_list_url+i));

            for (int j=0;j<company_url_list.size();j++){
                System.out.println(company_url_list.get(i));
            }
        }
    }

    @Test
    public  void g() {
        String company_url="http://jobs.51job.com/guangzhou/co3632293.html";
        GetHtmlByGetThrend t1= new GetHtmlByGetThrend(company_url);
        t1.start();
        //new  Scanner(System.in).next();
    }*/
}
