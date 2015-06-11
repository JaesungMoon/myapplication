package com.example.jaesungmoon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test
        Button btnGagebu = (Button)findViewById(R.id.buttonGagebu);
        btnGagebu.setOnClickListener(this);

        Button btnExit = (Button)findViewById(R.id.buttonExit);
        btnExit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonGagebu:
                startActivity(new Intent(this, GagebuActivity.class));
                break;
            case R.id.buttonExit:
                finish();
                break;
        }
    }
}
