package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Manage_cakes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_cakes);


        CardView Classic_cupcakes= findViewById(R.id.Classic_cupcakes);
        Classic_cupcakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Manage_cakes.this, Classic_cupcakes.class));
            }
        });

        CardView Birthday_cupcakes= findViewById(R.id.Birthday_cupcakes);
        Birthday_cupcakes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Manage_cakes.this,Birthday_cupcakes.class));
            }
        });

        CardView Wedding = findViewById(R.id.Wedding);
        Wedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Manage_cakes.this, Wedding_cupcakes.class));
            }
        });

        CardView Anniversary = findViewById(R.id.Anniversary);
        Anniversary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Manage_cakes.this, Anniversary_cupcakes.class));
            }
        });

        CardView Newbaby = findViewById(R.id.Newbaby);
        Newbaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Manage_cakes.this, Newbaby_cupcakes.class));
            }
        });

        CardView Other = findViewById(R.id.Other);
        Other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Manage_cakes.this, Other.class));
            }
        });

    }
}