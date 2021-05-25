package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.RadioButton;

import com.example.onboarding.fragment_procesadores.ProcesadorI11Fragment;
import com.example.onboarding.fragment_procesadores.ProcesadorR5Fragment;
import com.example.onboarding.fragment_procesadores.ProcesadorR9Fragment;
import com.example.onboarding.fragments_monitores.MonitorAorusFragment;
import com.example.onboarding.fragments_monitores.MonitorGigabyteFragment;
import com.example.onboarding.fragments_monitores.MonitorMSIFragment;

public class ProcesadoresActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procesadores);
        RadioButton pbtnPBoton1 = findViewById(R.id.btnPBoton1);
        RadioButton pbtnPBoton2 = findViewById(R.id.btnPBoton2);
        RadioButton pbtnPBoton3 = findViewById(R.id.btnPBoton3);

        pbtnPBoton1.setOnClickListener(this);
        pbtnPBoton2.setOnClickListener(this);
        pbtnPBoton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPBoton1:
                mostrarBoton1();
                break;
            case R.id.btnPBoton2:
                mostrarBoton2();
                break;
            case R.id.btnPBoton3:
                mostrarBoton3();
                break;
        }
    }

    private void mostrarBoton1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenerdoProcesadores, new ProcesadorI11Fragment())
                .commit();
    }

    private void mostrarBoton2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenerdoProcesadores, new ProcesadorR5Fragment())
                .commit();
    }

    private void mostrarBoton3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenerdoProcesadores, new ProcesadorR9Fragment())
                .commit();
    }
}