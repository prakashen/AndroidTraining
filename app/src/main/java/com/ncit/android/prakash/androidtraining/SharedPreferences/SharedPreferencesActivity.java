package com.ncit.android.prakash.androidtraining.SharedPreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.ncit.android.prakash.androidtraining.R;

public class SharedPreferencesActivity extends Activity  {

    CheckBox checkBox;
    EditText name;
    Button btSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        checkBox=(CheckBox)findViewById(R.id.cbshpref);
        name=(EditText)findViewById(R.id.etspref);
        btSave=(Button)findViewById(R.id.btspref);


        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePreferences("CheckBox_Value", checkBox.isChecked());
                if (checkBox.isChecked())
                    savePreferences("storeName", name.getText().toString());

                finish();

            }
        });
        loadSavePreferences();
    }

    private void loadSavePreferences() {
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        boolean checkBoxValue=sharedPreferences.getBoolean("checkBox_Value",false);
        String name1=sharedPreferences.getString("storeName","YourName");
        if(checkBoxValue){
            checkBox.setChecked(true);
        }else{
            checkBox.setChecked(false);
        }
       name.setText(name1);
    }

    private void savePreferences(String key,Boolean values){
        SharedPreferences sharePreferences=PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharePreferences.edit();
        editor.putBoolean(key,values);
        editor.commit();

    }

    private void savePreferences(String key,String values){
        SharedPreferences sharePreferences=PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharePreferences.edit();
        editor.putString(key, values);
        editor.commit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shared_preferences, menu);
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



}
