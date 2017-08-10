package com.example.admin.bigdata.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by admin on 2017/8/9.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    private static MyOpenHelper moh;

    public static MyOpenHelper getHelper(Context context) {
        if (moh == null) {
            moh = new MyOpenHelper(context);
        }
        return moh;

    }


    private MyOpenHelper(Context context) {
        super(context, "user.db", null, VERSION);
    }

    /*
    * 当数据库文件不存在，创建数据库文件，并且第一次使用时
    * */

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表只需一次
        String sql = "create table User(_id integer primary key autoincrement," + "userName," + "access)";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //当你的版本更新时，需要更新数据库对象


    }
}
