package croco.com.yumingluan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import croco.com.yumingluan.R;
import croco.com.yumingluan.bean.Company;

public class JobsAdapter extends ArrayAdapter{
    private final int resourceId;

    public JobsAdapter(Context context, int textViewResourceId, List<Company> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Company company = (Company) getItem(position); // 获取当前项的Company实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        TextView companyName = (TextView) view.findViewById(R.id.company_name);//获取该布局内的文本视图
        TextView job_numb=(TextView)view.findViewById(R.id.number);
        companyName.setText(company.getName());//为文本视图设置文本内容
        job_numb.setText(company.getItem()+"");
        return view;
    }
}
