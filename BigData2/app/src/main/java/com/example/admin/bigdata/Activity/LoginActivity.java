package com.example.admin.bigdata.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.bigdata.Bean.UserBean;
import com.example.admin.bigdata.DataBase.MyOpenHelper;
import com.example.admin.bigdata.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by admin on 2017/8/9.
 */

public class LoginActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_password;
    private Button login;
    private TextView register;
    private String username;
    private String password;
    private String url="http://www.ziyezhirongyao.xyz:8080/BigDataOwn4/login";
    private String result;
    private String TAG="LoginActivity";
    private static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");

    private MyOpenHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_username= (EditText) findViewById(R.id.et_login_username);
        et_password= (EditText) findViewById(R.id.et_login_password);
        login= (Button) findViewById(R.id.bt_login_login);
        register= (TextView) findViewById(R.id.tv_login_register);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=et_username.getText().toString();
                password=et_password.getText().toString();


                //final String json=formEncodingBuilder.toString();
                Gson gson=new GsonBuilder().enableComplexMapKeySerialization().create();
                UserBean userBean=new UserBean();
                userBean.setUsername(username);
                userBean.setPassword(password);
                final String json1=gson.toJson(userBean);
                Log.i(TAG,json1);
                /*final String json="{\n" +
                        "    \"username\": \"zhangsan\",\n" +
                        "    \"password\": 123\n" +
                        "}";*/
                //Log.i(TAG,json);


                Thread th=new Thread(){
                    @Override
                    public void run() {

                        OkHttpClient client=new OkHttpClient();
                        RequestBody requestBody=RequestBody.create(JSON,json1);
                        Request request=new Request.Builder().url(url).post(requestBody).build();
                        try {
                            Response response=client.newCall(request).execute();
                            Log.i(TAG,response+"");
                            if (response.isSuccessful()){
                                result=response.body().string();
                                Log.i(TAG,result);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                th.start();
                while(!th.getState().equals(Thread.State.TERMINATED));
                if (result.equals("true")){
            /*helper=MyOpenHelper.getHelper(this);
            SQLiteDatabase db=helper.getReadableDatabase();
            ContentValues values=new ContentValues();
            values.put("username",username);
            values.put("access","true");
            long rowId=db.insert("User",null,values);
            if (rowId!=-1){

            }
            db.close();*/
                    Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);

                }else {
                    Toast.makeText(getApplicationContext(),"用户名或密码错误",Toast.LENGTH_LONG).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent1);
            }
        });


    }
}
