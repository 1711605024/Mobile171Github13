package com.example.yt.mobile171github_13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


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

                        Intent intent =new Intent(getApplicationContext(),spcxActivity.class);

                        startActivity(intent);

                    }
                });
                 btn_main_back.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         MainActivity.this.finish();
                         System.exit(0);

                     }
                 });
                 btn_main_zc.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         Intent intent =new Intent(getApplicationContext(),dl.class);

                         startActivity(intent);
                     }
                 });

    }
}
