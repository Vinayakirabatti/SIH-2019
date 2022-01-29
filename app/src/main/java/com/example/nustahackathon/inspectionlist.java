package com.example.nustahackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class inspectionlist extends AppCompatActivity {
    Button home;
 static String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspectionlist);


        user = getIntent().getExtras().getString("user");

        home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(inspectionlist.this,Home.class);
//

                startActivity(intent);
            }
        });
    }

    public void AssetDescription(View view) {

//

            Intent s=new Intent(inspectionlist.this,Spinner.class);
            startActivity(s);

    }

    public void Valuation(View view) {
        Intent s=new Intent(inspectionlist.this,s.class);
        startActivity(s);
    }

    public void CostTobidder(View view) {

        Intent s=new Intent(inspectionlist.this,ThirdForm.class);
        startActivity(s);

    }

    public void Home(View view) {

        Intent intent=new Intent(inspectionlist.this,Home.class);

        final String purpose = getIntent().getExtras().getString("purpose");
        final String Bank = getIntent().getExtras().getString("Bank");
        final String Contractno = getIntent().getExtras().getString("Contractno");
        final String Requestfrom = getIntent().getExtras().getString("Requestfrom");
        final String AssetMake = getIntent().getExtras().getString("AssetMake");
        final String AssetModel = getIntent().getExtras().getString("AssetModel");
        final String Yearofmfg = getIntent().getExtras().getString("Yearofmfg");
        final String HMRKMR = getIntent().getExtras().getString("HMRKMR");
        final String ChassisNumber = getIntent().getExtras().getString("ChassisNumber");
        final String EngineNumber = getIntent().getExtras().getString("EngineNumber");
        final String Inspector = getIntent().getExtras().getString("Inspector");
        final String Location = getIntent().getExtras().getString("Location");
        final String RCFitnessValid = getIntent().getExtras().getString("RCFitnessValid");
        final String TaxStatus = getIntent().getExtras().getString("TaxStatus");
        intent.putExtra("purpose",purpose);
        intent.putExtra("Bank",Bank);
        intent.putExtra("Contractno",Contractno);
        intent.putExtra("Requestfrom",Requestfrom);
        intent.putExtra("AssetMake",AssetMake);
        intent.putExtra("AssetModel",AssetModel);
        intent.putExtra("Yearofmfg",Yearofmfg);
        intent.putExtra("HMRKMR",HMRKMR);
        intent.putExtra("ChassisNumber",ChassisNumber);
        intent.putExtra("EngineNumber",EngineNumber);
        intent.putExtra("Inspector",Inspector);
        intent.putExtra("Location",Location);
        intent.putExtra("RCFitnessValid",RCFitnessValid);
        intent.putExtra("TaxStatus",TaxStatus);
        startActivity(intent);
    }

    public void Camera(View view) {
        Intent s=new Intent(inspectionlist.this,Camera.class);
        startActivity(s);

    }

    public void pdf(View view) {
        Intent s=new Intent(inspectionlist.this,Report1.class);
        startActivity(s);
    }
}
