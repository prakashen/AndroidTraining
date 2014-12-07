package com.ncit.android.prakash.androidtraining.Call;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.ncit.android.prakash.androidtraining.R;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class CallActivity extends ListActivity {

    private EditText phNumber;
    private Button  callbtn;
    List<String> listItem;



    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        phNumber=(EditText)findViewById(R.id.etphno);
        listItem=new ArrayList<String>();
        ListView lv=(ListView)findViewById(android.R.id.list);

        ContentResolver cr=getContentResolver();
        Cursor cursor= cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);

        if(cursor.getCount()>0){
            while (cursor.moveToNext()){
                String id=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) >0){
                    Cursor pcursor=cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"= ?",
                            new String[] {id},null);

                    //listItem=new ArrayList<String>();
                    while (pcursor.moveToNext()){


                         listItem.add(name);






                    }

                    System.out.println("ListView size "+listItem.size());
                    final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,listItem);
                    setListAdapter(adapter);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                           // private int phone= ContactsContract.Contacts.
                        }
                    });
                    pcursor.close();



                    //final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,listItem);
                }
                }
            }



    }

    public void btnClick(View v){
        String phoneNumber=phNumber.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                + phoneNumber));
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.call, menu);
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
