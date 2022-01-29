//******************.java

package com.example.nustahackathon;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class Contact extends AppCompatActivity  {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout=(DrawerLayout) findViewById(R.id.drawer);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i=new Intent(this,menus.class);
        startActivityForResult(i,0);
        return true;
    }



    public void mob1(View view) {

        Intent intent=new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:+919831088204"));
        startActivity(intent);
    }

    public void mob2(View view) {
        Intent intent=new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:+919038088204"));
        startActivity(intent);
    }


    public void mob3(View view) {
        Intent intent=new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:+913340048408"));
        startActivity(intent);
    }

    public void mob4(View view) {
        Intent intent=new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:+913340048422"));
        startActivity(intent);
    }

}
