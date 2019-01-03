package com.example.yt.mobile171github_13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class spxqActivity extends AppCompatActivity {
Button btn_xq_back,btn_xq_sure,btn_xq_delete;
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
    }
}
