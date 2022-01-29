package com.example.nustahackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class cameratut extends AppCompatActivity {
    Button next2,back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cameratut);
        next2=findViewById(R.id.next2);
    }
    public void next2(View view){
        Intent i=new Intent(cameratut.this,digital.class);

        startActivity(i);
        finish();
    }
    public void back2(View view){
        Intent i=new Intent(cameratut.this,cost.class);

        startActivity(i);
        finish();
    }
}
