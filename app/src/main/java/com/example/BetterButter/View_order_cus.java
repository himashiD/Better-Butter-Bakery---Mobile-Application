package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class View_order_cus extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalistc;
    TextView datalist_countc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order_cus);

        databaseHelperClass = new DatabaseHelperClass(View_order_cus.this);
        Button read = findViewById(R.id.findrefresh_data);
        datalistc = findViewById(R.id.findcall_data_list);
        datalist_countc = findViewById(R.id.finddata_list_count);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshData();
            }
        });


    }

    private void refreshData() {
        datalist_countc.setText("All Data Count : "+databaseHelperClass.getTotalor());
        List<Orderproductclass> orderproductclassList = databaseHelperClass.getAllorder();
        datalistc.setText("");
        for (Orderproductclass orderproductclass : orderproductclassList){
            datalistc.append(" No : "+orderproductclass.getOrid()+ "\n" +
                    " Product Name : "+orderproductclass.getOrproductname()+ "\n" +
                    " Product ID : "+orderproductclass.getOrproductid()+ "\n" +
                    " Product Flavour : "+orderproductclass.getOrproductflavour()+ "\n" +
                    " Product Qty : "+orderproductclass.getOrproductqty()+ "\n" +
                    " Customer Name : "+orderproductclass.getOrcusname()+ "\n" +
                    " Customer Contact No : "+orderproductclass.getOrcuscontact()+ "\n" +
                    " Order Status : "+orderproductclass.getOrstatus()+ " \n\n");
        }
    }
}