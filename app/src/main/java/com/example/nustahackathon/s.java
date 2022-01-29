package com.example.nustahackathon;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.ref.Reference;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class s extends AppCompatActivity {
    TextView tv;
    String httpurl="http://192.168.43.16/Hackathon/valuation.php";
   // String httpurl = "http://192.168.43.251/Hackathon/valuation.php";
    // String httpurl="http://192.168.1.5/Hackathon/valuation.php";
    private String todaysdate="2019/02/23"; //ref="AAAV/TMFLOR/VV-3389/18-19";
    private String ref;
    String [] purpose = {"Value of Repossessed Asset","Value of Default Asset","Custom Asset","mahem","mmm"};
    String [] location= {"Mumbai", "Delhi", "Bangalore", "Chennai", "Hyderabad", "Ahmedabad", "Kolkata" , "Surat","Pune", "Jaipur", "Lucknow", "Kanpur", "Nagpur", "Visakhapatnam", "Indore", "Thane", "Bhopal", "Pimpri-Chinchwad", "Patna", "Vadodara", "Ghaziabad", "Ludhiana", "Coimbatore", "Agra", "Madurai", "Nashik", "Vijayawada", "Faridabad", "Meerut", "Rajkot", "Kalyan-Dombivali", "Vasai-Virar", "Varanasi", "Srinagar", "Aurangabad", "Dhanbad", "Amritsar", "Navi Mumbai", "Allahabad", "Ranchi", "Howrah", "Jabalpur", "Gwalior", "Jodhpur", "Raipur" , "Kota","Solapur","Bengal","Chandigarh"};
    String httpgetref= "http://192.168.43.16/Hackathon/getRef_no.php";
    EditText REFERENCE,InspectionDate ,Purpose,RcStatus, Bank , ContractNo,Requestfrom,AssetMake, AssetModel,Yearofmfg,Repossession ,RCFitnessValid,HMRKMR,ChassisNumber,EngineNumber,RCNumbe,Inspector,Location,Inspection,TaxStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //tv=findViewById(R.id.Date);
        //REFERENCE=findViewById(R.id.Reference);

       Log.e("user",inspectionlist.user);



        Bank=findViewById(R.id.Bank);
        Inspector=findViewById(R.id.Inspector);
        Purpose=findViewById(R.id.Purpose);
        ContractNo=findViewById(R.id.Contractno);
        Requestfrom=findViewById(R.id.Requestfrom);
        AssetMake=findViewById(R.id.AssetMake);
        AssetModel=findViewById(R.id.AssetModel);
        Yearofmfg=findViewById(R.id.Yearofmfg);
        RcStatus=findViewById(R.id.RCStatus);
        Repossession=findViewById(R.id.RepossesionDate);
        HMRKMR=findViewById(R.id.HMRKMR);
        ChassisNumber=findViewById(R.id.ChassisNumber);
        EngineNumber=findViewById(R.id.EngineNumber);
        RCNumbe=findViewById(R.id.RCNumber);
        InspectionDate=findViewById(R.id.InspectionDate);
        Location=findViewById(R.id.Location);
        TaxStatus=findViewById(R.id.TaxStatus);
        RCFitnessValid=findViewById(R.id.RCFitnessValid);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        //InspectionDate.setShowSoftInputOnFocus(false);

//getting ref_no from server

        StringRequest stringRequest = new StringRequest(Request.Method.POST, httpgetref,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject itemList = jsonArray.getJSONObject(i);
                                ref = itemList.getString("ref_no");
                                tempvalues.ref= ref;
                            }
                            Log.e("ref",ref);
                            // ref="AAAV/TMFLOR/VV-3389/18-19";
                            String temp = ref.substring(14,24);
                            int first_in = temp.indexOf('/');
                            int valtoince = Integer.parseInt(temp.substring(1,first_in));
                            valtoince++;
                            Log.e("gg", String.valueOf(valtoince));

                            ref ="AAAV/TMFLOR/VV-"+valtoince+"/18-19";
                            Log.e("fialref",ref);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(MainActivity.this, (CharSequence) error, Toast.LENGTH_LONG).show();
                        Log.e(String.valueOf(error), "error to get");
                    }
                });

        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(s.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);



        InspectionDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(s.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = String.valueOf(year)+"-"+String.valueOf(monthOfYear+1)+"-"+String.valueOf(dayOfMonth);
                        InspectionDate.setText(date);
                    }
                }, yy, mm, dd);
                datePicker.show();
            }
        });
        RCFitnessValid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(s.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = String.valueOf(year)+"-"+String.valueOf(monthOfYear+1)+"-"+String.valueOf(dayOfMonth);
                        RCFitnessValid.setText(date);
                    }
                }, yy, mm, dd);
                datePicker.show();
            }

        });
        Repossession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(s.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = String.valueOf(year)+"-"+String.valueOf(monthOfYear+1)+"-"+String.valueOf(dayOfMonth);
                        Repossession.setText(date);
                    }
                }, yy, mm, dd);
                datePicker.show();

            }

        });
        TaxStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(s.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = String.valueOf(year)+"-"+String.valueOf(monthOfYear+1)+"-"+String.valueOf(dayOfMonth);
                        TaxStatus.setText(date);
                    }
                }, yy, mm, dd);
                datePicker.show();
            }
        });

       // tv.setText(currentDateTimeString);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(s.this,inspectionlist.class);
        startActivityForResult(i,1);
        return true;
    }
    public void secondform(View view) {
        final Intent s=new Intent(s.this,inspectionlist.class);

        if (Purpose.getText().toString().length() == 0)
            Purpose.setError("Purpose is required!");
        else if (Bank.getText().toString().length() == 0)
            Bank.setError("Bank name is required!");
        else if (ContractNo.getText().toString().length() == 0)
            ContractNo.setError("Contract Number is required!");
        else if (Requestfrom.getText().toString().length() == 0)
            Requestfrom.setError("RequestForm is required!");
        else if (AssetMake.getText().toString().length() == 0)
            AssetMake.setError("AssetMake is required!");
        else if (AssetModel.getText().toString().length() == 0)
            AssetModel.setError("AssetModel is required!");
        else if (Yearofmfg.getText().toString().length() == 0)
            Yearofmfg.setError("YearofMfg is required!");
        else if (Repossession.getText().toString().length() == 0)
            Repossession.setError("Repossession is required!");

        else if (HMRKMR.getText().toString().length() == 0)
            HMRKMR.setError("HMRKME is required!");
        else if (ChassisNumber.getText().toString().length() == 0)
            ChassisNumber.setError("ChassisNo is required!");
        else if (EngineNumber.getText().toString().length() == 0)
            EngineNumber.setError("EngineNo is required!");
        else if (RCNumbe.getText().toString().length() == 0)
            RCNumbe.setError("RC Number is required!");
        else if (Inspector.getText().toString().length() == 0)
            Inspector.setError("Inspector is required!");
        else if (RcStatus.getText().toString().length() == 0)
            RcStatus.setError("RCStatus is required!");
        else if (Inspector.getText().toString().length() == 0)
            Inspector.setError("RCStatus is required!");
        else if (InspectionDate.getText().toString().length() == 0)
            InspectionDate.setError("InspectionDate is required!");


        else if (Location.getText().toString().length() == 0)
            Location.setError("Location is required!");
        else if (TaxStatus.getText().toString().length() == 0)
            TaxStatus.setError("TaxStatus is required!");
        else if (RCFitnessValid.getText().toString().length() == 0)
            RCFitnessValid.setError("RCFitnessValid is required!");

        else {

            final String purpose = Purpose.getText().toString();
            final String bank = Bank.getText().toString();
            final String contractNo = ContractNo.getText().toString();
            final String requestfrom = Requestfrom.getText().toString();
            final String assetmake = AssetMake.getText().toString();
            final String assetmodel = AssetModel.getText().toString();
            final String yearofmfg = Yearofmfg.getText().toString();
            final String repossession = Repossession.getText().toString();
            final String rcfitnessvalid = RCFitnessValid.getText().toString();

            final String hmrkmr = HMRKMR.getText().toString();
            final String chassisno = ChassisNumber.getText().toString();
            final String engineno = EngineNumber.getText().toString();
            final String rcnumber = RCNumbe.getText().toString();
            final String inspector = Inspector.getText().toString();
            final String location = Location.getText().toString();
            final String rcstatus = RcStatus.getText().toString();
            final String inspectiondate = InspectionDate.getText().toString();
            final String taxstatus = TaxStatus.getText().toString();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl,
                    new com.android.volley.Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(s.this, "DATA SUCCESSFULLY INSERTED", Toast.LENGTH_LONG).show();
                            Log.e("sql",response);
                            if(response !="error"){
                                tempvalues.mainid = response;
                            }
                            s.putExtra("user",inspectionlist.user);
                            startActivity(s);
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
                    params.put("user",inspectionlist.user);
                    Log.e("user",inspectionlist.user);

                    params.put("purpose", purpose);
                    params.put("bank", bank);
                    params.put("contractno", contractNo);
                    params.put("requestfrom", requestfrom);
                    params.put("assetmake", assetmake);
                    params.put("assetmodel", assetmodel);
                    params.put("yearofmfg", yearofmfg);
                    params.put("repossession", repossession);
                    params.put("rcfitnessvalid", rcfitnessvalid);
                    params.put("hmrkmr", hmrkmr);
                    params.put("chassisno", chassisno);
                    params.put("engineno", engineno);
                    params.put("rcnumber", rcnumber);
                    params.put("inspector", inspector);
                    params.put("location", location);
                    params.put("rcstatus", rcstatus);
                    params.put("inspectiondate", inspectiondate);
                    params.put("taxstatus", taxstatus);
                    params.put("dates",todaysdate);
                    params.put("ref",ref);
                    return params;
                }
            };
            // Creating RequestQueue.
            RequestQueue requestQueue = Volley.newRequestQueue(s.this);

            // Adding the StringRequest object into requestQueue.
            requestQueue.add(stringRequest);
        }
















//
        }




}

