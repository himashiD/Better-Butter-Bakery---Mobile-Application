package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Find_cakes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_cakes);


        CardView Classic_cupcakes= findViewById(R.id.Classic_cupcakescus);
        Classic_cupcakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Find_cakes.this, Classic_cupcakescus.class));
            }
        });

        CardView Birthday_cupcakes= findViewById(R.id.Birthday_cupcakescus);
        Birthday_cupcakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Find_cakes.this,Birthday_cupcakescus.class));
            }
        });

        CardView Wedding = findViewById(R.id.Weddingcus);
        Wedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Find_cakes.this, Wedding_cupcakescus.class));
            }
        });

        CardView Anniversary = findViewById(R.id.Anniversarycus);
        Anniversary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Find_cakes.this, Anniversary_cupcakescus.class));
            }
        });

        CardView Newbaby = findViewById(R.id.Newbabycus);
        Newbaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Find_cakes.this, Newbaby_cupcakescus.class));
            }
        });

        CardView Other = findViewById(R.id.Othercus);
        Other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Find_cakes.this, Othercus.class));
            }
        });

    }
}