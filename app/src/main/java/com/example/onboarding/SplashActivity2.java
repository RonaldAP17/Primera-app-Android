package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() ->{
            mostrarMain();
        } ,2000);
    }

    private void mostrarLogo() {

    }

    private void mostrarMain() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}