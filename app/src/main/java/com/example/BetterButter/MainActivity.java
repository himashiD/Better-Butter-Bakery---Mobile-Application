package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int SPLASH_SCREEN = 4500;

    Animation topAnimation, bottomAnimation;
    ImageView image;
    TextView welcometxt, welcometxt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animation
        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image = findViewById(R.id.welcome_imageview);
        welcometxt = findViewById(R.id.welcome_text);
        welcometxt2 = findViewById(R.id.welcome_text2);

        image.setAnimation(topAnimation);
        welcometxt.setAnimation(bottomAnimation);
        welcometxt2.setAnimation(bottomAnimation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Select_Account.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}