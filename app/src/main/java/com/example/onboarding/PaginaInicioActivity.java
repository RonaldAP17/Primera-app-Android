package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.onboarding.Adapter.Adapter_pagina_inicio_walkthrough;
import com.example.onboarding.Adapter.Adapter_walkthrough;

import me.relex.circleindicator.CircleIndicator;

public class PaginaInicioActivity extends AppCompatActivity {

    ImageButton mImgBtnProcesadores, mImgBtnTarjetas, mImgBtnMonitores, mImgBtnAudifonos;
    Button mBtnCelulares;
    public ViewPager viewPager;
    Adapter_pagina_inicio_walkthrough adapter_pagina_inicio_walkthrough;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicio);

        mImgBtnProcesadores = findViewById(R.id.imgbtnProcesadores);
        mImgBtnTarjetas = findViewById(R.id.imgbtnTarjetas);
        mImgBtnMonitores = findViewById(R.id.imgbtnMonitores);
        mImgBtnAudifonos = findViewById(R.id.imgbtnAudifonos);
        mBtnCelulares = findViewById(R.id.btnCelulares);

        viewPager = findViewById(R.id.viewPager);

        CircleIndicator indicator = findViewById(R.id.indicator);
        adapter_pagina_inicio_walkthrough = new Adapter_pagina_inicio_walkthrough(getSupportFragmentManager());

        viewPager.setAdapter(adapter_pagina_inicio_walkthrough);

        indicator.setViewPager(viewPager);

        adapter_pagina_inicio_walkthrough.registerDataSetObserver(indicator.getDataSetObserver());

        Intent intent1 = new Intent(this, ProcesadoresActivity.class);

    }

    public void verPaginaProcesador(View view) {
        startActivity(new Intent(this, ProcesadoresActivity.class));
    }

    public void verPaginaTarjeta(View view) {
        startActivity(new Intent(this, TarjetasActivity.class));
    }

    public void verPaginaMonitor(View view) {
        startActivity(new Intent(this, MonitoresActivity.class));
    }

    public void verPaginaAudifono(View view) {
        startActivity(new Intent(this, AudifonosActivity.class));
    }

    public void verPaginaCelulares(View view) {
        startActivity(new Intent(this, CelularesActivity.class));
    }
}