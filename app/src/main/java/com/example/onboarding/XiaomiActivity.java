package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.onboarding.fragment_celular_xiaomi.CelularXiaomiMi11Fragment;
import com.example.onboarding.fragment_celular_xiaomi.CelularXiaomiMi9Fragment;
import com.example.onboarding.fragment_celular_xiaomi.CelularXiaomiRedmiFragment;
import com.example.onboarding.fragments_monitores.MonitorGigabyteFragment;

public class XiaomiActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaomi);
        RadioButton xbtnCXBoton1 = findViewById(R.id.btnCXBoton1);
        RadioButton xbtnCXBoton2 = findViewById(R.id.btnCXBoton2);
        RadioButton xbtnCXBoton3 = findViewById(R.id.btnCXBoton3);

        xbtnCXBoton1.setOnClickListener(this);
        xbtnCXBoton2.setOnClickListener(this);
        xbtnCXBoton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCXBoton1:
                mostrarBoton1();
                break;
            case R.id.btnCXBoton2:
                mostrarBoton2();
                break;
            case R.id.btnCXBoton3:
                mostrarBoton3();
                break;
        }
    }

    private void mostrarBoton1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenedorCelularXiaomi, new CelularXiaomiMi11Fragment())
                .commit();
    }

    private void mostrarBoton2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenedorCelularXiaomi, new CelularXiaomiRedmiFragment())
                .commit();
    }

    private void mostrarBoton3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenedorCelularXiaomi, new CelularXiaomiMi9Fragment())
                .commit();
    }
}