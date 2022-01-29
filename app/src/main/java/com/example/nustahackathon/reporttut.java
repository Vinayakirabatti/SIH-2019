package com.example.nustahackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class reporttut extends AppCompatActivity {
    Button next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporttut);
        next1=findViewById(R.id.next1);
    }
    public void next1(View view){
        Intent i=new Intent(reporttut.this,logoin.class);

        startActivity(i);
        finish();
    }

}
