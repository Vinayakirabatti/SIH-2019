package com.example.nustahackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Fifth extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        tv=findViewById(R.id.tv);
        final String Bank = getIntent().getExtras().getString("Bank");
        final String Reference = getIntent().getExtras().getString("Reference");
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

        final String Buyer = getIntent().getExtras().getString("Buyer");

        final String warenty_coast = getIntent().getExtras().getString("warenty_coast");
        final String transportayion_coast = getIntent().getExtras().getString("transportayion_coast");

        final String rto_expences = getIntent().getExtras().getString("rto_expences");
        final String insurance_cost = getIntent().getExtras().getString("insurance_cost");
        final String taxes_penalty = getIntent().getExtras().getString("taxes_penalty");
        final String refurb_coast = getIntent().getExtras().getString("refurb_coast");
        final String parking_charges = getIntent().getExtras().getString("parking_charges");
        final String total_coast = getIntent().getExtras().getString("total_coast");
        tv.setText(Bank);
    }

    public void Heleo(View view) {

        Intent s=new Intent(Fifth.this,Report.class);
        startActivity(s);
    }
}
