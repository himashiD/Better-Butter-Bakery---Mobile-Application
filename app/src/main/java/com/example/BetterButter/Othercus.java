package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Othercus extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalistc;
    TextView datalist_countc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_othercus);

        databaseHelperClass = new DatabaseHelperClass(Othercus.this);
        Button read = findViewById(R.id.findrefresh_data);
        datalistc = findViewById(R.id.findcall_data_list);
        datalist_countc = findViewById(R.id.finddata_list_count);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshData();
            }
        });


        Button order = findViewById(R.id.order_btn);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Othercus.this, Order_cakes.class));
            }
        });



    }

    private void refreshData() {
        datalist_countc.setText("All Data Count : "+databaseHelperClass.getTotalo());
        List<Othercupcakesclass> othercupcakesclassList = databaseHelperClass.getAllother();
        datalistc.setText("");
        for (Othercupcakesclass othercupcakesclass : othercupcakesclassList){
            datalistc.append(" No : "+othercupcakesclass.getOid()+ "\n" +
                    " Cake Name : "+othercupcakesclass.getOcakename()+ "\n" +
                    " Cake ID : "+othercupcakesclass.getOcakeid()+ "\n" +
                    " Cake Weight : "+othercupcakesclass.getOcakeweight()+ "\n" +
                    " Cake colour : "+othercupcakesclass.getOcakecolors()+ "\n" +
                    " Cake Details : "+othercupcakesclass.getOcakenote()+ "\n" +
                    " Cake Price : "+othercupcakesclass.getOcakeprice()+ "\n" +
                    " Cake Qty : "+othercupcakesclass.getOcakeqty()+ " \n\n");
        }
    }
}
