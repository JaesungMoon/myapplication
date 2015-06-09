package com.example.jaesungmoon.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GagebuActivity extends ActionBarActivity implements View.OnClickListener{

    TextView textViewWeek;
    int week;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gagebu);
        Button btnChangeWeek = (Button)findViewById(R.id.buttonChangeWeek);
        btnChangeWeek.setOnClickListener(this);
        textViewWeek = (TextView)findViewById(R.id.textViewWeek);

    }

    @Override
    public void onClick(View v) {
        week++;
        textViewWeek.setText("6월" + week + "주차");
    }
}
