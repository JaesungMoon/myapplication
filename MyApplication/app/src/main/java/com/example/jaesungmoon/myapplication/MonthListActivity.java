package com.example.jaesungmoon.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MonthListActivity extends ActionBarActivity {

    ListView listView;
    ArrayList<MonthItem> monthItemList;
    MonthListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_list);
        listView = (ListView)findViewById(R.id.listView);
        monthItemList = new ArrayList<MonthItem>();

        for (int i = 0 ; i < 31 ; ++i){
            MonthItem item = new MonthItem();
            item.day = i+1;
            monthItemList.add(item);
        }
        adapter = new MonthListAdapter(this, monthItemList, listCallback);
        listView.setAdapter(adapter);
    }

    MonthListCallback listCallback = new MonthListCallback() {
        @Override
        void callback(int day, int money) {
            Toast.makeText(getBaseContext(),"다이얼로그 클릭 dayIndex = " + day + ", money = " + money, Toast.LENGTH_SHORT).show();
            MonthItem item = monthItemList.get(day);
            item.use = money;
            monthItemList.set(day, item);
            adapter.notifyDataSetChanged();
            int total = 0;
            //총 수입 지출 잔고 처리
            for(int  i = 0 ; i < monthItemList.size() ; i++){
                MonthItem month = monthItemList.get(i);
                total += month.use;
            }
            Log.i("DEBUG","total = " + total);
        }
    };

}
