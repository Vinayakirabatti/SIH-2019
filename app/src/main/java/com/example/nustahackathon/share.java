package com.example.nustahackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class share extends AppCompatActivity {
    Button next5,back5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        next5=findViewById(R.id.next5);
        back5=findViewById(R.id.back5);
    }
    public void next5(View view){
        Intent i=new Intent(share.this,Home.class);

        startActivity(i);
        finish();
    }
    public void back5(View view){
        Intent i=new Intent(share.this,pdf.class);

        startActivity(i);
        finish();
    }
}
