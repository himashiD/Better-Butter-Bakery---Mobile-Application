package com.example.BetterButter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class Order_cakes extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalist;
    TextView datalist_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_cakes);

        databaseHelperClass = new DatabaseHelperClass(Order_cakes.this);
        Button delete = findViewById(R.id.delete_data);
        Button insert = findViewById(R.id.insert_data);
        Button update = findViewById(R.id.update_data);
        Button read = findViewById(R.id.refresh_data);
        datalist = findViewById(R.id.all_data_list);
        datalist_count = findViewById(R.id.data_list_count);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshData();
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUpdateIdDialog();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteDialog();
            }
        });
    }

    private void refreshData() {
        datalist_count.setText("All Data Count : "+databaseHelperClass.getTotalor());
        List<Orderproductclass> orderproductclassList = databaseHelperClass.getAllorder();
        datalist.setText("");
        for (Orderproductclass orderproductclass : orderproductclassList){
            datalist.append(" No : "+orderproductclass.getOrid()+ "\n" +
                    " Product Name : "+orderproductclass.getOrproductname()+ "\n" +
                    " Product ID : "+orderproductclass.getOrproductid()+ "\n" +
                    " Product Flavour : "+orderproductclass.getOrproductflavour()+ "\n" +
                    " Product Qty : "+orderproductclass.getOrproductqty()+ "\n" +
                    " Customer Name : "+orderproductclass.getOrcusname()+ "\n" +
                    " Customer Contact No : "+orderproductclass.getOrcuscontact()+ "\n" +
                    " Order Status : "+orderproductclass.getOrstatus()+ " \n\n");
        }
    }

    private void showDeleteDialog() {
        AlertDialog.Builder al=new AlertDialog.Builder(Order_cakes.this);
        View view = getLayoutInflater().inflate(R.layout.orproduct_delete,null);
        al.setView(view);
        final EditText orid_input = view.findViewById(R.id.orid_input);
        Button delete_btn = view.findViewById(R.id.ordelete_btn);

        final AlertDialog alertDialog=al.show();
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteorder(orid_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    public void showUpdateIdDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Order_cakes.this);
        View view = getLayoutInflater().inflate(R.layout.orproduct_update_id,null);
        al.setView(view);
        final EditText orid_input = view.findViewById(R.id.orid_input);
        Button fetch_btn = view.findViewById(R.id.orupdate_id_btn);
        final AlertDialog alertDialog=al.show();
        fetch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataDialog(orid_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    private void showDataDialog(final String orid) {
        Orderproductclass orderproductclass = databaseHelperClass.getorder(Integer.parseInt(orid));
        AlertDialog.Builder al = new AlertDialog.Builder(Order_cakes.this);
        View view = getLayoutInflater().inflate(R.layout.orproduct_update,null);
        final EditText orproductname = view.findViewById(R.id.orproductname);
        final EditText orproductid = view.findViewById(R.id.orproductid);
        final EditText orproductflavour = view.findViewById(R.id.orproductflavour);
        final EditText orproductqty = view.findViewById(R.id.orproductqty);
        final EditText orcusname = view.findViewById(R.id.orcusname);
        final EditText orcuscontact = view.findViewById(R.id.orcuscontact);
        final EditText orstatus = view.findViewById(R.id.orstatus);
        Button update_Btn =view.findViewById(R.id.orupdate_btn);
        al.setView(view);

        orproductname.setText(orderproductclass.getOrproductname());
        orproductid.setText(orderproductclass.getOrproductid());
        orproductflavour.setText(orderproductclass.getOrproductflavour());
        orproductqty.setText(orderproductclass.getOrproductqty());
        orcusname.setText(orderproductclass.getOrcusname());
        orcuscontact.setText(orderproductclass.getOrcuscontact());
        orstatus.setText(orderproductclass.getOrstatus());

        final AlertDialog alertDialog=al.show();

        update_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Orderproductclass orderproductclass = new Orderproductclass();
                orderproductclass.setOrproductname(orproductname.getText().toString());
                orderproductclass.setOrid(orid);
                orderproductclass.setOrproductid(orproductid.getText().toString());
                orderproductclass.setOrproductflavour(orproductflavour.getText().toString());
                orderproductclass.setOrproductqty(orproductqty.getText().toString());
                orderproductclass.setOrcusname(orcusname.getText().toString());
                orderproductclass.setOrcuscontact(orcuscontact.getText().toString());
                orderproductclass.setOrstatus(orstatus.getText().toString());
                databaseHelperClass.updateorder(orderproductclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }




    private void showInputDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Order_cakes.this);
        View view = getLayoutInflater().inflate(R.layout.orproduct_insert,null);
        final EditText orproductname = view.findViewById(R.id.orproductname);
        final EditText orproductid = view.findViewById(R.id.orproductid);
        final EditText orproductflavour = view.findViewById(R.id.orproductflavour);
        final EditText orproductqty = view.findViewById(R.id.orproductqty);
        final EditText orcusname = view.findViewById(R.id.orcusname);
        final EditText orcuscontact = view.findViewById(R.id.orcuscontact);
        final EditText orstatus = view.findViewById(R.id.orstatus);
        Button insertBtn =view.findViewById(R.id.orinsert_btn);
        al.setView(view);

        final AlertDialog alertDialog=al.show();
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Orderproductclass orderproductclass = new Orderproductclass();
                orderproductclass.setOrproductname(orproductname.getText().toString());
                orderproductclass.setOrproductid(orproductid.getText().toString());
                orderproductclass.setOrproductflavour(orproductflavour.getText().toString());
                orderproductclass.setOrproductqty(orproductqty.getText().toString());
                orderproductclass.setOrcusname(orcusname.getText().toString());
                orderproductclass.setOrcuscontact(orcuscontact.getText().toString());
                orderproductclass.setOrstatus(orstatus.getText().toString());
                Date date = new Date();
                orderproductclass.setOrcreated_at(""+date.getTime());
                databaseHelperClass.addorder(orderproductclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }
}