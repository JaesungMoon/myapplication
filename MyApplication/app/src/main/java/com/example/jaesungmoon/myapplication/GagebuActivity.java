package com.example.jaesungmoon.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class GagebuActivity extends ActionBarActivity implements View.OnClickListener{

    TextView textViewWeek;
    int week = 1;
    EditText edt;
    int currentViewId;
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
            switch (v.getId()){
                case R.id.buttonWeek01:
                    currentViewId = R.id.textViewWeek1;
                    break;
                case R.id.buttonWeek02:
                    currentViewId = R.id.textViewWeek2;
                    break;
            }
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GagebuActivity.this);
            alertDialogBuilder.setTitle("Title");
            alertDialogBuilder.setMessage("memo를 입력하세요");
            edt = new EditText(GagebuActivity.this);
            alertDialogBuilder.setView(edt);
            alertDialogBuilder.setNegativeButton("Cancel",alertClickListener);
            alertDialogBuilder.setPositiveButton("저장",alertClickListener);
            alertDialogBuilder.show();
        }
    };
    DialogInterface.OnClickListener alertClickListener = new DialogInterface.OnClickListener(){

        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_NEGATIVE:

                    break;
                case DialogInterface.BUTTON_POSITIVE:
                    String text =  edt.getText().toString();
                    TextView tv = (TextView)findViewById(currentViewId);
                    tv.setText(text);
                    break;
            }
        }
    };
}
