package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() ->{
            mostrarMain();
        } ,1000);
    }

    private void mostrarMain() {
        startActivity(new Intent(this,SplashActivity2.class));
        finish();
    }
}