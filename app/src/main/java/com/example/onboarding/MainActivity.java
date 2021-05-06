package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.onboarding.Adapter.Adapter_walkthrough;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    Button mBtnComenzar;
    public ViewPager viewPager;
    Adapter_walkthrough adapter_walkthrough;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mBtnComenzar = findViewById(R.id.btnComenzar);

        //Estas lineas de codigo son para el onboarding
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        viewPager = findViewById(R.id.viewPager);

        CircleIndicator indicator = findViewById(R.id.indicator);
        adapter_walkthrough = new Adapter_walkthrough(getSupportFragmentManager());

        viewPager.setAdapter(adapter_walkthrough);

        indicator.setViewPager(viewPager);

        adapter_walkthrough.registerDataSetObserver(indicator.getDataSetObserver());


        Intent intent = new Intent(this, PaginaInicioActivity.class);

    }

    public void verPaginaInicio(View view) {
        startActivity(new Intent(this, PaginaInicioActivity.class)); }
}