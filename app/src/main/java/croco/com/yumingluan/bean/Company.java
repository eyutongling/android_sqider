package croco.com.yumingluan.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/1/17 0017.
 */
public class Company implements Serializable {
    private String name;
    private String url;
    private int item;
    private List<String> job_list;
    public Company(){
    }
    public Company(String name,int item){
        this.name=name;
        this.item=item;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public List<String> getJob_list() {
        return job_list;
    }

    public void setJob_list(List<String> job_list) {
        this.job_list = job_list;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", item=" + item +
                ", job_list=" + job_list +
                '}';
    }
}
