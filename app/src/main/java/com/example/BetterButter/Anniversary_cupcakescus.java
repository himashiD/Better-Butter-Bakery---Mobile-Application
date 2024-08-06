package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Anniversary_cupcakescus extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalistc;
    TextView datalist_countc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anniversary_cupcakescus);

        databaseHelperClass = new DatabaseHelperClass(Anniversary_cupcakescus.this);
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
                startActivity(new Intent(Anniversary_cupcakescus.this, Order_cakes.class));
            }
        });



    }

    private void refreshData() {
        datalist_countc.setText("All Data Count : "+databaseHelperClass.getTotala());
        List<Anniversarycakesclass> anniversarycakesclassList = databaseHelperClass.getAllanniversary();
        datalistc.setText("");
        for (Anniversarycakesclass anniversarycakesclass : anniversarycakesclassList){
            datalistc.append(" No : "+anniversarycakesclass.getAid()+ "\n" +
                    " Cake Name : "+anniversarycakesclass.getAcakename()+ "\n" +
                    " Cake ID : "+anniversarycakesclass.getAcakeid()+ "\n" +
                    " Cake Weight : "+anniversarycakesclass.getAcakeweight()+ "\n" +
                    " Cake colour : "+anniversarycakesclass.getAcakecolors()+ "\n" +
                    " Cake Details : "+anniversarycakesclass.getAcakenote()+ "\n" +
                    " Cake Price : "+anniversarycakesclass.getAcakeprice()+ "\n" +
                    " Cake Qty : "+anniversarycakesclass.getAcakeqty()+ " \n\n");
        }
    }
}
