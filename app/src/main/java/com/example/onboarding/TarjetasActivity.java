package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.RadioButton;

import com.example.onboarding.fragment_tarjetas.TarjetaNvidia1660Fragment;
import com.example.onboarding.fragment_tarjetas.TarjetaNvidia3080Fragment;
import com.example.onboarding.fragment_tarjetas.TarjetaRadeon6700Fragment;
import com.example.onboarding.fragments_monitores.MonitorGigabyteFragment;

public class TarjetasActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjetas);
        RadioButton tbtnTGBoton1 = findViewById(R.id.btnTGBoton1);
        RadioButton tbtnTGBoton2 = findViewById(R.id.btnTGBoton2);
        RadioButton tbtnTGBoton3 = findViewById(R.id.btnTGBoton3);

        tbtnTGBoton1.setOnClickListener(this);
        tbtnTGBoton2.setOnClickListener(this);
        tbtnTGBoton3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTGBoton1:
                mostrarBoton1();
                break;
            case R.id.btnTGBoton2:
                mostrarBoton2();
                break;
            case R.id.btnTGBoton3:
                mostrarBoton3();
                break;
        }
    }

    private void mostrarBoton1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenedorTarjetas, new TarjetaNvidia1660Fragment())
                .commit();
    }

    private void mostrarBoton2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenedorTarjetas, new TarjetaRadeon6700Fragment())
                .commit();
    }

    private void mostrarBoton3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenedorTarjetas, new TarjetaNvidia3080Fragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_inicio_de_pagina, menu);
        return true;
    }

}