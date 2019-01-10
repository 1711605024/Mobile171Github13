package com.example.yt.mobile171github_13;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PrivateKey;


public class MainActivity extends AppCompatActivity {
    EditText edt_main_name,edt_main_password;
    Button btn_main_dl,btn_main_back,btn_main_zc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                btn_main_back=(Button) findViewById(R.id.btn_main_back);
                btn_main_zc=(Button) findViewById(R.id.btn_main_zc);
                edt_main_name=(EditText) findViewById(R.id.edt_main_name);
                edt_main_password=(EditText) findViewById(R.id.edt_main_password);
                btn_main_dl=(Button) findViewById(R.id.btn_main_dl);
                btn_main_dl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String getname = edt_main_name.getText().toString().trim();
                        String getpsw = edt_main_password.getText().toString().trim();
                        String md5psw=MD5Utils.md5(getpsw);
                        SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
                        String spPsw=sp.getString(getname,"");

                        if (TextUtils.isEmpty(getname)) {
                            Toast.makeText(MainActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                            return;
                        } else if (TextUtils.isEmpty(getpsw)) {
                            Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                            return;
                        }else if((spPsw!=null&&!TextUtils.isEmpty(spPsw)&&!md5psw.equals(spPsw))) {
                            Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if (md5psw.equals(spPsw)) {
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                             sp = getSharedPreferences("loginInfo", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putBoolean("isLogin", true);
                            editor.putString("getname", getname);
                            editor.commit();
                            Intent data = new Intent();
                            data.putExtra("isLogin",true);
                            setResult(RESULT_OK, data);
                            MainActivity.this.finish();
                            Intent intent = new Intent(getApplicationContext(), spcxActivity.class);
                            startActivity(intent);
                        }
                    }
        });
                btn_main_back.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         MainActivity.this.finish();
                         System.exit(0);
                     }
                 });
                 btn_main_zc.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Intent intent =new Intent(MainActivity.this,dl.class);
                         startActivityForResult(intent,1);
                     }
                 });
        }
}
