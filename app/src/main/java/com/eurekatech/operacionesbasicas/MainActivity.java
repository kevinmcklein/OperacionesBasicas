package com.eurekatech.operacionesbasicas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;

    private CheckBox cb1, cb2, cb3, cb4;
    private TextView resulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 =  findViewById(R.id.et1);
        et2 =  findViewById(R.id.et2);
        cb1 =  findViewById(R.id.cb1);
        cb2 =  findViewById(R.id.cb2);
        cb3 =  findViewById(R.id.cb3);
        cb4 =  findViewById(R.id.cb4);

        resulta = findViewById(R.id.resulta);
        ocultateclado tecla=new ocultateclado();
        et2.setOnEditorActionListener(tecla);
    }

    class ocultateclado implements TextView.OnEditorActionListener{


        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId== EditorInfo.IME_ACTION_DONE){
            operar(null);
            }
            return false;
        }
    }

    public void operar(View view) {
        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        if (valor1.isEmpty() )valor1="0";
        if (valor2.isEmpty() )valor2="0";

        Double nro1 = Double.valueOf(valor1);
        Double nro2 = Double.valueOf(valor2);
        String resu = "";
        if (cb1.isChecked()) {
            Double suma = nro1 + nro2;
            resu = "La suma es: " + suma;
        }
        if (cb2.isChecked()) {
            Double resta = nro1 - nro2;
            resu = resu + "\n" + "La resta es: " + resta;
        }
        if (cb3.isChecked()) {
            Double producto = nro1 * nro2;
            resu = resu + "\n" + "El producto es: " + producto;
        }
        if (cb4.isChecked()) {
            if (nro2==0){
                resu = resu + "\n" + "El cociente es: " + "NA, division por cero";
            }
            else
            {
            Double cociente = nro1 / nro2;
            resu = resu + "\n" + " El cociente es: " + cociente;}
        }

        resulta.setText(resu);
    }
 public void salir(View v){
        finish();
 }
    public void acercade(View v) {
        Intent acerca =new Intent(this,acercade.class);
        startActivity(acerca);
    }

}
