package com.example.nustahackathon;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.core.Platform;

public class Home extends AppCompatActivity {
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mtoggle;
    ImageView report;
    CardView Inspectorc;
    private Toast backtoast;
    long backPressedTime;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mdrawerLayout = findViewById(R.id.drawer);

        mtoggle = new ActionBarDrawerToggle(this, mdrawerLayout,R.string.open,R.string.close);
        mdrawerLayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
//
         long backPressedTime = 0;



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Inspectorc=findViewById(R.id.inspectorc);
        mdrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mtoggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Inspection(View view) {
        Intent s=new Intent(Home.this,inspectionlist.class);
        startActivity(s);

    }

    public void Report(View view) {
        Intent intent=new Intent(Home.this,Report.class);
//        final String purpose;
//        if(getIntent().getExtras().getString("purpose") == null ){
//            Log.e("null","pur");
//            purpose = "a";
//        }else {
//            purpose = getIntent().getExtras().getString("purpose");
//        }


//        final String Bank = getIntent().getExtras().getString("Bank");
//        final String Contractno = getIntent().getExtras().getString("Contractno");
//        final String Requestfrom = getIntent().getExtras().getString("Requestfrom");
//        final String AssetMake = getIntent().getExtras().getString("AssetMake");
//        final String AssetModel = getIntent().getExtras().getString("AssetModel");
//        final String Yearofmfg = getIntent().getExtras().getString("Yearofmfg");
//        final String HMRKMR = getIntent().getExtras().getString("HMRKMR");
//        final String ChassisNumber = getIntent().getExtras().getString("ChassisNumber");
//        final String EngineNumber = getIntent().getExtras().getString("EngineNumber");
//        final String Inspector = getIntent().getExtras().getString("Inspector");
//        final String Location = getIntent().getExtras().getString("Location");
//        final String RCFitnessValid = getIntent().getExtras().getString("RCFitnessValid");
//        final String TaxStatus = getIntent().getExtras().getString("TaxStatus");
//        intent.putExtra("purpose",purpose);
        
//        intent.putExtra("Bank",Bank);
//        intent.putExtra("Contractno",Contractno);
//        intent.putExtra("Requestfrom",Requestfrom);
//        intent.putExtra("AssetMake",AssetMake);
//        intent.putExtra("AssetModel",AssetModel);
//        intent.putExtra("Yearofmfg",Yearofmfg);
//        intent.putExtra("HMRKMR",HMRKMR);
//        intent.putExtra("ChassisNumber",ChassisNumber);
//        intent.putExtra("EngineNumber",EngineNumber);
//        intent.putExtra("Inspector",Inspector);
//        intent.putExtra("Location",Location);
//        intent.putExtra("RCFitnessValid",RCFitnessValid);
//        intent.putExtra("TaxStatus",TaxStatus);
        startActivity(intent);

    }

    public void tutorial(View view) {
        Intent s=new Intent(Home.this,reporttut.class);
        startActivity(s);
    }
    @Override
    public void onBackPressed(){        // to prevent irritating accidental logouts

        alertDialog.setMessage("You want to Exit?");
        AlertDialog.Builder builder=new AlertDialog.Builder(Home.this);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Home.this, "Exited", Toast.LENGTH_SHORT).show();
                System.exit(1);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getApplicationContext();
            }
        });

    }

    public void admin(View view) {
        Intent i  = new Intent(Home.this,Signature.class);
        startActivity(i);


    }
}
