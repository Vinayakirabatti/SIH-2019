package com.example.nustahackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class menus extends AppCompatActivity implements View.OnClickListener {
    private CardView home,about,contact,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
        home=findViewById(R.id.home);
        about=findViewById(R.id.aboutus);
        contact=findViewById(R.id.contact);
        login=findViewById(R.id.login);
        home.setOnClickListener(this);
        about.setOnClickListener(this);
        contact.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){

            case R.id.home: i=new Intent(this, Homemain.class);
            startActivity(i);
            break;

            case R.id.aboutus: i=new Intent(this,About.class);
            startActivity(i);
            finish();
            break;
            case R.id.contact: i=new Intent(this,Contact.class);
            startActivity(i);
            break;
            case R.id.login: i=new Intent(this,Alreadyregister.class);
                startActivity(i);
                break;



        }
    }
}
