package com.example.nustahackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class logoin extends AppCompatActivity {
Button next,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logoin);
        next=findViewById(R.id.next);
        back=findViewById(R.id.back);

    }
    public void next(View view){
        Intent i=new Intent(logoin.this,cost.class);

        startActivity(i);
        finish();
    }
    public void back(View view){
        Intent i=new Intent(logoin.this,reporttut.class);
        startActivity(i);
        finish();
    }
}
