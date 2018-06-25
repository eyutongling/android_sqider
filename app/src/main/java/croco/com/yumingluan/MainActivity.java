package croco.com.yumingluan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;
import java.util.List;

import croco.com.yumingluan.bean.Company;
import croco.com.yumingluan.sercice.priseServrices;
import croco.com.yumingluan.sercice.webServrices;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart=(Button) findViewById(R.id.btnStart);
    }

    public void btnStart(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
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
        }).start();
    }
}
