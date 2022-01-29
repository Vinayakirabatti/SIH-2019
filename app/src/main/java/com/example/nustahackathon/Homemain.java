package com.example.nustahackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Homemain extends AppCompatActivity  {
    private ViewFlipper mViewFlipper;
    private GestureDetector mGestureDetector;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homemain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Add all the images to the ViewFlipper

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i=new Intent(this,menus.class);
        startActivityForResult(i,0);
        return true;
    }



}