package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.onboarding.Adapter.Adapter_pagina_inicio_walkthrough;
import com.example.onboarding.Adapter.Adapter_walkthrough;

import me.relex.circleindicator.CircleIndicator;

public class pagina_inicio extends AppCompatActivity {

    public ViewPager viewPager;
    Adapter_pagina_inicio_walkthrough adapter_pagina_inicio_walkthrough;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicio);


        viewPager = findViewById(R.id.viewPager);

        CircleIndicator indicator = findViewById(R.id.indicator);
        adapter_pagina_inicio_walkthrough = new Adapter_pagina_inicio_walkthrough(getSupportFragmentManager());

        viewPager.setAdapter(adapter_pagina_inicio_walkthrough);

        indicator.setViewPager(viewPager);

        adapter_pagina_inicio_walkthrough.registerDataSetObserver(indicator.getDataSetObserver());

    }
}