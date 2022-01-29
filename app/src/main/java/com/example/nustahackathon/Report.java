package com.example.nustahackathon;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.itextpdf.text.DocumentException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Report extends AppCompatActivity {
   String httpurl="http://192.168.43.16/Hackathon/report.php";
 //String httpurl="http://192.168.43.16/Hackathon/report.php";
// String httpurl="http://192.168.43.251/Hackathon/report.php";

    TextView edReference1,edrepossessiondate,edrcno,edrcstatus, edBank, edContractno, edRequestfrom, edAssetMake, edAssetModel, edYearofmfg, edHMRKMR, edChassisNumber, edEngineNumber, edInspector, edLocation, edRCFitnessValid, edTaxStatus, edbuyer, edwarenty_coast, edtransportayion_coast, edrto_expences, edinsurance_cost, edtaxes_penalty, edrefurb_coast, edparking_charges, edtotal_coast;

    TextView edpurpose1;
    String sReference1,srepossessiondate,spurpose1,srcno,srcstatus, sBank, sContractno, sRequestfrom, sAssetMake, sAssetModel, sYearofmfg, sHMRKMR, sChassisNumber,sEngineNumber, sInspector, sLocation, sRCFitnessValid, sTaxStatus;
    private Button btn;
    private LinearLayout llPdf;


    TextView parSilencer,parAbnormalEngineNoise,parPlugs,parOil,parRadiotorCondensor,parOilLeakage,parFanBelts,parFilters;
    TextView conSilencer,conEngineNoise,conPlugs,conOil,conRadiotorCondensor,conOilleakage,confanbelts,conFilters;

    String pSilencer,pAbnormalEngineNoise,pPlugs,pOil,pRadiotorCondensor,pOilLeakage,pFanBelts,pFilters;
    String cSilencer,cEngineNoise,cPlugs,cOil,cRadiotorCondensor,cOilleakage,cfanbelts,cFilters;



    String  sbuyer, swarenty_coast, stransportayion_coast, srto_expences, sinsurance_cost, staxes_penalty, srefurb_coast, sparking_charges, stotal_coast;

ImageView i1,i2,i3,i4,i5,i6,i7,i8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       //tempvalues.mainid = ;


        parSilencer =findViewById(R.id.parsilen);
                parAbnormalEngineNoise=findViewById(R.id.parabnormalenginenoise);
        parPlugs=findViewById(R.id.parplugs);
                parOil=findViewById(R.id.paroil);
        parRadiotorCondensor=findViewById(R.id.parRadiatorCondensor);
                parOilLeakage=findViewById(R.id.parOilLeakage);
        parFanBelts=findViewById(R.id.parFanbelts);
                parFilters=findViewById(R.id.parFilter);


        conSilencer=findViewById(R.id.consilencer);
                conEngineNoise=findViewById(R.id.conabnormalenginenoise);

        conPlugs=findViewById(R.id.conplugs);
                conOil=findViewById(R.id.conOil);
        conRadiotorCondensor=findViewById(R.id.conRadiotorCondenser);
                conOilleakage=findViewById(R.id.conOilleakage);
        confanbelts=findViewById(R.id.conFanbelts);
                conFilters=findViewById(R.id.conFilter);


        edReference1=findViewById(R.id.edref);
        edYearofmfg=findViewById(R.id.edYearofmfg);
        edpurpose1=(TextView) findViewById(R.id.edpurp);
        edrepossessiondate=findViewById(R.id.edrepdate);
        edrcno=findViewById(R.id.edrcnumber);
        edrcstatus=findViewById(R.id.edrcstatus);
        edBank=findViewById(R.id.edBank);
        edContractno=findViewById(R.id.edContractno);
        edRequestfrom=findViewById(R.id.edRequestfrom);
        edAssetMake=findViewById(R.id.edAssetMake);
        edAssetModel=findViewById(R.id.edAssetModel);
        edYearofmfg=findViewById(R.id.edYearofmfg);
        edHMRKMR=findViewById(R.id.edHMRKMR);
        edChassisNumber=findViewById(R.id.edChassisNumber);
        edEngineNumber=findViewById(R.id.edEngineNumber);
        edInspector=findViewById(R.id.edinspector);
        edLocation=findViewById(R.id.edloc);
        edRCFitnessValid=findViewById(R.id.edrcfitnessvalid);
        edTaxStatus=findViewById(R.id.edtaxStatus);
        edbuyer=findViewById(R.id.edbuyer);
        edwarenty_coast=findViewById(R.id.edwarenty_coast);
        edtransportayion_coast=findViewById(R.id.edtransportayion_coast);
        edrto_expences=findViewById(R.id.edrto_expences);
        edinsurance_cost=findViewById(R.id.edinsurance_cost);
        edtaxes_penalty=findViewById(R.id.edtaxes_penalty);
        edrefurb_coast=findViewById(R.id.edrefurb_coast);
        edparking_charges=findViewById(R.id.edparking_charges);
        edtotal_coast=findViewById(R.id.edtotal_coast);





    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(this,Home.class);
        startActivityForResult(i,0);
        return true;
    }

    public void NEXT(View view) {
//
        StringRequest stringRequest = new StringRequest(Request.Method.POST, httpurl,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Report.this, response, Toast.LENGTH_LONG).show();
                    Log.e("resp",String.valueOf(response));

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject itemList = jsonArray.getJSONObject(i);

                                sReference1 = itemList.getString("Ref_no");
                                edReference1.setText(sReference1);


                                sBank=itemList.getString("Bank_valuation_for");
                                edBank.setText(sBank);

                                sContractno=itemList.getString("contact_no");
                                edContractno.setText(sContractno);

                                sRequestfrom=itemList.getString("Request_from");
                                edRequestfrom.setText(sRequestfrom);

                                sAssetMake=itemList.getString("AssetMake");
                                edAssetMake.setText(sAssetMake);

                                sAssetModel=itemList.getString("Asset_model");
                                edAssetModel.setText(sAssetModel);

                                sHMRKMR=itemList.getString("HMR_KMR");
                                edHMRKMR.setText(sHMRKMR);

                                sChassisNumber=itemList.getString("Chassis_no");
                                edChassisNumber.setText(sChassisNumber);

                                sEngineNumber=itemList.getString("Engine_no");
                                edEngineNumber.setText(sEngineNumber);

                                sTaxStatus=itemList.getString("Tax_Status");
                                edTaxStatus.setText(sTaxStatus);






                                Log.e("items", String.valueOf(itemList));

                                spurpose1 = itemList.getString("Purpose");
                                edpurpose1.setText(spurpose1);


                                srepossessiondate = itemList.getString("Repossession_date");
                                edrepossessiondate.setText(srepossessiondate);


                                srcno = itemList.getString("RC_no");
                                edrcno.setText(srcno);


                                srcstatus = itemList.getString("RC_status");
                                edrcstatus.setText(srcstatus);

                                sYearofmfg = itemList.getString("year_of_mfg");
                                edYearofmfg.setText(sYearofmfg);

                                sInspector = itemList.getString("Inspector");
                                edInspector.setText(sInspector);


                                sLocation = itemList.getString("Location");
                                edLocation.setText(sLocation);

                                sRCFitnessValid = itemList.getString("RC_Fitness_valid");
                                edRCFitnessValid.setText(sRCFitnessValid);














                                int totalcost;
                                int Buyer_Biddersmargin;
                                Buyer_Biddersmargin = itemList.getInt("Buyer_Biddersmargin");
                                int warranty_cost= itemList.getInt("warranty_cost");
                                int Transporation_cost= itemList.getInt("Transporation_cost");
                                int RTO_Expenses= itemList.getInt("RTO_Expenses");
                                int insurance_cost= itemList.getInt("insurance_cost");
                                int Taxes_penalty= itemList.getInt("Taxes_penalty");
                                int Refurb_cost= itemList.getInt("Refurb_cost");

                              //  Log.e(String.valueOf(Buyer_Biddersmargin),":"+warranty_cost+"+"+Transporation_cost+":"+RTO_Expenses+":"+insurance_cost+":"+Taxes_penalty+":"+Refurb_cost);
                                totalcost = Buyer_Biddersmargin + warranty_cost + Transporation_cost + RTO_Expenses + insurance_cost + Taxes_penalty + Refurb_cost;
                               // Log.e(String.valueOf(totalcost),"total");
                                sbuyer=itemList.getString("Buyer_Biddersmargin");
                                edbuyer.setText(sbuyer);

                                swarenty_coast=itemList.getString("warranty_cost");
                                edwarenty_coast.setText(swarenty_coast);



                                stransportayion_coast=itemList.getString("Transporation_cost");
                                edtransportayion_coast.setText(stransportayion_coast);

                                srto_expences=itemList.getString("RTO_Expenses");
                                edrto_expences.setText(srto_expences);


                                sinsurance_cost=itemList.getString("insurance_cost");
                                edinsurance_cost.setText(sinsurance_cost);

                                staxes_penalty=(itemList.getString("Taxes_penalty"));
                                edtaxes_penalty.setText(staxes_penalty);


                                srefurb_coast=itemList.getString("Refurb_cost");
                                edrefurb_coast.setText(srefurb_coast);

                                sparking_charges=itemList.getString("Parking_charges");
                                edparking_charges.setText(sparking_charges);

                                stotal_coast=(String.valueOf(totalcost));
                                edtotal_coast.setText(stotal_coast);

                                //getting assessts descriptions
                              //  String ashttpurl = "http://192.168.43.16/Hackathon/getassesstdescription.php";
                                String ashttpurl = "http://192.168.43.16/Hackathon/getassesstdescription.php";
                                StringRequest stringRequest = new StringRequest(Request.Method.POST, ashttpurl,
                                        new com.android.volley.Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {
                                                Log.e("spinner response",response);

                                                if (response !="error"){
                                                    //Toast.makeText(Report.this, response, Toast.LENGTH_SHORT).show();
                                                    Log.e("res",response);
                                                    try {
                                                        int flag =0;
                                                        JSONArray jsonArray = new JSONArray(response);
                                                        for (int i = 0; i < jsonArray.length(); i++) {
                                                            JSONObject itemList = jsonArray.getJSONObject(i);
                                                            String AssName = itemList.getString("Assessors_name");
                                                            String Parameter = itemList.getString("parameter_name");
                                                            String Conditon = itemList.getString("condition_name");
                                                            Log.e(AssName,Parameter+":"+Conditon);
                                                            String result = AssName.replaceAll("[\\-\\+\\.\\^:,]","");
                                                            Log.e("result",result);
                                                         //   if (result.equals("Engine")) {
                                                               Log.e("error","i am ");
                                                               if (flag == 0) {
                                                                   flag++;
                                                                   Log.e("error","i am ");

                                                                   pSilencer=Parameter;
                                                                   parSilencer.setText(pSilencer);

                                                                   cSilencer=Conditon;
                                                                   conSilencer.setText(cSilencer);


                                                               } else if (flag == 1) {
                                                                   parAbnormalEngineNoise.setText(Parameter);
                                                                   conEngineNoise.setText(Conditon);
                                                                   flag++;
                                                               } else if (flag == 2) {
                                                                   parPlugs.setText(Parameter);
                                                                   conPlugs.setText(Conditon);
                                                                   flag++;
                                                               } else if (flag == 3) {

                                                                   flag++;
                                                                   parOil.setText(Parameter);
                                                                   conOil.setText(Conditon);
                                                               } else if (flag == 4) {
                                                                   parRadiotorCondensor.setText(Parameter);
                                                                   conRadiotorCondensor.setText(Conditon);
                                                                   flag++;
                                                               } else if (flag == 5) {
                                                                   parOilLeakage.setText(Parameter);
                                                                   conOilleakage.setText(Conditon);
                                                                   flag++;
                                                               } else if (flag == 6) {
                                                                   parFanBelts.setText(Parameter);
                                                                   confanbelts.setText(Conditon);
                                                                   flag++;
                                                               } else if (flag == 7) {
                                                                   parFilters.setText(Parameter);
                                                                   conFilters.setText(Conditon);
                                                                   flag++;
                                                               }
                                                            //}else {
                                                           //    Log.e("i","out");
                                                          // }
                                                        }
                                                    } catch (JSONException e) {
                                                        e.printStackTrace();
                                                    }

                                                    Report1 r1 =  new Report1(getApplicationContext());
                                                    try {

                                                        r1.createPDF(sReference1,spurpose1,sBank,sContractno,sRequestfrom,sAssetMake,sAssetModel,sYearofmfg,srepossessiondate,sRCFitnessValid,sHMRKMR,sChassisNumber,sEngineNumber,srcno,sInspector,sLocation,srcstatus,sTaxStatus,srcstatus,sbuyer,swarenty_coast,stransportayion_coast,srto_expences,sinsurance_cost,staxes_penalty,srefurb_coast,sparking_charges,stotal_coast,pSilencer,cSilencer);
                                                    } catch (FileNotFoundException e) {
                                                        e.printStackTrace();
                                                    } catch (DocumentException e) {
                                                        e.printStackTrace();
                                                    }

                                                }else {
                                                    Toast.makeText(Report.this, response, Toast.LENGTH_LONG).show();
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
                                        //params.put("mainid",tempvalues.mainid);
                                        return params;
                                    }
                                };
                                // Creating RequestQueue.
                                RequestQueue requestQueue = Volley.newRequestQueue(Report.this);

                                // Adding the StringRequest object into requestQueue.
                                requestQueue.add(stringRequest);


//loadimages
   /*                            String imgshttpur = "http://192.168.43.251/hackathon/loadimg.php";
                                 stringRequest = new StringRequest(Request.Method.POST, httpurl,
                                        new com.android.volley.Response.Listener<String>() {
                                            @Override
                                            public void onResponse(String response) {

                                                try {

                                                    JSONArray jsonArray = new JSONArray(response);
                                                    for (int i = 0; i < jsonArray.length(); i++) {
                                                        JSONObject itemList = jsonArray.getJSONObject(i);
                                                        if(i==0){
                                                            Glide.with(Report.this)
                                                                    .load(itemList.getString("imageurl"))
                                                                    .into(i1);
                                                        }else if(i==1){
                                                            Glide.with(Report.this)
                                                                    .load(itemList.getString("imageurl"))
                                                                    .into(i2);
                                                        }

                                                    }
                                                }catch (JSONException e) {
                                                    e.printStackTrace();
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



                                        return params;
                                    }
                                };
                                // Creating RequestQueue.
                                 requestQueue = Volley.newRequestQueue(Report.this);

                                // Adding the StringRequest object into requestQueue.
                                requestQueue.add(stringRequest);
*/











                                //
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
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
             // tempvalues.mainid = "1";
                params.put("mainid",tempvalues.mainid);
                return params;
            }
        };
        // Creating RequestQueue.
        RequestQueue requestQueue = Volley.newRequestQueue(Report.this);

        // Adding the StringRequest object into requestQueue.
        requestQueue.add(stringRequest);








    }

    }


