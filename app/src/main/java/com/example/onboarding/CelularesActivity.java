package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.onboarding.Adapter.Adapter_pagina_celulares_walkthrough;
import com.example.onboarding.Adapter.Adapter_pagina_inicio_walkthrough;

import me.relex.circleindicator.CircleIndicator;

public class CelularesActivity extends AppCompatActivity {

    ImageButton mImgBtnXiaomi,mImgBtnApple,mImgBtnNotion ,mImgBtnToDo, mImgBtnCelulares, mImgBtnInicio;
    ViewPager viewPager;
    Adapter_pagina_celulares_walkthrough adapter_pagina_celulares_walkthrough;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celulares);
        //Cada uno de los botones en el xml se especifica aca.
        mImgBtnXiaomi = findViewById(R.id.imgbtnXiaomi);
        mImgBtnApple = findViewById(R.id.imgbtnApple);
        mImgBtnNotion = findViewById(R.id.imgbtnNotion);
        mImgBtnToDo = findViewById(R.id.imgbtnToDo);
        mImgBtnCelulares = findViewById(R.id.imgbtnCelulares);
        mImgBtnInicio = findViewById(R.id.imgBtnInicio);

        //Este es el codigo necesario para que el slide funcione.

        viewPager = findViewById(R.id.viewPager);

        CircleIndicator indicator = findViewById(R.id.indicator);
        adapter_pagina_celulares_walkthrough = new Adapter_pagina_celulares_walkthrough(getSupportFragmentManager());

        viewPager.setAdapter(adapter_pagina_celulares_walkthrough);

        indicator.setViewPager(viewPager);

        adapter_pagina_celulares_walkthrough.registerDataSetObserver(indicator.getDataSetObserver());

        Intent intent1 = new Intent(this,XiaomiActivity.class);
        Intent intent2 = new Intent(this,AppleActivity.class);
        Intent intent3 = new Intent(this,NotionActivity.class);
        Intent intent4 = new Intent(this,ToDoActivity.class);
    }

    //Con esto se puede ejecutar un activity segun el proceso que tenga el boton.

    public void verPaginaXiaomi(View view) {
            startActivity(new Intent(this, XiaomiActivity.class));
        }

    public void verPaginaApple(View view) {
        startActivity(new Intent(this, AppleActivity.class));
    }

    public void verPaginaNotion(View view) {
        startActivity(new Intent(this, NotionActivity.class));
    }

    public void verPaginaToDo(View view) {

        startActivity(new Intent(this, ToDoActivity.class));
    }

    public void verPaginaInicio(View view) {
        startActivity(new Intent(this, PaginaInicioActivity.class));
    }

    public void verPaginaCelulares(View view) {
        startActivity(new Intent(this, CelularesActivity.class));
    }
}