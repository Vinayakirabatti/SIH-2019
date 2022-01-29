package com.example.nustahackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class pdf extends AppCompatActivity {
    Button next3,back3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        next3=findViewById(R.id.next3);
        back3=findViewById(R.id.back3);
    }
    public void next3(View view){
        Intent i=new Intent(pdf.this,share.class);

        startActivity(i);
        finish();
    }
    public void back3(View view){
        Intent i=new Intent(pdf.this,digital.class);

        startActivity(i);
        finish();
    }
}
