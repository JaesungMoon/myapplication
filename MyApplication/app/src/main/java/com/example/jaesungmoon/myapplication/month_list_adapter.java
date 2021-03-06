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
 * Created by jsdekiru on 15. 7. 8..
 */
public class month_list_adapter extends BaseAdapter {

    ArrayList<monthitemtest> list;
    Context context;
    public month_list_adapter(Context context, ArrayList<monthitemtest> monthItemList) {
        list = monthItemList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        monthitemtest item = list.get(position);
        View view = View.inflate(context, R.layout.month_item, null);
        TextView tvDay = (TextView)view.findViewById(R.id.textViewDay);
        TextView tvGain = (TextView)view.findViewById(R.id.textViewGain);
        TextView tvUse = (TextView)view.findViewById(R.id.textViewuse);
        tvDay.setText("" + item.day + "day");
        tvGain.setText("" + item.gain + "won");
        tvUse.setText("" + item.use + "won");

        Button btn = (Button) view.findViewById(R.id.buttonInput);
        btn.setOnClickListener(weekClickListener);


        return view;
    }

    View.OnClickListener weekClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("title");
            alertDialogBuilder.setMessage("use enter");
            EditText edt = new EditText(context);
            edt.setInputType(InputType.TYPE_CLASS_NUMBER);
            alertDialogBuilder.setView(edt);
            alertDialogBuilder.setNegativeButton("Cancel",alertClickListener);
            alertDialogBuilder.setPositiveButton("save",alertClickListener);
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
