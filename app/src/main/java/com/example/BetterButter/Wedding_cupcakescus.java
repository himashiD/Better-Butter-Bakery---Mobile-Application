package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Wedding_cupcakescus extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalistc;
    TextView datalist_countc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding_cupcakescus);

        databaseHelperClass = new DatabaseHelperClass(Wedding_cupcakescus.this);
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
                startActivity(new Intent(Wedding_cupcakescus.this, Order_cakes.class));
            }
        });



    }

    private void refreshData() {
        datalist_countc.setText("All Data Count : "+databaseHelperClass.getTotalw());
        List<Weddingcakesclass> weddingcakesclassList = databaseHelperClass.getAllwedding();
        datalistc.setText("");
        for (Weddingcakesclass weddingcakesclass : weddingcakesclassList){
            datalistc.append(" No : "+weddingcakesclass.getWid()+ "\n" +
                    " Cake Name : "+weddingcakesclass.getWcakename()+ "\n" +
                    " Cake ID : "+weddingcakesclass.getWcakeid()+ "\n" +
                    " Cake Weight : "+weddingcakesclass.getWcakeweight()+ "\n" +
                    " Cake colour : "+weddingcakesclass.getWcakecolors()+ "\n" +
                    " Cake Details : "+weddingcakesclass.getWcakenote()+ "\n" +
                    " Cake Price : "+weddingcakesclass.getWcakeprice()+ "\n" +
                    " Cake Qty : "+weddingcakesclass.getWcakeqty()+ " \n\n");
        }
    }
}
