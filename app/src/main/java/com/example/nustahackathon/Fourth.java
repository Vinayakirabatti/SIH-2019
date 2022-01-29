package com.example.nustahackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.ref.Reference;

import fr.ganfra.materialspinner.MaterialSpinner;

public class Fourth extends AppCompatActivity {
    EditText rating;
    TextView textView;
    Button finaltext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);



        final String Reference = getIntent().getExtras().getString("Reference");
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

        final String buyer = getIntent().getExtras().getString("Buyer");

        final String warenty_coast = getIntent().getExtras().getString("warenty_coast");
        final String transportayion_coast = getIntent().getExtras().getString("transportayion_coast");

        final String rto_expences = getIntent().getExtras().getString("rto_expences");
        final String insurance_cost = getIntent().getExtras().getString("insurance_cost");
        final String taxes_penalty = getIntent().getExtras().getString("taxes_penalty");
        final String refurb_coast = getIntent().getExtras().getString("refurb_coast");
        final String parking_charges = getIntent().getExtras().getString("parking_charges");
        final String total_coast = getIntent().getExtras().getString("total_coast");


   finaltext=findViewById(R.id.finaltext);

   MaterialSpinner Silencer = findViewById(R.id.Silencer);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Silencer.setAdapter(adapter);

        MaterialSpinner Abnormal_Engine_Noise = findViewById(R.id.Abnormal_Engine_Noise);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Abnormal_Engine_Noise.setAdapter(adapter1);
//
        MaterialSpinner Plugs = findViewById(R.id.Plugs);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Plugs.setAdapter(adapter2);
//
        Spinner Oil = findViewById(R.id.Oil);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Oil.setAdapter(adapter3);

        Spinner Radiator_Condenser = findViewById(R.id.Radiator_Condenser);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Radiator_Condenser.setAdapter(adapter4);

        MaterialSpinner Oil_Leakage = findViewById(R.id.Oil_Leakage);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Oil_Leakage.setAdapter(adapter5);

        MaterialSpinner Fan_Belts = findViewById(R.id.Fan_Belts);
        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Fan_Belts.setAdapter(adapter6);

        MaterialSpinner Filters = findViewById(R.id.Filters);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Filters.setAdapter(adapter7);

        MaterialSpinner Suspension_Noise_WhileDriving_Front_Rear = findViewById(R.id.Suspension_Noise_WhileDriving_Front_Rear);
        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Suspension_Noise_WhileDriving_Front_Rear.setAdapter(adapter8);

        MaterialSpinner Steering_Lock = findViewById(R.id.Steering_Lock);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Steering_Lock.setAdapter(adapter9);

        MaterialSpinner Wheel_Alignment_Balancing_Wobbling = findViewById(R.id.Wheel_Alignment_Balancing_Wobbling);
        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Wheel_Alignment_Balancing_Wobbling.setAdapter(adapter10);

        MaterialSpinner Steering_Operation = findViewById(R.id.Steering_Operation);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Steering_Operation.setAdapter(adapter11);

        MaterialSpinner Pedal_Operation = findViewById(R.id.Pedal_Operation);
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Pedal_Operation.setAdapter(adapter12);

        MaterialSpinner Brakes_and_Hand_Brake = findViewById(R.id.Brakes_and_Hand_Brake);
        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Brakes_and_Hand_Brake.setAdapter(adapter13);

        MaterialSpinner Gear_Engagement = findViewById(R.id.Gear_Engagement);
        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Gear_Engagement.setAdapter(adapter14);

        MaterialSpinner Differential_And_Crown_RearWheel_Drive = findViewById(R.id.Differential_And_Crown_RearWheel_Drive);
        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Differential_And_Crown_RearWheel_Drive.setAdapter(adapter15);

        MaterialSpinner Instrument_Cluster_WarningLights_Gauges = findViewById(R.id.Instrument_Cluster_WarningLights_Gauges);
        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Instrument_Cluster_WarningLights_Gauges.setAdapter(adapter16);

        MaterialSpinner Alternator = findViewById(R.id.Alternator);
        ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Alternator.setAdapter(adapter17);

//        Spinner Fuel_Pump = findViewById(R.id.Fuel_Pump);
//        ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Fuel_Pump.setAdapter(adapter18);
//
//        Spinner Battery_Condition = findViewById(R.id.Battery_Condition);
//        ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Battery_Condition.setAdapter(adapter19);
//
//        Spinner Starter_Motor = findViewById(R.id.Starter_Motor);
//        ArrayAdapter<CharSequence> adapter20 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Starter_Motor.setAdapter(adapter20);
//
//        Spinner Cooling = findViewById(R.id.Cooling);
//        ArrayAdapter<CharSequence> adapter21 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Cooling.setAdapter(adapter21);
//
//        Spinner Heating = findViewById(R.id.Heating);
//        ArrayAdapter<CharSequence> adapter22 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Heating.setAdapter(adapter22);
//
//        Spinner Frame_Underbody = findViewById(R.id.Frame_Underbody);
//        ArrayAdapter<CharSequence> adapter23 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Frame_Underbody.setAdapter(adapter23);
//
//        Spinner Wind_screen = findViewById(R.id.Wind_screen);
//        ArrayAdapter<CharSequence> adapter24 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Wind_screen.setAdapter(adapter24);
//
//        Spinner Wiper_Blades = findViewById(R.id.Wiper_Blades);
//        ArrayAdapter<CharSequence> adapter25 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Wiper_Blades.setAdapter(adapter25);
//
//        Spinner Indicators = findViewById(R.id.Indicators);
//        ArrayAdapter<CharSequence> adapter26 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Indicators.setAdapter(adapter26);
//
//        Spinner Headlights = findViewById(R.id.Headlights);
//        ArrayAdapter<CharSequence> adapter27 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Headlights.setAdapter(adapter27);
//
//        Spinner Internal_Rear_View_Mirrors = findViewById(R.id.Internal_Rear_View_Mirrors);
//        ArrayAdapter<CharSequence> adapter28 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Internal_Rear_View_Mirrors.setAdapter(adapter28);
//
//        Spinner Tail_Lights = findViewById(R.id.Tail_Lights);
//        ArrayAdapter<CharSequence> adapter29 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Tail_Lights.setAdapter(adapter29);
//
//        Spinner Power_Windows_Front = findViewById(R.id.Power_Windows_Front);
//        ArrayAdapter<CharSequence> adapter30 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Power_Windows_Front.setAdapter(adapter30);
//
//        Spinner Central_Locking = findViewById(R.id.Central_Locking);
//        ArrayAdapter<CharSequence> adapter31 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Central_Locking.setAdapter(adapter31);
//
//        Spinner Toolkit = findViewById(R.id.Toolkit);
//        ArrayAdapter<CharSequence> adapter32 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Toolkit.setAdapter(adapter32);
//
//        Spinner Power_Windows_Back = findViewById(R.id.Power_Windows_Back);
//        ArrayAdapter<CharSequence> adapter33 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Power_Windows_Back.setAdapter(adapter33);
//
//        Spinner Condition_of_Seats = findViewById(R.id.Condition_of_Seats);
//        ArrayAdapter<CharSequence> adapter34 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Condition_of_Seats.setAdapter(adapter34);
//
//        Spinner Horn = findViewById(R.id.Horn);
//        ArrayAdapter<CharSequence> adapter35 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Horn.setAdapter(adapter35);
//
//        Spinner Roof_Wear_Tear = findViewById(R.id.Roof_Wear_Tear);
//        ArrayAdapter<CharSequence> adapter36 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Roof_Wear_Tear.setAdapter(adapter36);
//
//        Spinner Headlamp_Indicator_Switches = findViewById(R.id.Headlamp_Indicator_Switches);
//        ArrayAdapter<CharSequence> adapter37 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Headlamp_Indicator_Switches.setAdapter(adapter37);
//
//        Spinner Wheel_Right_Front = findViewById(R.id.Wheel_Right_Front);
//        ArrayAdapter<CharSequence> adapter38 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Wheel_Right_Front.setAdapter(adapter38);
//
//        Spinner Wheel_Right_Rear = findViewById(R.id.Wheel_Right_Rear);
//        ArrayAdapter<CharSequence> adapter39 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Wheel_Right_Rear.setAdapter(adapter39);
//
//        Spinner Wheel_Left_Front = findViewById(R.id.Wheel_Left_Front);
//        ArrayAdapter<CharSequence> adapter40 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Wheel_Left_Front.setAdapter(adapter40);
//
//        Spinner Wheel_Left_Rear = findViewById(R.id.Wheel_Left_Rear);
//        ArrayAdapter<CharSequence> adapter41 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Wheel_Left_Rear.setAdapter(adapter41);
//
//        Spinner Wheel_Stephaney = findViewById(R.id.Wheel_Stephaney);
//        ArrayAdapter<CharSequence> adapter42 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Wheel_Stephaney.setAdapter(adapter42);
//
//        Spinner Seat_Covers = findViewById(R.id.Seat_Covers);
//        ArrayAdapter<CharSequence> adapter43 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Seat_Covers.setAdapter(adapter43);
//
//        Spinner Fog_Lamps = findViewById(R.id.Fog_Lamps);
//        ArrayAdapter<CharSequence> adapter44 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Fog_Lamps.setAdapter(adapter44);
//
//        Spinner Music_System = findViewById(R.id.Music_System);
//        ArrayAdapter<CharSequence> adapter45 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Music_System.setAdapter(adapter45);
//
//        Spinner Floor_Mats = findViewById(R.id.Floor_Mats);
//        ArrayAdapter<CharSequence> adapter46 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Floor_Mats.setAdapter(adapter46);
//
//        Spinner Speakers = findViewById(R.id.Speakers);
//        ArrayAdapter<CharSequence> adapter47 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Speakers.setAdapter(adapter47);
//
//        Spinner Tipping_Systems = findViewById(R.id.Tipping_Systems);
//        ArrayAdapter<CharSequence> adapter48 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Tipping_Systems.setAdapter(adapter48);
//
//        Spinner Odometer = findViewById(R.id.Odometer);
//        ArrayAdapter<CharSequence> adapter49 = ArrayAdapter.createFromResource(this, R.array.values, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        Odometer.setAdapter(adapter49);
//
//        rating = findViewById(R.id.rating);
        finaltext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(Fourth.this,Report.class);
                intent.putExtra("Reference",Reference);
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




                intent.putExtra("Buyer",buyer);
                intent.putExtra("warenty_coast",warenty_coast);
                intent.putExtra("transportayion_coast",transportayion_coast);
                intent.putExtra("rto_expences",rto_expences);

                intent.putExtra("insurance_cost",insurance_cost);
                intent.putExtra("taxes_penalty",taxes_penalty);
                intent.putExtra("refurb_coast",refurb_coast);
                intent.putExtra("parking_charges",parking_charges);
                intent.putExtra("total_coast",total_coast);






                startActivity(intent);
            }
        });

    }



}