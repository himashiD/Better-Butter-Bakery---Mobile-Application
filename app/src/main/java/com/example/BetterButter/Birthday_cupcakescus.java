package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Birthday_cupcakescus extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalistc;
    TextView datalist_countc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_cupcakescus);

        databaseHelperClass = new DatabaseHelperClass(Birthday_cupcakescus.this);
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
                startActivity(new Intent(Birthday_cupcakescus.this, Order_cakes.class));
            }
        });



    }

    private void refreshData() {
        datalist_countc.setText("All Account Count : "+databaseHelperClass.getTotalb());
        List<Birthdaycakesclass> birthdaycakesclassList = databaseHelperClass.getAllbirthday();
        datalistc.setText("");
        for (Birthdaycakesclass birthdaycakesclass : birthdaycakesclassList){
            datalistc.append(" No : "+birthdaycakesclass.getBid()+ "\n" +
                    " Cake Name : "+birthdaycakesclass.getBcakename()+ "\n" +
                    " Cake ID : "+birthdaycakesclass.getBcakeid()+ "\n" +
                    " Cake Weight : "+birthdaycakesclass.getBcakeweight()+ "\n" +
                    " Cake colour : "+birthdaycakesclass.getBcakecolors()+ "\n" +
                    " Cake Details : "+birthdaycakesclass.getBcakenote()+ "\n" +
                    " Cake Price : "+birthdaycakesclass.getBcakeprice()+ "\n" +
                    " Cake Qty : "+birthdaycakesclass.getBcakeqty()+ " \n\n");
        }
    }
}
