package com.example.jaesungmoon.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity2Activity extends ActionBarActivity implements View.OnClickListener{

    TextView textViewWeek;
    LinearLayout layout1, layout2, layout3, layout4, layout5, layout6, layout7;
    LinearLayout layoutlist[]= {layout1, layout2, layout3, layout4, layout5, layout6, layout7};
    int week = 1;

    EditText edt;
    int currentWeekIndex;
    TextView textViewTotalUse;
    int totalUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        Button buttonChangeWeekPre = (Button) findViewById(R.id.buttonPre);
        Button buttonChangeWeekNext = (Button) findViewById(R.id.buttonNext);
        buttonChangeWeekPre.setOnClickListener(this);
        buttonChangeWeekNext.setOnClickListener(this);


        textViewWeek = (TextView) findViewById(R.id.textViewTitle);
        textViewTotalUse = (TextView)findViewById(R.id.textViewTotalUse);

        for (int i = 0; i < layoutlist.length; ++i) {
            layoutlist[i] = (LinearLayout) findViewById(R.id.layoutWeek1 + i);
            TextView txt = (TextView) layoutlist[i].findViewById(R.id.textViewWeekNameTest);
            Button btn = (Button) layoutlist[i].findViewById(R.id.buttonInput_test);

            btn.setOnClickListener(weekClickListener);

            txt.setText(R.string.week_name_test_1 + i);
            if (i == 5) {
                txt.setTextColor(Color.BLUE);
            } else if (i == 6) {
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

            String weekName = getString(R.string.week_name_test_1 + currentWeekIndex);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity2Activity.this);
            alertDialogBuilder.setTitle(weekName);
            alertDialogBuilder.setMessage(weekName + "의 지출를 입력하세요");
            edt = new EditText(MainActivity2Activity.this);
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
                    TextView tv = (TextView)layoutlist[currentWeekIndex].findViewById(R.id.textViewWeekSpend);
                    tv.setText("지출 : " + text + " 원");
                        

                    totalUse += Integer.parseInt(text);
                    //현상:버그 돈이 계속 추가만 된다
                    //원인:어떤주의 텍스트인지 구분하지않음
                    //해결방법:어떤주의 텍스트인지 구분하기

                    //done!
                    
                    textViewTotalUse.setText("총지출 : " + totalUse);
                    break;
            }
        }
    };
}
