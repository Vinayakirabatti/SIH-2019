package com.example.nustahackathon;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fr.ganfra.materialspinner.MaterialSpinner;

public class Spinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private GridLayout mainGrid;
    private String g;
    private String silencer="",engine="",plugs="",oil="",radiator_condenser="",oil_leakage ="",fan_belts="",filters="",suspension_noise_whileDriving_front_rear="",steering_lock="",wheel_alignment_balancing_wobbling="",steering_operation="",pedal_operation="",brakes_and_hand_brake="",gear_engagement="",differential_and_crown_rearWheel_drive="",instrument_cluster_warningLights_gauges="",alternator="",fuel_pump="",battery_condition="",starter_motar="",cooling="",heating="",frame_underbody="",wind_screen="",wiper_blades="",indicators="",headlights="",internal_rear_view_mirrors="",tail_lights="",power_windows_front="",power_windows_back="",central_locking="",toolkit="",tower_Windows_Back="",condition_of_Seats="",horn="";
    private String roof_Wear_and_Tear="",headlamp_Indicator_Switches="", wheel_RightFront="", wheel_RightRear="",wheel_LeftFront="",wheel_LeftRear="",wheel_Stephaney="",seat_Covers ="",fog_Lamps="" ,music_System="",floor_Mats="",speakers="",odometer="",tipping="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mainGrid = findViewById(R.id.maingrid);
        setSingleEvent(mainGrid);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(Spinner.this,inspectionlist.class);
        startActivityForResult(i,0);
        return true;
    }
    public void setSingleEvent(final GridLayout mainGrid) {
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int ii = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    // Toast.makeText(Spinner.this, "this"+ii, Toast.LENGTH_SHORT).show();
                    if (ii == 0) {
                        final Dialog dialog=new Dialog(Spinner.this);
                        dialog.setContentView(R.layout.popup);
                        dialog.setTitle("Engine");

                        MaterialSpinner Silencer = dialog.findViewById(R.id.Silencer);
                        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Silencer.setAdapter(adapter);
                        if(silencer!="") {
                            int pos = adapter.getPosition(silencer);
                            pos++;
                            Silencer.setSelection(pos);
                        }

                        final MaterialSpinner Abnormal_Engine_Noise = dialog.findViewById(R.id.Abnormal_Engine_Noise);
                        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Abnormal_Engine_Noise.setAdapter(adapter1);
                        if(engine != "" ) {
                            int pos = adapter.getPosition(engine);
                            pos++;
                            Abnormal_Engine_Noise.setSelection(pos);
                        }

                        MaterialSpinner Plugs = dialog.findViewById(R.id.Plugs);
                        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Plugs.setAdapter(adapter2);
                        if(plugs != "" ) {
                            int pos = adapter.getPosition(plugs);
                            pos++;
                            Plugs.setSelection(pos);
                        }
//
                        MaterialSpinner Oil = dialog.findViewById(R.id.Oil);
                        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Oil.setAdapter(adapter3);
                        if(oil != "" ) {
                            int pos = adapter.getPosition(oil);
                            pos++;
                            Oil.setSelection(pos);
                        }

                        MaterialSpinner Radiator_Condenser = dialog.findViewById(R.id.Radiator_Condenser);
                        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Radiator_Condenser.setAdapter(adapter4);
                        if(radiator_condenser != "" ) {
                            int pos = adapter.getPosition(radiator_condenser);
                            pos++;
                            Radiator_Condenser.setSelection(pos);
                        }
//
                        MaterialSpinner Oil_Leakage = dialog.findViewById(R.id.Oil_Leakage);
                        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Oil_Leakage.setAdapter(adapter5);
                        if(oil_leakage != "" ) {
                            int pos = adapter.getPosition(oil_leakage);
                            pos++;
                            Oil_Leakage.setSelection(pos);
                        }

                        MaterialSpinner Fan_Belts = dialog.findViewById(R.id.Fan_Belts);
                        ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Fan_Belts.setAdapter(adapter6);
                        if(fan_belts != "" ) {
                            int pos = adapter.getPosition(fan_belts);
                            pos++;
                            Fan_Belts.setSelection(pos);
                        }
//
                        MaterialSpinner Filters = dialog.findViewById(R.id.Filters);
                        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Filters.setAdapter(adapter7);
                        if(filters != "" ) {
                            int pos = adapter.getPosition(filters);
                            pos++;
                            Filters.setSelection(pos);
                        }

                        Silencer.setOnItemSelectedListener(Spinner.this);
                        Abnormal_Engine_Noise.setOnItemSelectedListener(Spinner.this);
                        Plugs.setOnItemSelectedListener(Spinner.this);
                        Oil.setOnItemSelectedListener(Spinner.this);
                        Radiator_Condenser.setOnItemSelectedListener(Spinner.this);
                        Oil_Leakage.setOnItemSelectedListener(Spinner.this);
                        Fan_Belts.setOnItemSelectedListener(Spinner.this);
                        Filters.setOnItemSelectedListener(Spinner.this);
//



                        Button save;
                        save=dialog.findViewById(R.id.save7);
                        save.setOnClickListener(new View.OnClickListener() {
               String httpurl="http://192.168.43.16/Hackathon/InsertEngine.php";
            //String httpurl="http://192.168.1.5/Hackathon/InsertEngine.php";

                            @Override
                            public void onClick(View v) {
                                StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl,
                                        new com.android.volley.Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                if (response !="error"){

                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_SHORT).show();
                                                    //tempvalues.cost_to_bidder_id = response;
                                                }else {
                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_LONG).show();
                                                    Log.e("sql",response);

                                                }
                                            }
                                        },
                                        new com.android.volley.Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                //Toast.makeText(MainActivity.this, (CharSequence) error, Toast.LENGTH_LONG).show();
                                                Log.e(String.valueOf(error), "error");
                                            }
                                        }) {
                                    @Override
                                    protected Map<String, String> getParams() {
                                        Map<String, String> params = new HashMap<String, String>();
                                        params.put("mainid",tempvalues.mainid);
                                        //params.put("mainid","1");
                                        Log.e(tempvalues.mainid+":"+silencer,":"+engine+":"+plugs+":"+oil+":"+radiator_condenser+":"+oil_leakage+":"+fan_belts+":"+filters);
                                        params.put("assessors","Engine");
                                        params.put("Silencer", silencer);
                                        params.put("Abnormal_Engine_Noise", engine);
                                        params.put("Plugs", plugs);
                                        params.put("Oil", oil);
                                        params.put("Radiator_Condenser", radiator_condenser);
                                        params.put("Oil_Leakage", oil_leakage);
                                        params.put("Fan_Belts", fan_belts);
                                        params.put("Filters", filters);



                                        return params;
                                    }
                                };
                                // Creating RequestQueue.
                                RequestQueue requestQueue = Volley.newRequestQueue(Spinner.this);

                                // Adding the StringRequest object into requestQueue.
                                requestQueue.add(stringRequest);
                                Intent s=new Intent(Spinner.this,Spinner.class);
                                startActivity(s);
                                finish();
                            }


                        });
                        dialog.show();

                    } else if (ii == 1) {
                        final Dialog dialog=new Dialog(Spinner.this);
                        dialog.setContentView(R.layout.suspention);
                        dialog.setTitle("Suspension");



                        MaterialSpinner Suspension_Noise_WhileDriving_Front_Rear = dialog.findViewById(R.id.Suspension_Noise_WhileDriving_Front_Rear);
                        ArrayAdapter<CharSequence> adapter8 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Suspension_Noise_WhileDriving_Front_Rear.setAdapter(adapter8);
                        if(suspension_noise_whileDriving_front_rear != "" ) {
                            int pos = adapter8.getPosition(suspension_noise_whileDriving_front_rear);
                            pos++;
                            Suspension_Noise_WhileDriving_Front_Rear.setSelection(pos);
                        }



                        Suspension_Noise_WhileDriving_Front_Rear.setOnItemSelectedListener(Spinner.this);



                        Button save1;
                        save1=dialog.findViewById(R.id.save9);
                        save1.setOnClickListener(new View.OnClickListener() {
                            String httpurl1="http://192.168.43.16/Hackathon/Suspensioninsert.php";
                           //String httpurl1="http://192.168.1.5/Hackathon/Suspensioninsert.php";
                            @Override
                            public void onClick(View v) {


                                StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl1,
                                        new com.android.volley.Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                if (response !="error"){

                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_SHORT).show();
                                                    //tempvalues.cost_to_bidder_id = response;
                                                }else {
                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_LONG).show();
                                                    Log.e("sql",response);

                                                }
                                            }
                                        },
                                        new com.android.volley.Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                //Toast.makeText(MainActivity.this, (CharSequence) error, Toast.LENGTH_LONG).show();
                                                Log.e(String.valueOf(error), "error");
                                            }
                                        }) {
                                    @Override
                                    protected Map<String, String> getParams() {
                                        Map<String, String> params = new HashMap<String, String>();
                                        params.put("mainid",tempvalues.mainid);
                                        //params.put("mainid","1");
                                        params.put("assessors","Suspension ");
                                        params.put("Suspension_Noise_WhileDriving_Front_Rear", suspension_noise_whileDriving_front_rear);

                                        return params;
                                    }
                                };
                                // Creating RequestQueue.
                                RequestQueue requestQueue = Volley.newRequestQueue(Spinner.this);

                                // Adding the StringRequest object into requestQueue.
                                requestQueue.add(stringRequest);
                                Intent s=new Intent(Spinner.this,Spinner.class);
                                startActivity(s);
                            }


                        });
                        dialog.show();

                    } else if (ii == 2) {
                        final Dialog dialog=new Dialog(Spinner.this);
                        dialog.setContentView(R.layout.steering);
                        dialog.setTitle("Steering");


                        MaterialSpinner Steering_Lock = dialog.findViewById(R.id.Steering_Lock);
                        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Steering_Lock.setAdapter(adapter10);
                        if(steering_lock != "" ) {
                            int pos = adapter10.getPosition(steering_lock);
                            pos++;
                            Steering_Lock.setSelection(pos);
                        }

                        MaterialSpinner Wheel_Alignment_Balancing_Wobbling = dialog.findViewById(R.id.Wheel_Alignment_Balancing_Wobbling);
                        ArrayAdapter<CharSequence> adapter98 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter98.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Wheel_Alignment_Balancing_Wobbling.setAdapter(adapter10);
                        if(wheel_alignment_balancing_wobbling != "" ) {
                            int pos = adapter98.getPosition(wheel_alignment_balancing_wobbling);
                            pos++;
                            Wheel_Alignment_Balancing_Wobbling.setSelection(pos);
                        }

                        MaterialSpinner Steering_Operation = dialog.findViewById(R.id.Steering_Operation);
                        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Steering_Operation.setAdapter(adapter11);
                        if(steering_operation != "" ) {
                            int pos = adapter11.getPosition(steering_operation);
                            pos++;
                            Steering_Operation.setSelection(pos);
                        }


                        Wheel_Alignment_Balancing_Wobbling.setOnItemSelectedListener(Spinner.this);
                        Steering_Operation.setOnItemSelectedListener(Spinner.this);
                        Steering_Lock.setOnItemSelectedListener(Spinner.this);




                        Button save;
                        save=dialog.findViewById(R.id.save8);
                        save.setOnClickListener(new View.OnClickListener() {
                           // String httpurl2="http://192.168.1.5/Hackathon/insertSteering.php";
                            String httpurl2="http://192.168.43.16/Hackathon/insertSteering.php";
                            @Override
                            public void onClick(View v) {

                                StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl2,
                                        new com.android.volley.Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                if (response !="error"){

                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_SHORT).show();
                                                    //tempvalues.cost_to_bidder_id = response;
                                                }else {
                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_LONG).show();
                                                    Log.e("sql",response);

                                                }
                                            }
                                        },
                                        new com.android.volley.Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                //Toast.makeText(MainActivity.this, (CharSequence) error, Toast.LENGTH_LONG).show();
                                                Log.e(String.valueOf(error), "error");
                                            }
                                        }) {
                                    @Override
                                    protected Map<String, String> getParams() {
                                        Map<String, String> params = new HashMap<String, String>();
                                        params.put("mainid",tempvalues.mainid);
                                        //params.put("mainid","1");
                                        params.put("assessors","Steering");
                                        params.put("Steering_Lock", steering_lock);
                                        params.put("Wheel_Alignment_Balancing_Wobbling", wheel_alignment_balancing_wobbling);
                                        params.put("Steering_Operation", steering_operation);

                                        return params;
                                    }
                                };
                                // Creating RequestQueue.
                                RequestQueue requestQueue = Volley.newRequestQueue(Spinner.this);

                                // Adding the StringRequest object into requestQueue.
                                requestQueue.add(stringRequest);
                                Intent s=new Intent(Spinner.this,Spinner.class);
                                startActivity(s);




                            }


                        });
                        dialog.show();






                    } else if (ii == 3) {
                        final Dialog dialog=new Dialog(Spinner.this);
                        dialog.setContentView(R.layout.brakes);
                        dialog.setTitle("Brakes");


                        MaterialSpinner Pedal_Operation = dialog.findViewById(R.id.Pedal_Operation);
                        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Pedal_Operation.setAdapter(adapter12);
                        if(pedal_operation != "" ) {
                            int pos = adapter12.getPosition(pedal_operation);
                            pos++;
                            Pedal_Operation.setSelection(pos);
                        }

                        MaterialSpinner Brakes_and_Hand_Brake = dialog.findViewById(R.id.Brakes_and_Hand_Brake);
                        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Brakes_and_Hand_Brake.setAdapter(adapter13);
                        if(brakes_and_hand_brake != "" ) {
                            int pos = adapter13.getPosition(brakes_and_hand_brake);
                            pos++;
                            Brakes_and_Hand_Brake.setSelection(pos);
                        }




                        Pedal_Operation.setOnItemSelectedListener(Spinner.this);
                        Brakes_and_Hand_Brake.setOnItemSelectedListener(Spinner.this);



                        Button save;
                        save=dialog.findViewById(R.id.save3);
                        save.setOnClickListener(new View.OnClickListener() {
                            String httpurl3="http://192.168.43.16/Hackathon/insertBrakes.php";
                           // String httpurl3="http://192.168.1.5/Hackathon/insertBrakes.php";
                            @Override
                            public void onClick(View v) {
                                StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl3,
                                        new com.android.volley.Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                if (response !="error"){

                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_SHORT).show();
                                                    //tempvalues.cost_to_bidder_id = response;
                                                }else {
                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_LONG).show();
                                                    Log.e("sql",response);

                                                }
                                            }
                                        },
                                        new com.android.volley.Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                //Toast.makeText(MainActivity.this, (CharSequence) error, Toast.LENGTH_LONG).show();
                                                Log.e(String.valueOf(error), "error");
                                            }
                                        }) {
                                    @Override
                                    protected Map<String, String> getParams() {
                                        Map<String, String> params = new HashMap<String, String>();
                                        params.put("mainid",tempvalues.mainid);
                                        //params.put("mainid","1");
                                        params.put("assessors","Brakes");
                                        params.put("Pedal_Operation", pedal_operation);
                                        params.put("Brakes_and_Hand_Brake", brakes_and_hand_brake);

                                        return params;
                                    }
                                };
                                // Creating RequestQueue.
                                RequestQueue requestQueue = Volley.newRequestQueue(Spinner.this);

                                // Adding the StringRequest object into requestQueue.
                                requestQueue.add(stringRequest);
                                Intent s=new Intent(Spinner.this,Spinner.class);
                                startActivity(s);


                            }


                        });
                        dialog.show();

                    } else if (ii == 4) {
                        final Dialog dialog=new Dialog(Spinner.this);
                        dialog.setContentView(R.layout.transmission);
                        dialog.setTitle("Transmission");



                        MaterialSpinner Gear_Engagement = dialog.findViewById(R.id.Gear_Engagement);
                        ArrayAdapter<CharSequence> adapter14 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Gear_Engagement.setAdapter(adapter14);
                        if(gear_engagement != "" ) {
                            int pos = adapter14.getPosition(gear_engagement);
                            pos++;
                            Gear_Engagement.setSelection(pos);
                        }

                        MaterialSpinner Differential_And_Crown_RearWheel_Drive = dialog.findViewById(R.id.Differential_And_Crown_RearWheel_Drive);
                        ArrayAdapter<CharSequence> adapter15 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Differential_And_Crown_RearWheel_Drive.setAdapter(adapter15);
                        if(differential_and_crown_rearWheel_drive != "" ) {
                            int pos = adapter15.getPosition(differential_and_crown_rearWheel_drive);
                            pos++;
                            Differential_And_Crown_RearWheel_Drive.setSelection(pos);
                        }


                        Gear_Engagement.setOnItemSelectedListener(Spinner.this);
                        Differential_And_Crown_RearWheel_Drive.setOnItemSelectedListener(Spinner.this);



                        Button save;
                        save=dialog.findViewById(R.id.save10);
                        save.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String httpurl4="http://192.168.43.16/Hackathon/insertTransmission.php";
                                //String httpurl4="http://192.168.1.5/Hackathon/insertTransmission.php";
                                StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl4,
                                        new com.android.volley.Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                if (response !="error"){

                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_SHORT).show();
                                                    //tempvalues.cost_to_bidder_id = response;
                                                }else {
                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_LONG).show();
                                                    Log.e("sql",response);

                                                }
                                            }
                                        },
                                        new com.android.volley.Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                //Toast.makeText(MainActivity.this, (CharSequence) error, Toast.LENGTH_LONG).show();
                                                Log.e(String.valueOf(error), "error");
                                            }
                                        }) {
                                    @Override
                                    protected Map<String, String> getParams() {
                                        Map<String, String> params = new HashMap<String, String>();
                                        params.put("mainid",tempvalues.mainid);
                                        //params.put("mainid","1");
                                        params.put("assessors","Transmission");
                                        params.put("Gear_Engagement", gear_engagement);
                                        params.put("Differential_And_Crown_RearWheel_Drive", differential_and_crown_rearWheel_drive);

                                        return params;
                                    }
                                };
                                // Creating RequestQueue.
                                RequestQueue requestQueue = Volley.newRequestQueue(Spinner.this);

                                // Adding the StringRequest object into requestQueue.
                                requestQueue.add(stringRequest);
                                Intent s=new Intent(Spinner.this,Spinner.class);
                                startActivity(s);



                            }


                        });
                        dialog.show();
                    }








                    else if (ii==5){
                        final Dialog dialog=new Dialog(Spinner.this);
                        dialog.setContentView(R.layout.electrical);
                        dialog.setTitle("Electrical");



                        MaterialSpinner Instrument_Cluster_WarningLights_Gauges = dialog.findViewById(R.id.Instrument_Cluster_WarningLights_Gauges);
                        ArrayAdapter<CharSequence> adapter16 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Instrument_Cluster_WarningLights_Gauges.setAdapter(adapter16);
                        if(instrument_cluster_warningLights_gauges != "" ) {
                            int pos = adapter16.getPosition(instrument_cluster_warningLights_gauges);
                            pos++;
                            Instrument_Cluster_WarningLights_Gauges.setSelection(pos);
                        }

                        MaterialSpinner Alternator = dialog.findViewById(R.id.Alternator);
                        ArrayAdapter<CharSequence> adapter17 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Alternator.setAdapter(adapter17);
                        if(alternator != "" ) {
                            int pos = adapter17.getPosition(alternator);
                            pos++;
                            Alternator.setSelection(pos);
                        }
                        MaterialSpinner Fuel_Pump = dialog.findViewById(R.id.Fuel_Pump);
                        ArrayAdapter<CharSequence> adapter18 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Fuel_Pump.setAdapter(adapter18);
                        if(fuel_pump != "" ) {
                            int pos = adapter18.getPosition(fuel_pump);
                            pos++;
                            Fuel_Pump.setSelection(pos);
                        }

                        MaterialSpinner Battery_Condition = dialog.findViewById(R.id.Battery_Condition);
                        ArrayAdapter<CharSequence> adapter19 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Battery_Condition.setAdapter(adapter19);
                        if(battery_condition != "" ) {
                            int pos = adapter19.getPosition(battery_condition);
                            pos++;
                            Battery_Condition.setSelection(pos);
                        }

                        MaterialSpinner Starter_Motar = dialog.findViewById(R.id.Starter_Motar);
                        ArrayAdapter<CharSequence> adapter20 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Starter_Motar.setAdapter(adapter20);
                        if(starter_motar != "" ) {
                            int pos = adapter20.getPosition(starter_motar);
                            pos++;
                            Starter_Motar.setSelection(pos);
                        }
                        Instrument_Cluster_WarningLights_Gauges.setOnItemSelectedListener(Spinner.this);
                        Alternator.setOnItemSelectedListener(Spinner.this);
                        Fuel_Pump.setOnItemSelectedListener(Spinner.this);
                        Battery_Condition.setOnItemSelectedListener(Spinner.this);
                        Starter_Motar.setOnItemSelectedListener(Spinner.this);




                        Button save;
                        save=dialog.findViewById(R.id.save4);
                        save.setOnClickListener(new View.OnClickListener() {
                            String httpurl5="http://192.168.43.16/Hackathon/insertElectrical.php";
                           //String httpurl5="http://192.168.1.5/Hackathon/insertElectrical.php";
                            @Override
                            public void onClick(View v) {
                                StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl5,
                                        new com.android.volley.Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                if (response !="error"){

                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_SHORT).show();
                                                    //tempvalues.cost_to_bidder_id = response;
                                                }else {
                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_LONG).show();
                                                    Log.e("sql",response);

                                                }
                                            }
                                        },
                                        new com.android.volley.Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                //Toast.makeText(MainActivity.this, (CharSequence) error, Toast.LENGTH_LONG).show();
                                                Log.e(String.valueOf(error), "error");
                                            }
                                        }) {
                                    @Override
                                    protected Map<String, String> getParams() {
                                        Map<String, String> params = new HashMap<String, String>();
                                        params.put("mainid",tempvalues.mainid);
                                       // params.put("mainid","1");
                                        params.put("assessors","Electrical");
                                        params.put("Instrument_Cluster_WarningLights_Gauges",instrument_cluster_warningLights_gauges);
                                        params.put("Alternator", alternator);
                                        Log.e("Alternator",alternator);
                                        params.put("Fuel_Pump", fuel_pump);
                                        params.put("Battery_Condition", battery_condition);
                                        params.put("Starter_Motor", starter_motar);

                                        return params;
                                    }
                                };
                                // Creating RequestQueue.
                                RequestQueue requestQueue = Volley.newRequestQueue(Spinner.this);

                                // Adding the StringRequest object into requestQueue.
                                requestQueue.add(stringRequest);
                                Intent s=new Intent(Spinner.this,Spinner.class);
                                startActivity(s);


                            }


                        });
                        dialog.show();
                    }
                    else if (ii==6){
                        final Dialog dialog=new Dialog(Spinner.this);
                        dialog.setContentView(R.layout.acfunction);
                        dialog.setTitle("AC Function");

                        MaterialSpinner Cooling = dialog.findViewById(R.id.Cooling);
                        ArrayAdapter<CharSequence> adapter21 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Cooling.setAdapter(adapter21);
                        if(cooling != "" ) {
                            int pos = adapter21.getPosition(cooling);
                            pos++;
                            Cooling.setSelection(pos);
                        }

                        MaterialSpinner Heating = dialog.findViewById(R.id.Heating);
                        ArrayAdapter<CharSequence> adapter22 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Heating.setAdapter(adapter22);
                        if(heating != "" ) {
                            int pos = adapter22.getPosition(heating);
                            pos++;
                            Heating.setSelection(pos);
                        }

                        Cooling.setOnItemSelectedListener(Spinner.this);
                        Heating.setOnItemSelectedListener(Spinner.this);


                        Button save;
                        save=dialog.findViewById(R.id.save2);
                        save.setOnClickListener(new View.OnClickListener() {
                            String httpurl6="http://192.168.43.16/Hackathon/insertac.php";
                           // String httpurl6="http://192.168.1.5/Hackathon/insertac.php";
                            @Override
                            public void onClick(View v) {

                                StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl6,
                                        new com.android.volley.Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                if (response !="error"){

                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_SHORT).show();
                                                    //tempvalues.cost_to_bidder_id = response;
                                                }else {
                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_LONG).show();
                                                    Log.e("sql",response);

                                                }
                                            }
                                        },
                                        new com.android.volley.Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                //Toast.makeText(MainActivity.this, (CharSequence) error, Toast.LENGTH_LONG).show();
                                                Log.e(String.valueOf(error), "error");
                                            }
                                        }) {
                                    @Override
                                    protected Map<String, String> getParams() {
                                        Map<String, String> params = new HashMap<String, String>();
                                        params.put("mainid",tempvalues.mainid);
                                        //params.put("mainid","1");
                                        params.put("assessors","AC Function");
                                        params.put("Cooling",cooling);
                                        params.put("Heating",heating);

                                        return params;
                                    }
                                };
                                // Creating RequestQueue.
                                RequestQueue requestQueue = Volley.newRequestQueue(Spinner.this);

                                // Adding the StringRequest object into requestQueue.
                                requestQueue.add(stringRequest);
                                Intent s=new Intent(Spinner.this,Spinner.class);
                                startActivity(s);

                            }


                        });
                        dialog.show();
                    }
                    else if (ii==7){
                        final Dialog dialog=new Dialog(Spinner.this);
                        dialog.setContentView(R.layout.exterior);
                        dialog.setTitle("Exterior");

                        MaterialSpinner Frame_Underbody = dialog.findViewById(R.id.Frame_Underbody);
                        ArrayAdapter<CharSequence> adapter23 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Frame_Underbody.setAdapter(adapter23);
                        if(frame_underbody != "" ) {
                            int pos = adapter23.getPosition(frame_underbody);
                            pos++;
                            Frame_Underbody.setSelection(pos);
                        }

                        MaterialSpinner Wind_screen = dialog.findViewById(R.id.Wind_screen);
                        ArrayAdapter<CharSequence> adapter24 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter24.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Wind_screen.setAdapter(adapter24);
                        if(wind_screen != "" ) {
                            int pos = adapter24.getPosition(wind_screen);
                            pos++;
                            Wind_screen.setSelection(pos);
                        }

                        MaterialSpinner Wiper_Blades = dialog.findViewById(R.id.Wiper_Blades);
                        ArrayAdapter<CharSequence> adapter25 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter25.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Wiper_Blades.setAdapter(adapter25);
                        if(wiper_blades != "" ) {
                            int pos = adapter25.getPosition(wiper_blades);
                            pos++;
                            Wiper_Blades.setSelection(pos);
                        }

                        MaterialSpinner Indicators = dialog.findViewById(R.id.Indicators);
                        ArrayAdapter<CharSequence> adapter26 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter26.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Indicators.setAdapter(adapter26);
                        if(indicators != "" ) {
                            int pos = adapter26.getPosition(indicators);
                            pos++;
                            Indicators.setSelection(pos);
                        }

                        MaterialSpinner Headlights = dialog.findViewById(R.id.Headlights);
                        ArrayAdapter<CharSequence> adapter27 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter27.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Headlights.setAdapter(adapter27);
                        if(headlights != "" ) {
                            int pos = adapter27.getPosition(headlights);
                            pos++;
                            Headlights.setSelection(pos);
                        }

                        MaterialSpinner Internal_and_Rear_View_Mirrors = dialog.findViewById(R.id.Internal_and_Rear_View_Mirrors);
                        ArrayAdapter<CharSequence> adapter28 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Internal_and_Rear_View_Mirrors.setAdapter(adapter28);
                        if(internal_rear_view_mirrors != "" ) {
                            int pos = adapter28.getPosition(internal_rear_view_mirrors);
                            pos++;
                            Internal_and_Rear_View_Mirrors.setSelection(pos);
                        }

                        MaterialSpinner Tail_Lights = dialog.findViewById(R.id.Tail_Lights);
                        ArrayAdapter<CharSequence> adapter29 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Tail_Lights.setAdapter(adapter29);
                        if(tail_lights != "" ) {
                            int pos = adapter28.getPosition(tail_lights);
                            pos++;
                            Tail_Lights.setSelection(pos);
                        }
                        Frame_Underbody.setOnItemSelectedListener(Spinner.this);
                        Wind_screen.setOnItemSelectedListener(Spinner.this);
                        Wiper_Blades.setOnItemSelectedListener(Spinner.this);
                        Indicators.setOnItemSelectedListener(Spinner.this);
                        Headlights.setOnItemSelectedListener(Spinner.this);
                        Internal_and_Rear_View_Mirrors.setOnItemSelectedListener(Spinner.this);
                        Tail_Lights.setOnItemSelectedListener(Spinner.this);




                        Button save;
                        save=dialog.findViewById(R.id.save5);
                        save.setOnClickListener(new View.OnClickListener() {
                            String httpurl7="http://192.168.43.16/Hackathon/insertExterior.php";
                         //  String httpurl7="http://192.168.1.5/Hackathon/insertExterior.php";

                            @Override
                            public void onClick(View v) {
                                StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl7,
                                        new com.android.volley.Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                if (response !="error"){

                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_SHORT).show();
                                                    //tempvalues.cost_to_bidder_id = response;
                                                }else {
                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_LONG).show();
                                                    Log.e("sql",response);

                                                }
                                            }
                                        },
                                        new com.android.volley.Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                //Toast.makeText(MainActivity.this, (CharSequence) error, Toast.LENGTH_LONG).show();
                                                Log.e(String.valueOf(error), "error");
                                            }
                                        }) {
                                    @Override
                                    protected Map<String, String> getParams() {
                                        Map<String, String> params = new HashMap<String, String>();
                                        params.put("mainid",tempvalues.mainid);
                                        //params.put("mainid","1");
                                        params.put("assessors","Exterior");
                                        params.put("Frame_Underbody", frame_underbody);
                                        params.put("Wind_screen", wind_screen);
                                        params.put("Wiper_Blades", wiper_blades);
                                        params.put("Indicators", indicators);
                                        params.put("Headlights", headlights);
                                        params.put("Internal_Rear_View_Mirrors", internal_rear_view_mirrors);
                                        params.put("Tail_Lights", tail_lights);

                                        return params;
                                    }
                                };
                                // Creating RequestQueue.
                                RequestQueue requestQueue = Volley.newRequestQueue(Spinner.this);

                                // Adding the StringRequest object into requestQueue.
                                requestQueue.add(stringRequest);
                                Intent s=new Intent(Spinner.this,Spinner.class);
                                startActivity(s);

                            }


                        });
                        dialog.show();
                    }
                    else if (ii==8){
                        final Dialog dialog=new Dialog(Spinner.this);
                        dialog.setContentView(R.layout.interiors);
                        dialog.setTitle("Interiors");

                        MaterialSpinner Power_Windows_Front = dialog.findViewById(R.id.Power_Windows_Front);
                        ArrayAdapter<CharSequence> adapter30 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter30.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Power_Windows_Front.setAdapter(adapter30);
                        if(power_windows_front != "" ) {
                            int pos = adapter30.getPosition(power_windows_front);
                            pos++;
                            Power_Windows_Front.setSelection(pos);
                        }

                        MaterialSpinner Central_Locking = dialog.findViewById(R.id.Central_Locking);
                        ArrayAdapter<CharSequence> adapter31 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Central_Locking.setAdapter(adapter31);
                        if(central_locking != "" ) {
                            int pos = adapter31.getPosition(central_locking);
                            pos++;
                            Central_Locking.setSelection(pos);
                        }

                        MaterialSpinner Toolkit  = dialog.findViewById(R.id.Toolkit);
                        ArrayAdapter<CharSequence> adapter32 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Toolkit .setAdapter(adapter32);
                        if(toolkit != "" ) {
                            int pos = adapter32.getPosition(toolkit);
                            pos++;
                            Toolkit.setSelection(pos);
                        }

                        MaterialSpinner PowerWindowsBack = dialog.findViewById(R.id.Power_Windows_Back);
                        ArrayAdapter<CharSequence> adapter33 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        PowerWindowsBack.setAdapter(adapter33);
                        if(power_windows_back != "" ) {
                            int pos = adapter33.getPosition(power_windows_back);
                            pos++;
                            PowerWindowsBack.setSelection(pos);
                        }
                        MaterialSpinner ConditionOfSeats = dialog.findViewById(R.id.Condition_of_Seats);
                        ArrayAdapter<CharSequence> adapter34 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        ConditionOfSeats.setAdapter(adapter34);
                        if(condition_of_Seats != "" ) {
                            int pos = adapter34.getPosition(condition_of_Seats);
                            pos++;
                            ConditionOfSeats.setSelection(pos);
                        }

                        MaterialSpinner Horn  = dialog.findViewById(R.id.Horn);
                        ArrayAdapter<CharSequence> adapter35 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter35.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Horn .setAdapter(adapter35);
                        if(horn != "" ) {
                            int pos = adapter35.getPosition(horn);
                            pos++;
                            Horn.setSelection(pos);
                        }

                        MaterialSpinner Roof_Wear_and_Tear  = dialog.findViewById(R.id.Roof_Wear_Tear);
                        ArrayAdapter<CharSequence> adapter36 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter36.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Roof_Wear_and_Tear .setAdapter(adapter36);
                        if(roof_Wear_and_Tear!= "" ) {
                            int pos = adapter36.getPosition(roof_Wear_and_Tear);
                            pos++;
                            Roof_Wear_and_Tear.setSelection(pos);
                        }
                        MaterialSpinner Headlamp_Indicator_Switches  = dialog.findViewById(R.id.Headlamp_Indicator_Switches);
                        ArrayAdapter<CharSequence> adapter37 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter37.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Headlamp_Indicator_Switches .setAdapter(adapter37);
                        if(headlamp_Indicator_Switches != "" ) {
                            int pos = adapter37.getPosition(headlamp_Indicator_Switches);
                            pos++;
                            Headlamp_Indicator_Switches.setSelection(pos);
                        }


                        Power_Windows_Front.setOnItemSelectedListener(Spinner.this);
                        PowerWindowsBack.setOnItemSelectedListener(Spinner.this);
                        ConditionOfSeats.setOnItemSelectedListener(Spinner.this);
                        Horn.setOnItemSelectedListener(Spinner.this);
                        Roof_Wear_and_Tear.setOnItemSelectedListener(Spinner.this);
                        Headlamp_Indicator_Switches.setOnItemSelectedListener(Spinner.this);
                        Central_Locking.setOnItemSelectedListener(Spinner.this);
                        Toolkit.setOnItemSelectedListener(Spinner.this);




                        Button save;
                        save=dialog.findViewById(R.id.save6);
                        save.setOnClickListener(new View.OnClickListener() {
                            String httpurl8="http://192.168.43.16/Hackathon/insertinterior.php";
                          // String httpurl8="http://192.168.1.5/Hackathon/insertinterior.php";

                            @Override
                            public void onClick(View v) {


                                StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl8,
                                        new com.android.volley.Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                if (response !="error"){

                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_SHORT).show();
                                                    //tempvalues.cost_to_bidder_id = response;
                                                }else {
                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_LONG).show();
                                                    Log.e("sql",response);

                                                }
                                            }
                                        },
                                        new com.android.volley.Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                //Toast.makeText(MainActivity.this, (CharSequence) error, Toast.LENGTH_LONG).show();
                                                Log.e(String.valueOf(error), "error");
                                            }
                                        }) {
                                    @Override
                                    protected Map<String, String> getParams() {
                                        Map<String, String> params = new HashMap<String, String>();
                                        params.put("mainid",tempvalues.mainid);
                                        //params.put("mainid","1");
                                        params.put("assessors","Interiors");
                                        params.put("Power_Windows_Front", power_windows_front);
                                        params.put("Central_Locking", central_locking);
                                        params.put("Toolkit", toolkit);
                                        params.put("Power_Windows_Back", power_windows_back);
                                        params.put("Horn", horn);
                                        params.put("Roof_Wear_Tear", roof_Wear_and_Tear);
                                        params.put("Condition_of_Seats", condition_of_Seats);
                                        params.put("Headlamp_Indicator_Switches", headlamp_Indicator_Switches);

                                        return params;
                                    }
                                };
                                // Creating RequestQueue.
                                RequestQueue requestQueue = Volley.newRequestQueue(Spinner.this);

                                // Adding the StringRequest object into requestQueue.
                                requestQueue.add(stringRequest);
                                Intent s=new Intent(Spinner.this,Spinner.class);
                                startActivity(s);





                            }


                        });
                        dialog.show();
                    }
                    else if (ii==9){
                        final Dialog dialog=new Dialog(Spinner.this);
                        dialog.setContentView(R.layout.tyre_condition);
                        dialog.setTitle("Tyre Condition");

                        MaterialSpinner WheelRightFront  = dialog.findViewById(R.id.Wheel_Right_Front);
                        ArrayAdapter<CharSequence> adapter38 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter38.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        WheelRightFront .setAdapter(adapter38);
                        if(wheel_RightFront != "" ) {
                            int pos = adapter38.getPosition(wheel_RightFront);
                            pos++;
                            WheelRightFront.setSelection(pos);
                        }
                        MaterialSpinner WheelRightRear   = dialog.findViewById(R.id.Wheel_Right_Rear);
                        ArrayAdapter<CharSequence> adapter39 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter39.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        WheelRightRear.setAdapter(adapter39);
                        if(wheel_RightRear != "" ) {
                            int pos = adapter39.getPosition(wheel_RightRear);
                            pos++;
                            WheelRightRear.setSelection(pos);
                        }
                        MaterialSpinner WheelLeftFront  = dialog.findViewById(R.id.Wheel_Left_Front);
                        ArrayAdapter<CharSequence> adapter40 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter40.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        WheelLeftFront .setAdapter(adapter40);
                        if(wheel_LeftFront != "" ) {
                            int pos = adapter40.getPosition(wheel_LeftFront);
                            pos++;
                            WheelLeftFront.setSelection(pos);
                        }


                        MaterialSpinner WheelLeftRear  = dialog.findViewById(R.id.Wheel_Left_Rear);
                        ArrayAdapter<CharSequence> adapter41 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter40.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        WheelLeftRear.setAdapter(adapter41);
                        if(wheel_LeftRear != "" ) {
                            int pos = adapter40.getPosition(wheel_LeftRear);
                            pos++;
                            WheelLeftRear.setSelection(pos);
                        }


                        MaterialSpinner WheelStephaney  = dialog.findViewById(R.id.Wheel_Stephaney);
                        ArrayAdapter<CharSequence> adapter42 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter42.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        WheelStephaney .setAdapter(adapter42);
                        if(wheel_Stephaney != "" ) {
                            int pos = adapter42.getPosition(wheel_Stephaney);
                            pos++;
                            WheelStephaney.setSelection(pos);
                        }


                        WheelRightFront.setOnItemSelectedListener(Spinner.this);
                        WheelRightRear .setOnItemSelectedListener(Spinner.this);
                        WheelLeftFront.setOnItemSelectedListener(Spinner.this);
                        WheelLeftRear.setOnItemSelectedListener(Spinner.this);
                        WheelStephaney .setOnItemSelectedListener(Spinner.this);



                        Button save;
                        save=dialog.findViewById(R.id.save11);
                        save.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                String httpurl9="http://192.168.43.16/Hackathon/inserttyrecondition.php";
                               // String httpurl9="http://192.168.1.5/Hackathon/inserttyrecondition.php";
                                StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl9,
                                        new com.android.volley.Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                if (response !="error"){

                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_SHORT).show();
                                                    //tempvalues.cost_to_bidder_id = response;
                                                }else {
                                                    Toast.makeText(Spinner.this, response, Toast.LENGTH_LONG).show();
                                                    Log.e("sql",response);

                                                }
                                            }
                                        },
                                        new com.android.volley.Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error) {
                                                //Toast.makeText(MainActivity.this, (CharSequence) error, Toast.LENGTH_LONG).show();
                                                Log.e(String.valueOf(error), "error");
                                            }
                                        }) {
                                    @Override
                                    protected Map<String, String> getParams() {
                                        Map<String, String> params = new HashMap<String, String>();
                                        params.put("mainid",tempvalues.mainid);
                                        //params.put("mainid","1");
                                        params.put("assessors","Tyre Condition ");
                                        params.put("Wheel_Right_Front", wheel_RightFront);
                                        params.put("Wheel_Right_Rear", wheel_RightRear);
                                        params.put("Wheel_Left_Front", wheel_LeftFront);
                                        params.put("Wheel_Stephaney", wheel_Stephaney);
                                        params.put("Wheel_Left_Rear", wheel_LeftRear);

                                        return params;
                                    }
                                };
                                // Creating RequestQueue.
                                RequestQueue requestQueue = Volley.newRequestQueue(Spinner.this);

                                // Adding the StringRequest object into requestQueue.
                                requestQueue.add(stringRequest);
                                Intent s=new Intent(Spinner.this,Spinner.class);
                                startActivity(s);
                            }


                        });
                        dialog.show();
                    }
                    else if (ii==10){
                        final Dialog dialog=new Dialog(Spinner.this);
                        dialog.setContentView(R.layout.accessories);
                        dialog.setTitle("Accessories");

                        MaterialSpinner SeatCovers   = dialog.findViewById(R.id.Seat_Covers);
                        ArrayAdapter<CharSequence> adapter42 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter42.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        SeatCovers  .setAdapter(adapter42);
                        if(seat_Covers != "" ) {
                            int pos = adapter42.getPosition(seat_Covers);
                            pos++;
                            SeatCovers.setSelection(pos);
                        }
                        MaterialSpinner FogLamps   = dialog.findViewById(R.id.Fog_Lamps);
                        ArrayAdapter<CharSequence> adapter43 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter43.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        FogLamps  .setAdapter(adapter43);
                        if(fog_Lamps != "" ) {
                            int pos = adapter43.getPosition(fog_Lamps);
                            pos++;
                            FogLamps .setSelection(pos);
                        }
                        MaterialSpinner MusicSystem  = dialog.findViewById(R.id.Music_System);
                        ArrayAdapter<CharSequence> adapter44 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter44.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        MusicSystem .setAdapter(adapter44);
                        if(music_System != "" ) {
                            int pos = adapter44.getPosition(music_System);
                            pos++;
                            MusicSystem.setSelection(pos);
                        }
                        MaterialSpinner FloorMats  = dialog.findViewById(R.id.Floor_Mats);
                        ArrayAdapter<CharSequence> adapter45 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter45.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        FloorMats .setAdapter(adapter45);
                        if(floor_Mats != "" ) {
                            int pos = adapter45.getPosition(floor_Mats);
                            pos++;
                            FloorMats.setSelection(pos);
                        }
                        MaterialSpinner Speakers  = dialog.findViewById(R.id.Speakers);
                        ArrayAdapter<CharSequence> adapter46 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter46.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Speakers .setAdapter(adapter46);
                        if(speakers != "" ) {
                            int pos = adapter46.getPosition(speakers);
                            pos++;
                            Speakers.setSelection(pos);
                        }
                        MaterialSpinner Tipping_Systems  = dialog.findViewById(R.id.Tipping_Systems);
                        ArrayAdapter<CharSequence> adapter47 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter47.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Tipping_Systems .setAdapter(adapter47);
                        if(tipping != "" ) {
                            int pos = adapter47.getPosition(tipping);
                            pos++;
                            Tipping_Systems.setSelection(pos);
                        }
                        MaterialSpinner Odometer  = dialog.findViewById(R.id.Odometer);
                        ArrayAdapter<CharSequence> adapter48 = ArrayAdapter.createFromResource(Spinner.this, R.array.values, android.R.layout.simple_spinner_item);
                        adapter48.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Odometer .setAdapter(adapter48);
                        if(odometer != "" ) {
                            int pos = adapter48.getPosition(odometer);
                            pos++;
                            Odometer.setSelection(pos);
                        }
//
//

                        SeatCovers .setOnItemSelectedListener(Spinner.this);
                        FogLamps .setOnItemSelectedListener(Spinner.this);
                        MusicSystem.setOnItemSelectedListener(Spinner.this);
                        FloorMats.setOnItemSelectedListener(Spinner.this);
                        Speakers.setOnItemSelectedListener(Spinner.this);
                        Tipping_Systems.setOnItemSelectedListener(Spinner.this);
                        Odometer.setOnItemSelectedListener(Spinner.this);


                        Button save;
                        save=dialog.findViewById(R.id.save1);
                        save.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(Spinner.this, g+"Saved", Toast.LENGTH_SHORT).show();
                                ArrayList<String> array=new ArrayList<>();

                                array.add(silencer);
                                array.add(engine);

                                Intent s=new Intent(Spinner.this,Spinner.class);
                                s.putExtra("1",array);
                                startActivity(s);


                            }


                        });
                        dialog.show();
                    }



                }
            });
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){
            case R.id.Silencer:
                silencer=parent.getItemAtPosition(position).toString();
                break;
            //Toast.makeText(this, ""+silencer, Toast.LENGTH_SHORT).show();

            case R.id.Abnormal_Engine_Noise:
                engine=parent.getItemAtPosition(position).toString();
                Toast.makeText(this, ""+engine, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Oil:
                oil=parent.getItemAtPosition(position).toString();
                // Toast.makeText(this, ""+silencer, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Plugs:
                plugs=parent.getItemAtPosition(position).toString();
                break;
            //Toast.makeText(this, ""+oil, Toast.LENGTH_SHORT).show();


            case R.id.Radiator_Condenser:
                radiator_condenser=parent.getItemAtPosition(position).toString();
                break;
            //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
            case R.id.Oil_Leakage:
                oil_leakage=parent.getItemAtPosition(position).toString();
                break;
            //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();


            case R.id.Fan_Belts:
                fan_belts=parent.getItemAtPosition(position).toString();
                break;
            case R.id.Filters:
                filters=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;


            case R.id.Suspension_Noise_WhileDriving_Front_Rear:
                suspension_noise_whileDriving_front_rear=parent.getItemAtPosition(position).toString();
                // Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;



            case R.id.Steering_Lock:
                steering_lock=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Wheel_Alignment_Balancing_Wobbling:
                wheel_alignment_balancing_wobbling=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Steering_Operation:
                steering_operation=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;


            case R.id.Pedal_Operation:
                pedal_operation=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Brakes_and_Hand_Brake:
                brakes_and_hand_brake=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Gear_Engagement:
                gear_engagement=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Differential_And_Crown_RearWheel_Drive:
                differential_and_crown_rearWheel_drive=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;




            case R.id.Instrument_Cluster_WarningLights_Gauges:
                instrument_cluster_warningLights_gauges=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Fuel_Pump:
                fuel_pump=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Battery_Condition:
                battery_condition=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Starter_Motar:
                starter_motar=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Cooling:
                cooling=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Heating:
                heating=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Frame_Underbody:
                frame_underbody=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Wind_screen:
                wind_screen=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Wiper_Blades:
                wiper_blades=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Indicators:
                indicators=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Headlights:
                headlights=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Internal_and_Rear_View_Mirrors:
                internal_rear_view_mirrors=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case R.id.Tail_Lights:
                tail_lights=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Power_Windows_Front:
                power_windows_front=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Central_Locking:
                central_locking=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Toolkit:
                toolkit=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Power_Windows_Back:
                power_windows_back=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Horn:
                horn=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Roof_Wear_Tear:
                roof_Wear_and_Tear=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Headlamp_Indicator_Switches:
                headlamp_Indicator_Switches=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Wheel_Right_Front:
                wheel_RightFront=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Wheel_Right_Rear:
                wheel_RightRear=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Wheel_Left_Front:
                wheel_LeftFront=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Wheel_Left_Rear:
                wheel_LeftRear=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Wheel_Stephaney:
                wheel_Stephaney=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Seat_Covers:
                seat_Covers=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;


            case R.id.Fog_Lamps:
                fog_Lamps=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Music_System:
                music_System=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Floor_Mats:
                floor_Mats=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Speakers:
                speakers=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;
            case R.id.Tipping_Systems:
                tipping=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;

            case  R.id.Alternator:
                alternator = parent.getItemAtPosition(position).toString();

            case R.id.Odometer:
                odometer=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, ""+plugs, Toast.LENGTH_SHORT).show();
                break;





        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
//Silencer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//@Override
//public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        g=parent.getItemAtPosition(position).toString();
//        }
//
//@Override
//public void onNothingSelected(AdapterView<?> parent) {
//
//        }
//        });

