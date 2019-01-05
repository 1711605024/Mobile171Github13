package com.example.yt.mobile171github_13;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class dl extends AppCompatActivity {
    EditText edt_dl_name,edt_dl_password;
    Button btn_dl_zc,btn_dl_back;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dl);
        edt_dl_name=(EditText)findViewById(R.id.edt_dl_name);
        edt_dl_password=(EditText)findViewById(R.id.edt_dl_password);
        btn_dl_zc=(Button)findViewById(R.id.btn_dl_zc);
        btn_dl_back=(Button)findViewById(R.id.btn_dl_back);
        btn_dl_zc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                saveUserInfo();
                getUserInfo();

            }




        });
        btn_dl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),MainActivity.class);

                startActivity(intent);

            }
        });
    }

    public  boolean saveUserInfo(){
        String name;
        String password;
        password=edt_dl_password.getText().toString().trim();
        name=edt_dl_name.getText().toString().trim();
        SharedPreferences sp= getApplicationContext().getSharedPreferences("data",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit=sp.edit();
        edit.putString("name",name);
        edit.putString("password",password);
        edit.commit();
        return true;
    }

    public Map<String,String> getUserInfo(){
        SharedPreferences sp=context.getSharedPreferences("data",Context.MODE_PRIVATE);
        String name=sp.getString("name",null);
        String password=sp.getString("password",null);
        Map<String,String>userMap=new HashMap<String, String>();
        userMap.put("name",name);
        userMap.put("password",password);
        return userMap;
    }

}
