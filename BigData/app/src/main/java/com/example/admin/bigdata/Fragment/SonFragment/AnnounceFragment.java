package com.example.admin.bigdata.Fragment.SonFragment;

import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.bigdata.Adapter.ListviewAdapter;
import com.example.admin.bigdata.Adapter.ListviewAdapter2;
import com.example.admin.bigdata.Bean.ListBean;
import com.example.admin.bigdata.Fragment.ParentFragment;
import com.example.admin.bigdata.R;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2017/8/2.
 */

public class AnnounceFragment extends ParentFragment {
    private TextView textView;
    private ListView listView;
    private List<ListBean> results=new ArrayList<>();
    private String url="http://cds.tyut.edu.cn/";
    private String data;
    private String TAG="Mainactivity";
    private String[] month=new String[5];
    private String[] content=new String[5];
    private String[] detail=new String[5];
    private String[] date=new String[5];
    private String[] contentUrl=new String[5];
    @Override
    public int getLayoutID() {
        return R.layout.fragment_announce;
    }

    @Override
    public void initView() {
        listView=view.findViewById(R.id.lv_announce);
        Thread th=new Thread(){
            @Override
            public void run() {
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder().url(url).build();
                try {
                    Response response=client.newCall(request).execute();
                    Log.i(TAG,response+"");
                    if (response.isSuccessful()){
                        data=response.body().string();
                        String[] result=data.split("<ul class=\"notice_ul\">");
                        data=result[1];
                        String REGEX=("(<a href=\")(.*)(\">)");
                        Pattern p=Pattern.compile(REGEX);
                        Matcher m=p.matcher(data);
                        int count=0;
                        while (m.find()){
                            contentUrl[count]=m.group(2);
                            count++;
                            Log.i(TAG,m.group(2));
                            if (count==4){
                                break;
                            }
                        }

                        String REGEX2=("(<h3>)(.*)(</h3>)");
                        Pattern p2=Pattern.compile(REGEX2);
                        Matcher m2=p2.matcher(data);
                        count=0;
                        while (m2.find()){
                            content[count]=m2.group(2);
                            count++;
                            Log.i(TAG,m2.group(2));
                            if (count==4){
                                break;
                            }
                        }

                        String REGEX3=("(<span>)(.*)(</span>)");
                        Pattern p3=Pattern.compile(REGEX3);
                        Matcher m3=p3.matcher(data);
                        count=0;
                        while (m3.find()){
                            date[count]=m3.group(2);
                            String[] result2=date[count].split("-");
                            month[count]=result2[1];
                            count++;
                            Log.i(TAG,m3.group(2));
                            if (count==4){
                                break;
                            }
                        }
                        String REGEX4=("(<h5>)(.*)(</h5>)");
                        Pattern p4=Pattern.compile(REGEX4);
                        Matcher m4=p4.matcher(data);
                        count=0;
                        while (m4.find()){
                            detail[count]=m4.group(2);
                            count++;
                            Log.i(TAG,m4.group(2));
                            if (count==4){
                                break;
                            }
                        }

                        for (count=0;count<4;count++){
                            ListBean listBean=new ListBean();
                            listBean.setContent(content[count]);
                            listBean.setContentUrl(contentUrl[count]);
                            listBean.setDate(date[count]);
                            listBean.setDetail(detail[count]);
                            listBean.setMonth(month[count]);
                            results.add(listBean);
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        th.start();
        while(!th.getState().equals(Thread.State.TERMINATED));

        ListviewAdapter2 adapter=new ListviewAdapter2(getContext(),results);
        listView.setAdapter(adapter);


    }

    public static AnnounceFragment getInstance() {
        AnnounceFragment mf=new AnnounceFragment();
        return mf;
    }
}
