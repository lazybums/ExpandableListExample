package com.lazybums.dummy;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    VendorListAdapter vListAdapter;
    ExpandableListView expListView;
    List<String> vendors;
    HashMap<String, List<String>> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expListView = (ExpandableListView) findViewById(R.id.expList);
        
        prepareListData();

        vListAdapter = new VendorListAdapter(this, vendors, items);
        expListView.setAdapter(vListAdapter);
    }

    private void prepareListData() {
        vendors = new ArrayList<String>();
        items = new HashMap<String, List<String>>();

        String[] title={"Vendor1","Vendor2","Vendor3"};

        for(int i=0;i<title.length;i++){
            vendors.add(title[i]);
            ArrayList<String> tempItems = new ArrayList<>();

            for(int j=0;j<10;j++){
                tempItems.add(title[i]+"_item"+j);
            }
            items.put(title[i],tempItems);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
