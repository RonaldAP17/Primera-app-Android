package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CelularesActivity extends AppCompatActivity {

    ImageButton mImgBtnXiaomi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celulares);
        mImgBtnXiaomi = findViewById(R.id.imgbtnXiaomi);

        Intent intent = new Intent(this,XiaomiActivity.class);
    }

    public void verPaginaXiaomi(View view) {
            startActivity(new Intent(this, XiaomiActivity.class));
        }
    }