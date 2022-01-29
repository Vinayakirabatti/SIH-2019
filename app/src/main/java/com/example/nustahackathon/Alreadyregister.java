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

public class Alreadyregister extends AppCompatActivity {
private String username;
private String password;
private EditText user;
private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alreadyregister);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        user= findViewById(R.id.user);
        pass = findViewById(R.id.pass);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i= new Intent(this,menus.class);
        startActivityForResult(i,0);
        return super.onOptionsItemSelected(item);
    }

    public void Registerhere(View view) {
        Intent s=new Intent(Alreadyregister.this,registerform.class);
        startActivity(s);
    }

    public void Login(View view) {


        username = user.getText().toString();
        password = pass.getText().toString();


        String UPLOAD_URL = "http://192.168.43.16/hackathon/login.php";
        final ProgressDialog loading = ProgressDialog.show(this,"User Login...","Please wait...",false,false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String s) {
                        Log.e("re",s);
                        loading.dismiss();

                        Toast.makeText(Alreadyregister.this, s , Toast.LENGTH_LONG).show();
                        Intent ss=new Intent(Alreadyregister.this,inspectionlist.class);
                        ss.putExtra("user",username);
                        ss.putExtra("ref",tempvalues.ref);
                        startActivity(ss);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        //Dismissing the progress dialog
                        loading.dismiss();

                        //Showing toast
                        Toast.makeText(Alreadyregister.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
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
    }
}
