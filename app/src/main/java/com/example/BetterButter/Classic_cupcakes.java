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

public class Classic_cupcakes extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalist;
    TextView datalist_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_cupcakes);

        databaseHelperClass = new DatabaseHelperClass(Classic_cupcakes.this);
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
        datalist_count.setText("All Data Count : "+databaseHelperClass.getTotal());
        List<Classiccupcakesclass> classiccupcakesclassList = databaseHelperClass.getAllclassic();
        datalist.setText("");
        for (Classiccupcakesclass classiccupcakesclass : classiccupcakesclassList){
            datalist.append(" No : "+classiccupcakesclass.getId()+ "\n" +
                    " Cake Name : "+classiccupcakesclass.getCakename()+ "\n" +
                    " Cake ID : "+classiccupcakesclass.getCakeid()+ "\n" +
                    " Cake Weight : "+classiccupcakesclass.getCakeweight()+ "\n" +
                    " Cake colour : "+classiccupcakesclass.getCakecolors()+ "\n" +
                    " Cake Details : "+classiccupcakesclass.getCakenote()+ "\n" +
                    " Cake Price : "+classiccupcakesclass.getCakeprice()+ "\n" +
                    " Cake Qty : "+classiccupcakesclass.getCakeqty()+ " \n\n");
        }
    }

    private void showDeleteDialog() {
        AlertDialog.Builder al=new AlertDialog.Builder(Classic_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.classic_delete,null);
        al.setView(view);
        final EditText id_input = view.findViewById(R.id.id_input);
        Button delete_btn = view.findViewById(R.id.delete_btn);

        final AlertDialog alertDialog=al.show();
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteclassic(id_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    public void showUpdateIdDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Classic_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.classic_update_id,null);
        al.setView(view);
        final EditText id_input = view.findViewById(R.id.id_input);
        Button fetch_btn = view.findViewById(R.id.update_id_btn);
        final AlertDialog alertDialog=al.show();
        fetch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataDialog(id_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    private void showDataDialog(final String id) {
        Classiccupcakesclass classiccupcakesclass = databaseHelperClass.getclassic(Integer.parseInt(id));
        AlertDialog.Builder al = new AlertDialog.Builder(Classic_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.classic_update,null);
        final EditText cakename = view.findViewById(R.id.cakename);
        final EditText cakeid = view.findViewById(R.id.cakeid);
        final EditText cakeweight = view.findViewById(R.id.cakeweight);
        final EditText cakecolors = view.findViewById(R.id.cakecolors);
        final EditText cakenote = view.findViewById(R.id.cakenote);
        final EditText cakeprice = view.findViewById(R.id.cakeprice);
        final EditText cakeqty = view.findViewById(R.id.cakeqty);
        Button update_Btn =view.findViewById(R.id.update_btn);
        al.setView(view);

        cakename.setText(classiccupcakesclass.getCakename());
        cakeid.setText(classiccupcakesclass.getCakeid());
        cakeweight.setText(classiccupcakesclass.getCakeweight());
        cakecolors.setText(classiccupcakesclass.getCakecolors());
        cakenote.setText(classiccupcakesclass.getCakenote());
        cakeprice.setText(classiccupcakesclass.getCakeprice());
        cakeqty.setText(classiccupcakesclass.getCakeqty());

        final AlertDialog alertDialog=al.show();

        update_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Classiccupcakesclass classiccupcakesclass = new Classiccupcakesclass();
                classiccupcakesclass.setCakename(cakename.getText().toString());
                classiccupcakesclass.setId(id);
                classiccupcakesclass.setCakeid(cakeid.getText().toString());
                classiccupcakesclass.setCakeweight(cakeweight.getText().toString());
                classiccupcakesclass.setCakecolors(cakecolors.getText().toString());
                classiccupcakesclass.setCakenote(cakenote.getText().toString());
                classiccupcakesclass.setCakeprice(cakeprice.getText().toString());
                classiccupcakesclass.setCakeqty(cakeqty.getText().toString());
                databaseHelperClass.updateclassic(classiccupcakesclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }



    private void showInputDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Classic_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.classic_insert,null);
        final EditText cakename = view.findViewById(R.id.cakename);
        final EditText cakeid = view.findViewById(R.id.cakeid);
        final EditText cakeweight = view.findViewById(R.id.cakeweight);
        final EditText cakecolors = view.findViewById(R.id.cakecolors);
        final EditText cakenote = view.findViewById(R.id.cakenote);
        final EditText cakeprice = view.findViewById(R.id.cakeprice);
        final EditText cakeqty = view.findViewById(R.id.cakeqty);
        Button insertBtn =view.findViewById(R.id.insert_btn);
        al.setView(view);

        final AlertDialog alertDialog=al.show();
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Classiccupcakesclass classiccupcakesclass = new Classiccupcakesclass();
                classiccupcakesclass.setCakename(cakename.getText().toString());
                classiccupcakesclass.setCakeid(cakeid.getText().toString());
                classiccupcakesclass.setCakeweight(cakeweight.getText().toString());
                classiccupcakesclass.setCakecolors(cakecolors.getText().toString());
                classiccupcakesclass.setCakenote(cakenote.getText().toString());
                classiccupcakesclass.setCakeprice(cakeprice.getText().toString());
                classiccupcakesclass.setCakeqty(cakeqty.getText().toString());
                Date date = new Date();
                classiccupcakesclass.setCreated_at(""+date.getTime());
                databaseHelperClass.addclassic(classiccupcakesclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }
}