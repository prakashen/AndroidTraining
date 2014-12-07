package com.ncit.android.prakash.androidtraining.WebServices;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.ncit.android.prakash.androidtraining.R;

import java.util.ArrayList;
import java.util.HashMap;

public class WebServicesActivity extends ListActivity{

    private Context context;
    private static String URL="http://docs.blackberry.com/sampledata.json";

    private static final String VTYPE="vehicleType";
    private static final String VCOLOR="vehicleColor";
    private static final String FUEL="fuel";
    private static final String TREAD="treadType";

    ArrayList<HashMap<String,String>> jsonList=new ArrayList<HashMap<String, String>>();
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_services);
        new ProgressTask(WebServicesActivity.this).execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.web_services, menu);
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

    private class ProgressTask extends AsyncTask<String,Void,Boolean> {
        private ProgressDialog dialog;
        ListActivity listActivity;
        public ProgressTask(ListActivity listActivity) {
            this.listActivity=listActivity;
            Context context= listActivity;
            dialog=new ProgressDialog(context);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.dialog.setMessage("Progress Start");
            this.dialog.show();
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            super.onPostExecute(success);
            if(dialog.isShowing()){
                dialog.dismiss();

            }
            ListAdapter adapter=new SimpleAdapter(context,jsonList,R.layout.list_item,new String[]{VTYPE,VCOLOR,
            FUEL,TREAD},new int[]{R.id.tvVehicleType,R.id.tvVehicleColor,R.id.tvFuel,R.id.tvTread});

            setListAdapter(adapter);
            lv=getListView();
        }

        @Override
        protected Boolean doInBackground(String... params) {

            JSONParser jparser=new JSONParser();
            //get json data from url
            JSONArray json=jparser.getJSONFromUrl(URL);

            for(int i=0;i<json.length();i++){
                try{
                    JSONObject c=json.getJSONObject(i);
                    String vtype=c.getString(VTYPE);
                    String vcolor=c.getString(VCOLOR);
                    String vfuel=c.getString(FUEL);
                    String vtread=c.getString(TREAD);


                    HashMap<String,String> map=new HashMap<String, String>();


                    map.put(VTYPE,vtype);
                    map.put(VCOLOR,vcolor);
                    map.put(FUEL,vfuel);
                    map.put(TREAD,vtread);

                    jsonList.add(map);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }



            return null;
        }
    }
}
