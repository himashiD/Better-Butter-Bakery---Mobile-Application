package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Classic_cupcakescus extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalistc;
    TextView datalist_countc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_cupcakescus);

        databaseHelperClass = new DatabaseHelperClass(Classic_cupcakescus.this);
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
                startActivity(new Intent(Classic_cupcakescus.this, Order_cakes.class));
            }
        });



    }

    private void refreshData() {
        datalist_countc.setText("All Account Count : "+databaseHelperClass.getTotal());
        List<Classiccupcakesclass> classiccupcakesclassList = databaseHelperClass.getAllclassic();
        datalistc.setText("");
        for (Classiccupcakesclass classiccupcakesclass : classiccupcakesclassList){
            datalistc.append(" No : "+classiccupcakesclass.getId()+ "\n" +
                    " Cake Name : "+classiccupcakesclass.getCakename()+ "\n" +
                    " Cake ID : "+classiccupcakesclass.getCakeid()+ "\n" +
                    " Cake Weight : "+classiccupcakesclass.getCakeweight()+ "\n" +
                    " Cake colour : "+classiccupcakesclass.getCakecolors()+ "\n" +
                    " Cake Details : "+classiccupcakesclass.getCakenote()+ "\n" +
                    " Cake Price : "+classiccupcakesclass.getCakeprice()+ "\n" +
                    " Cake Qty : "+classiccupcakesclass.getCakeqty()+ " \n\n");
        }
    }
}
