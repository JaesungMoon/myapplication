package com.example.jaesungmoon.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jsdekiru on 15. 6. 24..
 */
public class MonthListAdapter extends BaseAdapter{

    ArrayList<MonthItem> list;
    Context context;
    public MonthListAdapter(Context context, ArrayList<MonthItem> monthItemList) {
        list = monthItemList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MonthItem item = list.get(position);
        View view = View.inflate(context, R.layout.month_item, null);
        TextView tvDay = (TextView)view.findViewById(R.id.textViewDay);
        TextView tvGain = (TextView)view.findViewById(R.id.textViewGain);
        TextView tvUse = (TextView)view.findViewById(R.id.textViewuse);
        tvDay.setText("" + item.day + "일");
        tvGain.setText("" + item.gain + "원");
        tvUse.setText("" + item.use + "원");

        Button btn = (Button) view.findViewById(R.id.buttonInput);
        btn.setOnClickListener(weekClickListener);


        return view;
    }

    View.OnClickListener weekClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("title");
            alertDialogBuilder.setMessage("해당요일의 지출를 입력하세요");
            EditText edt = new EditText(context);
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
//                    String text =  edt.getText().toString();
//                    TextView tv = (TextView)layoutlist[currentWeekIndex].findViewById(R.id.textViewWeekSpend);
//                    tv.setText("지출 : " + text + " 원");


//                    totalUse += Integer.parseInt(text);
                    //현상:버그 돈이 계속 추가만 된다
                    //원인:어떤주의 텍스트인지 구분하지않음
                    //해결방법:어떤주의 텍스트인지 구분하기

                    //done!
                    //소스트리 테스트
                    //
                    //
//                    textViewTotalUse.setText("총지출 : " + totalUse);
                    break;
            }
        }
    };
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}