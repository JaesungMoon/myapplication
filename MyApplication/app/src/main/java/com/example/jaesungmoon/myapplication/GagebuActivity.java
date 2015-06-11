package com.example.jaesungmoon.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GagebuActivity extends ActionBarActivity implements View.OnClickListener{

    TextView textViewWeek;
    int week = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gagebu);
        Button buttonChangeWeekPre = (Button)findViewById(R.id.buttonChangeWeekPre);
        Button buttonChangeWeekNext = (Button)findViewById(R.id.buttonChangeWeekNext);
        buttonChangeWeekPre.setOnClickListener(this);
        buttonChangeWeekNext.setOnClickListener(this);
        textViewWeek = (TextView)findViewById(R.id.textViewWeek);


        Button btnWeek01 = (Button)findViewById(R.id.buttonWeek01);
        Button btnWeek02 = (Button)findViewById(R.id.buttonWeek02);

        btnWeek01.setOnClickListener(weekClickListener);
        btnWeek02.setOnClickListener(weekClickListener);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonChangeWeekPre:
                week--;
                break;
            case R.id.buttonChangeWeekNext:
                week++;
                break;
            case R.id.buttonWeek01:
                break;
        }
        textViewWeek.setText("6월" + week + "주");
    }

    View.OnClickListener weekClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GagebuActivity.this);
            alertDialogBuilder.setTitle("Title");
            alertDialogBuilder.setMessage("memo를 입력하세요");
            alertDialogBuilder.setNegativeButton("Cancel",alertClickListener);
            alertDialogBuilder.setPositiveButton("저장",alertClickListener);
            alertDialogBuilder.show();
        }
    };
    DialogInterface.OnClickListener alertClickListener;
}
