package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Newbaby_cupcakescus extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalistc;
    TextView datalist_countc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newbaby_cupcakescus);

        databaseHelperClass = new DatabaseHelperClass(Newbaby_cupcakescus.this);
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
                startActivity(new Intent(Newbaby_cupcakescus.this, Order_cakes.class));
            }
        });



    }

    private void refreshData() {
        datalist_countc.setText("All Data Count : "+databaseHelperClass.getTotaln());
        List<Newbabycakesclass> newbabycakesclassList = databaseHelperClass.getAllnewbaby();
        datalistc.setText("");
        for (Newbabycakesclass newbabycakesclass : newbabycakesclassList){
            datalistc.append(" No : "+newbabycakesclass.getNid()+ "\n" +
                    " Cake Name : "+newbabycakesclass.getNcakename()+ "\n" +
                    " Cake ID : "+newbabycakesclass.getNcakeid()+ "\n" +
                    " Cake Flavors : "+newbabycakesclass.getNcakeweight()+ "\n" +
                    " Cake Colour : "+newbabycakesclass.getNcakecolors()+ "\n" +
                    " Cake Details : "+newbabycakesclass.getNcakenote()+ "\n" +
                    " Cake Price : "+newbabycakesclass.getNcakeprice()+ "\n" +
                    " Cake Qty : "+newbabycakesclass.getNcakeqty()+ " \n\n");
        }
    }
}
