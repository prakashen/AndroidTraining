package com.ncit.android.prakash.androidtraining.Database;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.ncit.android.prakash.androidtraining.R;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.List;

public class DatabaseActivity extends ListActivity {

    private StudentsOperation studentDbOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        studentDbOperation=new StudentsOperation(this);
        try {
            studentDbOperation.open();
            List values=studentDbOperation.getAllStudents();
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,values);
            setListAdapter(adapter);

        } catch (SQLException e) {
            e.printStackTrace();


        }}

        public void addUser(View view) {

            ArrayAdapter adapter = (ArrayAdapter) getListAdapter();

            EditText text = (EditText) findViewById(R.id.etStName);
            Student stud = studentDbOperation.addStudent(text.getText().toString());
            //text.setTextColor(null);

            adapter.add(stud);
            //text.setTextColor(null);


        }

    public void deleteFirstUser(View view) {

        ArrayAdapter adapter = (ArrayAdapter) getListAdapter();
        Student stud = null;

        if (getListAdapter().getCount() > 0) {
            stud = (Student) getListAdapter().getItem(0);
            studentDbOperation.deleteStudent(stud);
            adapter.remove(stud);
        }

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.database, menu);
        return true;
    }

    @Override
    protected void onResume() {
        try {
            studentDbOperation.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        studentDbOperation.close();
        super.onPause();
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
