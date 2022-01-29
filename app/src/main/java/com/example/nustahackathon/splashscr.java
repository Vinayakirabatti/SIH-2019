package com.example.nustahackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splashscr extends AppCompatActivity {
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.aich_main);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.splashscr);
        ImageView img = (ImageView) findViewById(R.id.img);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        img.startAnimation(myanim);
        Thread td = new Thread() {

            public void run() {
                try {
                    sleep(5000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    Intent it = new Intent(splashscr.this, menus.class);
                    startActivity(it);
                    finish();

                }


            }

        };
        td.start();


    }

}
