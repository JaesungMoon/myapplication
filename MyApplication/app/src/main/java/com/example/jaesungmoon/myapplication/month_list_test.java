package com.example.jaesungmoon.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class month_list_test extends ActionBarActivity {

    ListView listView;
    ArrayList<monthitemtest> monthItemListtest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_list_test);
        listView = (ListView)findViewById(R.id.listView);
        monthItemListtest = new ArrayList<monthitemtest>();

        for (int i = 0 ; i < 31 ; ++i){
            monthitemtest item = new monthitemtest();
            item.day = i+1;
            monthItemListtest.add(item);
        }

        month_list_adapter adapter = new month_list_adapter(this, monthItemListtest);

        listView.setAdapter(adapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_month_list_test, menu);
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
