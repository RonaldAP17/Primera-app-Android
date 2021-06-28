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

    ImageButton mImgBtnProcesadores, mImgBtnTarjetas, mImgBtnMonitores, mImgBtnAudifonos, mImgBtnCelulares, mImgBtnInicio;
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
        mImgBtnCelulares = findViewById(R.id.imgbtnCelulares);
        mImgBtnInicio = findViewById(R.id.imgBtnInicio);

        viewPager = findViewById(R.id.viewPager);

        CircleIndicator indicator = findViewById(R.id.indicator);
        adapter_pagina_inicio_walkthrough = new Adapter_pagina_inicio_walkthrough(getSupportFragmentManager());

        viewPager.setAdapter(adapter_pagina_inicio_walkthrough);

        indicator.setViewPager(viewPager);

        adapter_pagina_inicio_walkthrough.registerDataSetObserver(indicator.getDataSetObserver());

        Intent intent1 = new Intent(this,XiaomiActivity.class);
        Intent intent2 = new Intent(this,AppleActivity.class);
        Intent intent3 = new Intent(this,NotionActivity.class);
        Intent intent4 = new Intent(this,ToDoActivity.class);
    }

    public void verPaginaInicio(View view) {
        startActivity(new Intent(this, PaginaInicioActivity.class));
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

    public void verPaginaDatos(View view) {
        startActivity(new Intent(this, DatosActivity.class));
    }

    public void verPaginaMiBolsillo(View view) {
        startActivity(new Intent(this, MiBolsilloActivity.class));
    }
}