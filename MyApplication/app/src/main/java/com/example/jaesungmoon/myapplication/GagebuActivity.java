package com.example.jaesungmoon.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class GagebuActivity extends ActionBarActivity implements View.OnClickListener{

    TextView textViewWeek;
    int week = 1;
    EditText edt;
    int currentWeekIndex;
    LinearLayout layout1,layout2,layout3,layout4,layout5,layout6,layout7;
    LinearLayout layoutList[] = {layout1,layout2,layout3,layout4,layout5,layout6,layout7};
    TextView textViewTotalUse;
    int totalUse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gagebu);
        Button buttonChangeWeekPre = (Button)findViewById(R.id.buttonPre);
        Button buttonChangeWeekNext = (Button)findViewById(R.id.buttonNext);
        buttonChangeWeekPre.setOnClickListener(this);
        buttonChangeWeekNext.setOnClickListener(this);
        textViewWeek = (TextView)findViewById(R.id.textViewTitle);
        textViewTotalUse = (TextView)findViewById(R.id.textViewTotalUse);
        for (int i = 0 ; i < layoutList.length ; ++i){
            layoutList[i] = (LinearLayout)findViewById(R.id.layoutWeek1+i);

            TextView txt = (TextView)layoutList[i].findViewById(R.id.textViewWeekName);
            Button btn = (Button)layoutList[i].findViewById(R.id.buttonInput);
            btn.setOnClickListener(weekClickListener);

            txt.setText(R.string.week_name_1 + i);

            if(i == 5){//토요일
                txt.setTextColor(Color.BLUE);
            }else if(i == 6 ){//일요일
                txt.setTextColor(Color.RED);
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonPre:
                week--;
                break;
            case R.id.buttonNext:
                week++;
                break;

        }
        textViewWeek.setText("6월" + week + "주");

    }

    View.OnClickListener weekClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            LinearLayout ll = (LinearLayout)v.getParent();

            currentWeekIndex = ll.getId() - R.id.layoutWeek1;

            String weekName = getString(R.string.week_name_1 + currentWeekIndex);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(GagebuActivity.this);
            alertDialogBuilder.setTitle(weekName);
            alertDialogBuilder.setMessage(weekName + "의 지출를 입력하세요");
            edt = new EditText(GagebuActivity.this);
            edt.setInputType(InputType.TYPE_CLASS_NUMBER);
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
                    TextView tv = (TextView)layoutList[currentWeekIndex].findViewById(R.id.textViewWeekMemoUse);
                    tv.setText("지출 : " + text + " 원");

                    totalUse += Integer.parseInt(text);
                    textViewTotalUse.setText("총지출 : " + totalUse);
                    break;
            }
        }
    };
}
