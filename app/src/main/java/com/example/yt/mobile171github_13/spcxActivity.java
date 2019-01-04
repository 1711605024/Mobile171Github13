package com.example.yt.mobile171github_13;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class spcxActivity extends AppCompatActivity {
    Button btn_cx_check,btn_cx_add,btn_cx_delete;
    TextView tv_cx_show;
    MyHelper myHelper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spcx);
        myHelper=new MyHelper(this);
        tv_cx_show=(TextView)findViewById(R.id.tv_cx_show);

        btn_cx_delete=(Button) findViewById(R.id.btn_cx_delete);
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
                switch (view.getId()) {
                    case R.id.btn_cx_check:
                db=myHelper.getReadableDatabase();
                Cursor cursor = db.query("information",null,null,null,null,null,null);
                if(cursor.getCount() == 0) {
                    tv_cx_show.setText("");
                    Toast.makeText(getApplicationContext(),"没有数据",Toast.LENGTH_SHORT).show();
                }else {
                    cursor.moveToFirst();
                    tv_cx_show.setText("产地："+cursor.getString(1)+"；名称："+cursor.getString(2)+"；编号："+cursor.getString(3));
                }while (cursor.moveToNext()){
                    tv_cx_show.append("\n"+"产地："+cursor.getString(1)+"；名称："+cursor.getString(2)+"；编号："+cursor.getString(3));
                }
                db.close();
                cursor.close();
                break;

            }
        }
        });
        btn_cx_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_cx_delete:
                        db = myHelper.getWritableDatabase();
                        db.delete("information", null, null);
                        Toast.makeText(getApplicationContext(), "信息已删除", Toast.LENGTH_SHORT).show();
                        tv_cx_show.setText("无信息");
                        db.close();
                        break;
                }
            }
        });
    }
}
