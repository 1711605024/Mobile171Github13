package com.example.yt.mobile171github_13;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class spxqActivity extends AppCompatActivity implements View.OnClickListener {
Button btn_xq_back,btn_xq_delete;
private Button btn_xq_sure;
EditText edt_xq_number,edt_xq_name,edt_xq_place;
MyHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spxq);
        btn_xq_back=(Button) findViewById(R.id.btn_xq_back);
        btn_xq_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getApplicationContext(),spcxActivity.class);

                startActivity(intent);
            }
        });
        btn_xq_sure=(Button)findViewById(R.id.btn_xq_sure);
        btn_xq_sure.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String number;
        String name;
        String place;
        SQLiteDatabase db;
        ContentValues values;
        switch (view.getId()){
            case R.id.btn_xq_sure:
                number=edt_xq_number.getText().toString();
                name=edt_xq_name.getText().toString();
                place=edt_xq_place.getText().toString();
                db=myHelper.getWritableDatabase();
                values=new ContentValues();
                values.put("number", number);
                values.put("name", name);
                values.put("place", place);
                db.insert("information",null,values);
                Toast.makeText(this,"信息已添加",Toast.LENGTH_SHORT).show();
                db.close();
                break;
        }
    }

    private class MyHelper extends SQLiteOpenHelper{
        public MyHelper(Context context){
            super(context,"itcast.db",null,1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table information(_id integer primary key autoincrement, name varchar(20), place varchar(20),number varchar(20))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
