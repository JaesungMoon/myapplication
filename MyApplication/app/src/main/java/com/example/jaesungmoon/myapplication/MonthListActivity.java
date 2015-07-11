package com.example.jaesungmoon.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MonthListActivity extends ActionBarActivity {

    ListView listView;
    ArrayList<MonthItem> monthItemList;
    MonthListAdapter adapter;
    TextView textViewMonthlyTotalUse;
    TextView textViewMonthlyTotalGain;
    TextView textViewMonthlyTotalSum;
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
        textViewMonthlyTotalUse = (TextView) findViewById(R.id.textViewMonthlyTotalUse);
        textViewMonthlyTotalGain = (TextView) findViewById(R.id.textViewMonthlyTotalGain);
        textViewMonthlyTotalSum = (TextView) findViewById(R.id.textViewMonthlyTotalSum);

    }

    MonthListCallback listCallback = new MonthListCallback() {
        @Override
        void callback(int day, int money) {
            Toast.makeText(getBaseContext(),"다이얼로그 클릭 dayIndex = " + day + ", money = " + money, Toast.LENGTH_SHORT).show();
            MonthItem item = monthItemList.get(day);
            if(money < 0){
                item.gain = -money;
            }else{
                item.use = money;
            }

            monthItemList.set(day, item);
            adapter.notifyDataSetChanged();
            int total = 0;
            int totalUse = 0;
            int totalGain = 0;
            //총 수입 지출 잔고 처리
            for(int  i = 0 ; i < monthItemList.size() ; i++){
                MonthItem month = monthItemList.get(i);
                totalUse += month.use;
                totalGain += month.gain;

            }
            total = totalGain - totalUse;


            Log.i("DEBUG","totalGain = " + totalGain);
            Log.i("DEBUG","totalUse = " + totalUse);
            Log.i("DEBUG","total = " + total);

            textViewMonthlyTotalGain.setText("수입 : " + totalGain);
            textViewMonthlyTotalUse.setText("지출 : " + totalUse);
            textViewMonthlyTotalSum.setText("잔고 : " + total);

        }
    };

}
