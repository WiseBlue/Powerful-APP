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

public class ListviewAdapter extends BaseAdapter {

    private Context context;
    private List<ListBean> items;
    private LayoutInflater inflater;
    private String TAG="ListviewAdapter";

    public ListviewAdapter(Context context,List<ListBean> items){
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
            view=inflater.inflate(R.layout.listview_news,null);
            viewHolder.imageView=view.findViewById(R.id.lv_detail_img);
            viewHolder.content=view.findViewById(R.id.lv_detail_content);
            viewHolder.number=view.findViewById(R.id.lv_detail_number);
            viewHolder.date=view.findViewById(R.id.lv_detail_date);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        ListBean data=items.get(i);
        //Glide.with(context).load(data.getImageUrl().toString()).into(viewHolder.imageView);
        viewHolder.content.setText(data.getContent().toString());
        //viewHolder.number.setText(data.getNumber().toString());
        viewHolder.date.setText(data.getDate().toString());
        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView content;
        TextView number;
        TextView date;
    }
}
