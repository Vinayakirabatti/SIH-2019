package com.example.nustahackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class digital extends AppCompatActivity {
    Button next4,back4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital);
        next4=findViewById(R.id.next4);
        back4=findViewById(R.id.back4);
    }
    public void next4(View view){
        Intent i=new Intent(digital.this,pdf.class);

        startActivity(i);
        finish();
    }
    public void back4(View view){
        Intent i=new Intent(digital.this, cameratut.class);

        startActivity(i);
        finish();
    }
}
