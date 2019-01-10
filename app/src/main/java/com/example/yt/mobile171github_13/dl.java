package com.example.yt.mobile171github_13;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class dl extends AppCompatActivity {
    EditText edt_dl_name, edt_dl_password;
    Button btn_dl_zc, btn_dl_back;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dl);
        edt_dl_name = (EditText) findViewById(R.id.edt_dl_name);
        edt_dl_password = (EditText) findViewById(R.id.edt_dl_password);
        btn_dl_zc = (Button) findViewById(R.id.btn_dl_zc);
        btn_dl_back = (Button) findViewById(R.id.btn_dl_back);
        btn_dl_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String getname,getpsw;
               getname=edt_dl_name.getText().toString().trim();
                getpsw=edt_dl_password.getText().toString().trim();

                if (TextUtils.isEmpty(getname)) {
                    Toast.makeText(dl.this, "请输入账号", Toast.LENGTH_SHORT).show();
                    return;
                } else if ((TextUtils.isEmpty(getpsw))) {
                    Toast.makeText(dl.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(dl.this, "注册成功", Toast.LENGTH_SHORT).show();
                    String md5Psw = MD5Utils.md5(getpsw);
                    SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString(getname, md5Psw);
                    editor.commit();
                    Intent data = new Intent();
                    data.putExtra("getname", getname);
                    setResult(RESULT_OK,data);
                    dl.this.finish();
                } }
                });
                     btn_dl_back.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                             dl.this.finish();
                          }
                     });
            }
}