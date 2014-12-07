package com.ncit.android.prakash.androidtraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ncit.android.prakash.androidtraining.Call.CallActivity;
import com.ncit.android.prakash.androidtraining.Database.DatabaseActivity;
import com.ncit.android.prakash.androidtraining.ListView.ListViewActivity;
import com.ncit.android.prakash.androidtraining.SharedPreferences.SharedPreferencesActivity;
import com.ncit.android.prakash.androidtraining.WebServices.WebServicesActivity;


public class Main extends Activity  implements View.OnClickListener{

     private Button listView,styling,database,sPref,webview,webservices,call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing the variables
        listView=(Button)findViewById(R.id.btListview);
        styling=(Button)findViewById(R.id.btstyling);
        database=(Button)findViewById(R.id.btdatabase);
        sPref=(Button)findViewById(R.id.btshpreferences);
        webview=(Button)findViewById(R.id.btwebview);
        webservices=(Button)findViewById(R.id.btWebservices);
        call=(Button)findViewById(R.id.btCallSample);


       //set onclick
        listView.setOnClickListener(this);
        styling.setOnClickListener(this);
        database.setOnClickListener(this);
        sPref.setOnClickListener(this);
        webview.setOnClickListener(this);
        webservices.setOnClickListener(this);
        call.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btListview:
                //Toast.makeText(getApplicationContext(),"This is List View",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),ListViewActivity.class));
                break;
            case R.id.btstyling:
                Toast.makeText(getApplicationContext(),"This is styling",Toast.LENGTH_LONG).show();
                break;
            case R.id.btdatabase:
                //Toast.makeText(getApplicationContext(),"This is database",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),DatabaseActivity.class));
                break;
            case R.id.btshpreferences:
                //Toast.makeText(getApplicationContext(),"This is shared preferences",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),SharedPreferencesActivity.class));
                break;
            case R.id.btwebview:
                Toast.makeText(getApplicationContext(),"This is web View",Toast.LENGTH_LONG).show();
                break;
            case R.id.btWebservices:
                //Toast.makeText(getApplicationContext(),"This is Webservices",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),WebServicesActivity.class));
                break;
            case R.id.btCallSample:
                //Toast.makeText(getApplicationContext(),"This is Call Sample",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(),CallActivity.class));
                break;

        }

    }
}
