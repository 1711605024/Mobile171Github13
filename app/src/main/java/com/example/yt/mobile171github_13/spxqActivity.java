package com.example.yt.mobile171github_13;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class spxqActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_xq_sure;
    private Button btn_xq_back;
    private EditText edt_xq_number, edt_xq_name, edt_xq_place;
    TextView tv_cx_show;
    MyHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spxq);

        myHelper = new MyHelper(this);
        tv_cx_show=(TextView) findViewById(R.id.tv_cx_show);
        edt_xq_number=(EditText) findViewById(R.id.edt_xq_number);
        edt_xq_name=(EditText)findViewById(R.id.edt_xq_name);
        edt_xq_place=(EditText)findViewById(R.id.edt_xq_place);
        btn_xq_sure = (Button) findViewById(R.id.btn_xq_sure);
        btn_xq_sure.setOnClickListener(this);

        btn_xq_back = (Button) findViewById(R.id.btn_xq_back);
        btn_xq_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), spcxActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {
        String number;
        String name;
        String place;
        SQLiteDatabase db;
        ContentValues values;
        switch (view.getId()) {
            case R.id.btn_xq_sure:
                number = edt_xq_number.getText().toString().trim();
                name = edt_xq_name.getText().toString().trim();
                place = edt_xq_place.getText().toString().trim();
                db = myHelper.getWritableDatabase();
                values = new ContentValues();
                values.put("number", number);
                values.put("name", name);
                values.put("place", place);
                if(TextUtils.isEmpty(number)){
                    Toast.makeText(this,"添加失败",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(this,"添加失败",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(place)){
                    Toast.makeText(this,"添加失败",Toast.LENGTH_SHORT).show();
                    return;
                }
                db.insert("information", null, values);
                Toast.makeText(this, "信息已添加", Toast.LENGTH_SHORT).show();

                db.close();
                break;

        }
    }



}
