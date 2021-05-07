package com.example.onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CelularesActivity extends AppCompatActivity {

    ImageButton mImgBtnXiaomi,mImgBtnApple,mImgBtnNotion ,mImgBtnToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celulares);
        mImgBtnXiaomi = findViewById(R.id.imgbtnXiaomi);
        mImgBtnApple = findViewById(R.id.imgbtnApple);
        mImgBtnNotion = findViewById(R.id.imgbtnNotion);
        mImgBtnToDo = findViewById(R.id.imgbtnToDo);

        Intent intent1 = new Intent(this,XiaomiActivity.class);
        Intent intent2 = new Intent(this,AppleActivity.class);
        Intent intent3 = new Intent(this,NotionActivity.class);
        Intent intent4 = new Intent(this,ToDoActivity.class);
    }

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
}