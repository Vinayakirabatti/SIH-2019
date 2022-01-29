package com.example.nustahackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class cost extends AppCompatActivity {
    Button next6,back6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);
        next6=findViewById(R.id.next6);
        back6=findViewById(R.id.back6);

    }
    public void next6(View view){
        Intent i=new Intent(cost.this, cameratut.class);

        startActivity(i);
        finish();
    }
    public void back6(View view){
        Intent i=new Intent(cost.this,logoin.class);

        startActivity(i);
        finish();
    }
}
