package com.example.yt.mobile171github_13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText edt_main_name,edt_main_password;
    Button btn_main_dl;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                edt_main_name=(EditText) findViewById(R.id.edt_main_name);
                edt_main_password=(EditText) findViewById(R.id.edt_main_password);
                btn_main_dl=(Button) findViewById(R.id.btn_main_dl);
                btn_main_dl.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getApplicationContext(),spcxActivity.class);
                        intent.putExtra("name",edt_main_name.getText().toString().trim());
                        intent.putExtra("password",edt_main_password.getText().toString().trim());
                        startActivity(intent);

                    }
                });

    }
}
