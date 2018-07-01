package croco.com.yumingluan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import croco.com.yumingluan.Adapter.CompanyAdapter;
import croco.com.yumingluan.bean.Company;
import croco.com.yumingluan.sercice.priseServrices;
import croco.com.yumingluan.sercice.webServrices;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    List<Company> companies=new ArrayList<>();
    List<Company> cache_companies=new ArrayList<>();
    CompanyAdapter companyAdapter;
    ListView listView;
    @Override
    /**
     * 程序的主入口
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart=(Button) findViewById(R.id.btnStart);
        initCompany();
        listView = (ListView) findViewById(R.id.list_view);
        companyAdapter=new CompanyAdapter(MainActivity.this,R.layout.company,companies);
        listView.setAdapter(companyAdapter);
        /**
         * ListView的监听事件
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                companyAdapter.notifyDataSetChanged();
                System.out.println("------------");
                Bundle bundle = new Bundle();
                bundle.putString("name",companies.get(i).getName());
                bundle.putSerializable("company",companies.get(i));
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(MainActivity.this,DetailActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 启动点击执行
     * @param v
     */
    public void btnStart(View v) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String company_list_url="https://jobs.51job.com/guangzhou/cs05/jisuanjiruanjian/p";
                List<String> company_url_list=new LinkedList<String>();
                for (int i=1;i<4;i++){
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
                            cache_companies.add(company);
                            //companyAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        }).start();
    }

    /**
     * 刷新
     * @param v
     */
    public void btnFlash(View v) {
        companies.clear();
        companies.addAll(removeDuplicate(cache_companies));
        companyAdapter.notifyDataSetChanged();
    }
    private void initCompany() {
//        Company apple = new Company("Apple",12);
////        companies.add(apple);
////        Company banana = new Company("Banana",12);
////        companies.add(banana);
////        Company xiaomi = new Company("XiaoMi",12);
////        companies.add(xiaomi);
    }
    public  List removeDuplicate(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
        return list;
    }
}
