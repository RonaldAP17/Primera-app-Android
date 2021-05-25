package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
    }

    public void verPaginaWebGratuito(View view) {
        startActivity(new Intent(this, WebGratuitaActivity.class));
    }

    public void verPaginaWebPropia(View view) {
        startActivity(new Intent(this, WebPropiaActivity.class));
    }

    public void verPaginaInicio(View view) {
        startActivity(new Intent(this, PaginaInicioActivity.class));
    }

    public void verPaginaCelulares(View view) {
        startActivity(new Intent(this, CelularesActivity.class));
    }

    public void verPaginaDatos(View view) {
        startActivity(new Intent(this, DatosActivity.class));
    }

    public void verInfoServicio(View view) {
        startActivity(new Intent(this, InfoServicioActivity.class));
    }
}