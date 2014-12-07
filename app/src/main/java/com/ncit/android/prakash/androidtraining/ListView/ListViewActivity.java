package com.ncit.android.prakash.androidtraining.ListView;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ncit.android.prakash.androidtraining.R;

import java.util.List;

public class ListViewActivity extends ListActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ListView lview=(ListView)findViewById(android.R.id.list);

        String[] values= new String[] {"Apple","Google","Microsoft","Amazon",
                "AirBnb","Twitter","Facebook","Buffer","Lava","motorola","sony","yahoo"};
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,android.R.id.text1,values);
        setListAdapter(adapter);
       // Log.e("adapter",adapter.toString());

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPostiton=position;
                String itemValue=(String)adapter.getItem(position);
                Toast.makeText(getApplicationContext(),+itemPostiton+"/"+itemValue,Toast.LENGTH_LONG).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view, menu);
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
