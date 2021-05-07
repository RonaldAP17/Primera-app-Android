package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.onboarding.fragments_audifonos.AudifonoBoseFragment;
import com.example.onboarding.fragments_audifonos.AudifonoSkullcaFragment;
import com.example.onboarding.fragments_audifonos.AudifonoSonyFragment;
import com.example.onboarding.fragments_monitores.MonitorGigabyteFragment;

public class AudifonosActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audifonos);
        RadioButton abtnABoton1 = findViewById(R.id.btnABoton1);
        RadioButton abtnABoton2 = findViewById(R.id.btnABoton2);
        RadioButton abtnABoton3 = findViewById(R.id.btnABoton3);

        abtnABoton1.setOnClickListener(this);
        abtnABoton2.setOnClickListener(this);
        abtnABoton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnABoton1:
                mostrarBoton1();
                break;
            case R.id.btnABoton2:
                mostrarBoton2();
                break;
            case R.id.btnABoton3:
                mostrarBoton3();
                break;
        }
    }

    private void mostrarBoton3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenedorAudifonos, new AudifonoBoseFragment())
                .commit();
    }

    private void mostrarBoton2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenedorAudifonos, new AudifonoSonyFragment())
                .commit();
    }

    private void mostrarBoton1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenedorAudifonos, new AudifonoSkullcaFragment())
                .commit();
    }
}