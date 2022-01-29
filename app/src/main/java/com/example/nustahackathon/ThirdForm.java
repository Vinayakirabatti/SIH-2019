package com.example.nustahackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ThirdForm extends AppCompatActivity {
    String httpurl="http://192.168.43.16/Hackathon/costTobidder.php";
    //String httpurl="http://192.168.43.251/Hackathon/costTobidder.php";
    //String httpurl="http://192.168.1.5/Hackathon/costTobidder.php";
    TextView tv;
    Button button;
    EditText buyer,warenty_coast,transportayion_coast,rto_expences,insurance_cost,taxes_penalty,refurb_coast,parking_charges,total_coast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_form);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tv=findViewById(R.id.tv);
        button=findViewById(R.id.SubmitCost);
        buyer=findViewById(R.id.buyer);
        warenty_coast=findViewById(R.id.warenty_coast);
        transportayion_coast=findViewById(R.id.Transportayion_coast);
        rto_expences=findViewById(R.id.rto_expences);
        insurance_cost=findViewById(R.id.insurance_cost);
        taxes_penalty=findViewById(R.id.taxes_penalty);
        refurb_coast=findViewById(R.id.refurb_coast);
        parking_charges=findViewById(R.id.parking_charges);
        total_coast=findViewById(R.id.total_coast);
//
//
        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent = new Intent(ThirdForm.this, inspectionlist.class);
                    intent.putExtra("user",inspectionlist.user);


                    if (buyer.getText().toString().length() == 0)
                        buyer.setError("InspectionDate is required!");
                    else if (warenty_coast.getText().toString().length() == 0)
                        warenty_coast.setError("InspectionDate is required!");
                    else if (transportayion_coast.getText().toString().length() == 0)
                        transportayion_coast.setError("InspectionDate is required!");
                    else if (rto_expences.getText().toString().length() == 0)
                        rto_expences.setError("InspectionDate is required!");
                    else if (insurance_cost.getText().toString().length() == 0)
                        insurance_cost.setError("InspectionDate is required!");
                    else if (taxes_penalty.getText().toString().length() == 0)
                        taxes_penalty.setError("InspectionDate is required!");
                    else if (refurb_coast.getText().toString().length() == 0)
                        refurb_coast.setError("InspectionDate is required!");
                   else if (parking_charges.getText().toString().length() == 0)
                        parking_charges.setError("InspectionDate is required!");
                    else if (total_coast.getText().toString().length() == 0)
                        total_coast.setError("InspectionDate is required!");

                    else {

                        final String warrantycost=warenty_coast.getText().toString();
                        final String transportationcost=transportayion_coast.getText().toString();
                        final String rtoexpences=rto_expences.getText().toString();
                        final String insurancecost=insurance_cost.getText().toString();
                        final String taxespenalty=taxes_penalty.getText().toString();
                        final String totalcost=total_coast.getText().toString();
                        final String refurbcost=refurb_coast.getText().toString();
                        final String buyers=buyer.getText().toString();
                        final String parkingcharges=parking_charges.getText().toString();

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl,
                                new com.android.volley.Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        //Toast.makeText(ThirdForm.this, "DATA SUCCESSFULLY INSERTED", Toast.LENGTH_LONG).show();

                                        Log.e("r",response);

                                        if (response !="error"){
                                            tempvalues.cost_to_bidder_id = response;
                                        }else {
                                            Toast.makeText(ThirdForm.this, response, Toast.LENGTH_LONG).show();
                                            Log.e("sql",response);

                                        }
                                        startActivity(intent);


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
                                Log.e("temp",tempvalues.mainid);
                                params.put("mainid",tempvalues.mainid);
                                params.put("buyer", buyers);
                                params.put("warrantycost", warrantycost);
                                params.put("transportationcost", transportationcost);
                                params.put("rtoexpences", rtoexpences);
                                params.put("insurancecost", insurancecost);
                                params.put("taxespenalty", taxespenalty);
                                params.put("refurbcost", refurbcost);
                                params.put("parkingcharges", parkingcharges);


                                return params;
                            }
                        };

                        // Creating RequestQueue.
                        RequestQueue requestQueue = Volley.newRequestQueue(ThirdForm.this);

                        // Adding the StringRequest object into requestQueue.
                        requestQueue.add(stringRequest);





                        startActivity(intent);
                    }
                }
            });



        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(this,inspectionlist.class);
        startActivityForResult(i,0);
        return true;
    }
    }








