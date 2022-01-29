package com.example.nustahackathon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Hashtable;
import java.util.Map;

public class registerform extends AppCompatActivity {
    private EditText user;
    private EditText Pass;
    private EditText cpass;
    private String username;
    private String password;
    private String conpass;
    EditText mobno;
    static String mobnumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerform);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user = findViewById(R.id.user);
        Pass = findViewById(R.id.pass);
        cpass = findViewById(R.id.cpass);
        mobno=findViewById(R.id.mobno);

    }

    public void alreadyreg(View view) {
        Intent s=new Intent(registerform.this,Alreadyregister.class);
        startActivity(s);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i=new Intent(this,Alreadyregister.class);
        startActivityForResult(i,0);
        return true;
    }

    public void Register(View view) {
        username = user.getText().toString();
        password = Pass.getText().toString();
        conpass = cpass.getText().toString();

        if (conpass.equals(password)){


String UPLOAD_URL = "http://192.168.43.16/hackathon/Register.php";
            final ProgressDialog loading = ProgressDialog.show(this,"User Registering...","Please wait...",false,false);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                    new Response.Listener<String>() {


                        @Override
                        public void onResponse(String s) {
                            Log.e("re",s);
                            loading.dismiss();

                            Toast.makeText(registerform.this, s , Toast.LENGTH_LONG).show();

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            //Dismissing the progress dialog
                            loading.dismiss();

                            //Showing toast
                            //Toast.makeText(registerform.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                        }
                    }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    //Converting Bitmap to String
                    Map<String,String> params = new Hashtable<String, String>();
                    params.put("user", username);
                    params.put("pass", password);
                    return params;
                }
            };


            RequestQueue requestQueue = Volley.newRequestQueue(this);


            requestQueue.add(stringRequest);





        }else {
            Toast.makeText(this, "RE-Enter password Not match", Toast.LENGTH_SHORT).show();
        }

        Intent s=new Intent(registerform.this,MainActivity.class);
        mobnumber="+91"+mobno.getText().toString();
        startActivity(s);
    }

    public void Registerhere(View view) {
        Intent s=new Intent(registerform.this,Alreadyregister.class);
        startActivity(s);
    }


}
