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
    public void onClick1(View v){
        /*
        slkdhflhsldfb
        kljhsldfhlbsa
        KKKSADfk;ln

         */
    }
    public void onClick4(View v){
        /*
        slkdhflhsldfb미;ㄴ어;ㅣㅁ능

        kljhsldfhlbsa
        KKKSADfk;ln

         */
    }
    public void onClick5(View v){
        /*
        slkdhflhsldfb
        kljhsldfhlbㅁ니;ㅏ어;ㅏ미눙sa
        KKKSADfk;ln

         */
    }
    public void onClick7(View v){
        /*
        slkdhflhsldfb
        kljhsldfhlbsa
        KKKSADfk;ln

         */
    }
    public void onClick2(View v){
        /*
        slkdhflhsldfb
        kljhsldfhlbsa
        KKKSADfk;ln

         */
    }
}
