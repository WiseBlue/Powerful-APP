package com.example.admin.bigdata.Fragment.SonFragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.bigdata.Activity.LoginActivity;
import com.example.admin.bigdata.DataBase.MyOpenHelper;
import com.example.admin.bigdata.Fragment.ParentFragment;
import com.example.admin.bigdata.R;

/**
 * Created by admin on 2017/8/2.
 */

public class MyOwnFragment extends ParentFragment {
    private ImageView background;
    private ImageView header;
    private TextView username;
    private Button login;
    private MyOpenHelper helper;
    @Override
    public int getLayoutID() {
        return R.layout.fragment_myown;
    }

    @Override
    public void initView() {
        initId();
        helper=MyOpenHelper.getHelper(getContext());
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cur=db.query("User",null,"access='"+"true"+"'",null,null,null,null);
        Toast.makeText(getContext(),cur.moveToFirst()+"",Toast.LENGTH_LONG).show();
        if (cur.moveToFirst()){
            if (cur!=null&&(cur.getString(cur.getColumnIndex("access"))=="true")){
                username.setText(cur.getString(cur.getColumnIndex("username")));
                login.setVisibility(View.GONE);
            }
        }
        else {
            header.setVisibility(View.INVISIBLE);
            background.setVisibility(View.INVISIBLE);
            username.setVisibility(View.INVISIBLE);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    private void initId() {
        background=view.findViewById(R.id.iv_myown_background);
        header=view.findViewById(R.id.iv_myown_header);
        username=view.findViewById(R.id.tv_myown_username);
        login=view.findViewById(R.id.bt_myown_login);
    }

    public static MyOwnFragment getInstance() {
        MyOwnFragment mf=new MyOwnFragment();
        return mf;
    }
}
