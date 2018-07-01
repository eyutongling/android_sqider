package croco.com.yumingluan;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import croco.com.yumingluan.Adapter.JobsAdapter;
import croco.com.yumingluan.bean.Company;

public class DetailActivity extends AppCompatActivity {
    TextView textView_name;
    TextView textView_item;
    TextView textView_url;
    List<String> jobs_list=new ArrayList();
    ListView listView_jobs;
    JobsAdapter jobsAdapter;
    Company company;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView_name=findViewById(R.id.name);
        textView_item=findViewById(R.id.conpany_item);
        textView_url=findViewById(R.id.company_url);
        listView_jobs=findViewById(R.id.list_jobs);

        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        company=(Company) bundle.getSerializable("company");
        jobs_list=company.getJob_list();
        jobsAdapter=new JobsAdapter(DetailActivity.this,R.layout.jobs,jobs_list);
        listView_jobs.setAdapter(jobsAdapter);
        textView_name.setText(company.getName());
        textView_item.setText(company.getItem()+"");
        textView_url.setText(company.getUrl());

    }

    /**
     * 公司网址
     * @param v
     */
    public void showCompanyHome(View v) {

        String url=company.getUrl();

        Uri uri=Uri.parse("https:"+company.getUrl());
        //进行跳转的intent
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        //进行跳转
        startActivity(intent);

    }
}
