package com.example.admin.bigdata.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.bigdata.Bean.ListBean;
import com.example.admin.bigdata.R;

import java.util.List;

/**
 * Created by admin on 2017/8/3.
 */

public class ListviewAdapter2 extends BaseAdapter {

    private Context context;
    private List<ListBean> items;
    private LayoutInflater inflater;
    private String TAG="ListviewAdapter2";

    public ListviewAdapter2(Context context, List<ListBean> items){
        this.context=context;
        this.inflater=LayoutInflater.from(context);
        this.items=items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=new ViewHolder();
        if (view==null){
            view=inflater.inflate(R.layout.listview_announce,null);
            viewHolder.date2=view.findViewById(R.id.lv_detail_date2);
            viewHolder.content=view.findViewById(R.id.lv_detail_content2);
            viewHolder.month=view.findViewById(R.id.lv_detail_month);
            viewHolder.detail=view.findViewById(R.id.lv_detail_detail);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        ListBean data=items.get(i);
        viewHolder.date2.setText(data.getDate().toString());
        viewHolder.content.setText(data.getContent().toString());
        viewHolder.month.setText(data.getMonth().toString());
        viewHolder.detail.setText(data.getDetail().toString());
        return view;
    }
    class ViewHolder{
        TextView date2;
        TextView month;
        TextView content;
        TextView detail;
    }
}
