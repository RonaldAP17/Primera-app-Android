package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.onboarding.fragment_celular_apple.CelularApple12ProFragment;
import com.example.onboarding.fragment_celular_apple.CelularApple8PlusFragment;
import com.example.onboarding.fragment_celular_apple.CelularAppleXFragment;
import com.example.onboarding.fragment_celular_xiaomi.CelularXiaomiMi11Fragment;

public class AppleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);

        RadioButton abtnCIBoton1 = findViewById(R.id.btnCIBoton1);
        RadioButton abtnCIBoton2 = findViewById(R.id.btnCIBoton2);
        RadioButton abtnCIBoton3 = findViewById(R.id.btnCIBoton3);

        abtnCIBoton1.setOnClickListener(this);
        abtnCIBoton2.setOnClickListener(this);
        abtnCIBoton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCIBoton1:
                mostrarBoton1();
                break;
            case R.id.btnCIBoton2:
                mostrarBoton2();
                break;
            case R.id.btnCIBoton3:
                mostrarBoton3();
                break;
        }
    }

    private void mostrarBoton1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenedorCelularApple, new CelularApple8PlusFragment())
                .commit();
    }

    private void mostrarBoton2() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenedorCelularApple, new CelularAppleXFragment())
                .commit();
    }

    private void mostrarBoton3() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.llContenedorCelularApple, new CelularApple12ProFragment())
                .commit();
    }
}