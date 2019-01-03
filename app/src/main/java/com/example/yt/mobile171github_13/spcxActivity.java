package com.example.yt.mobile171github_13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class spcxActivity extends AppCompatActivity {
    EditText edt_cx_name;
    Button btn_cx_check,btn_cx_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spcx);
        edt_cx_name=(EditText) findViewById(R.id.edt_cx_name);
        btn_cx_check=(Button) findViewById(R.id.btn_cx_check);
        btn_cx_add=(Button) findViewById(R.id.btn_cx_add);
        btn_cx_add.setOnClickListener(new View.OnClickListener() {//点击添加按钮执行操作
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),spxqActivity.class);

                startActivity(intent);
            }
        });
        btn_cx_check.setOnClickListener(new View.OnClickListener() {//点击查询按钮执行操作
            @Override
            public void onClick(View view) {

            }
        });
    }
}
