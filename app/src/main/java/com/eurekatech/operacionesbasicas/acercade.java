package com.eurekatech.operacionesbasicas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class acercade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);
    }
    public void salir(View v){
        finish();
    }
}
