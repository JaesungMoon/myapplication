package com.example.jaesungmoon.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MonthListActivity extends ActionBarActivity {


    ListView listView;
    ArrayList<MonthItem> monthItemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_list);
        listView = (ListView)findViewById(R.id.listView);
        monthItemList = new ArrayList<MonthItem>();

        for (int i = 0 ; i < 31 ; ++i){
            MonthItem item = new MonthItem();
            item.day = i+1;
            item.gain = i * 100;
            item.use = i * 30;
            monthItemList.add(item);
        }

        MonthListAdapter adapter = new MonthListAdapter(this, monthItemList);

        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_month_list, menu);
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
