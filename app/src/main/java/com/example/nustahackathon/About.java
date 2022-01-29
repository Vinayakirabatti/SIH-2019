package com.example.nustahackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class About extends AppCompatActivity
{
 ViewFlipper viewFlipper;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int images[]={R.drawable.slider6,R.drawable.slider7,R.drawable.slider8};
        viewFlipper=findViewById(R.id.view);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
//        if(toggle.onOptionsItemSelected(item))
//        {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
        Intent s=new Intent(About.this,menus.class);
        startActivityForResult(s,0);
        return  true;
    }


    }

