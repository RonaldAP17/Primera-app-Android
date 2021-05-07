package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.RadioButton;

import com.example.onboarding.fragments_monitores.MonitorAorusFragment;
import com.example.onboarding.fragments_monitores.MonitorGigabyteFragment;
import com.example.onboarding.fragments_monitores.MonitorMSIFragment;

public class MonitoresActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitores);
        RadioButton mbtnBoton1 = findViewById(R.id.btnBoton1);
        RadioButton mbtnBoton2 = findViewById(R.id.btnBoton2);
        RadioButton mbtnBoton3 = findViewById(R.id.btnBoton3);

        mbtnBoton1.setOnClickListener(this);
        mbtnBoton2.setOnClickListener(this);
        mbtnBoton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBoton1:
                mostrarBoton1();
                break;
            case R.id.btnBoton2:
                mostrarBoton2();
                break;
            case R.id.btnBoton3:
                mostrarBoton3();
                break;
        }
    }

    private void mostrarBoton1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenerdorCelularXiomi, new MonitorGigabyteFragment())
                .commit();
    }

    private void mostrarBoton2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenerdorCelularXiomi, new MonitorAorusFragment())
                .commit();
    }

    private void mostrarBoton3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenerdorCelularXiomi, new MonitorMSIFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_inicio_de_pagina, menu);
        return true;
    }
}