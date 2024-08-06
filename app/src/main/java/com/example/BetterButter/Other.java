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

public class Other extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalist;
    TextView datalist_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_cupcakes);

        databaseHelperClass = new DatabaseHelperClass(Other.this);
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
        datalist_count.setText("All Data Count : "+databaseHelperClass.getTotalo());
        List<Othercupcakesclass> othercupcakesclassList = databaseHelperClass.getAllother();
        datalist.setText("");
        for (Othercupcakesclass othercupcakesclass : othercupcakesclassList){
            datalist.append(" No : "+othercupcakesclass.getOid()+ "\n" +
                    " Cake Name : "+othercupcakesclass.getOcakename()+ "\n" +
                    " Cake ID : "+othercupcakesclass.getOcakeid()+ "\n" +
                    " Cake Weight : "+othercupcakesclass.getOcakeweight()+ "\n" +
                    " Cake colour : "+othercupcakesclass.getOcakecolors()+ "\n" +
                    " Cake Details : "+othercupcakesclass.getOcakenote()+ "\n" +
                    " Cake Price : "+othercupcakesclass.getOcakeprice()+ "\n" +
                    " Cake Qty : "+othercupcakesclass.getOcakeqty()+ " \n\n");
        }
    }

    private void showDeleteDialog() {
        AlertDialog.Builder al=new AlertDialog.Builder(Other.this);
        View view = getLayoutInflater().inflate(R.layout.other_delete,null);
        al.setView(view);
        final EditText oid_input = view.findViewById(R.id.oid_input);
        Button delete_btn = view.findViewById(R.id.odelete_btn);

        final AlertDialog alertDialog=al.show();
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteother(oid_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    public void showUpdateIdDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Other.this);
        View view = getLayoutInflater().inflate(R.layout.other_update_id,null);
        al.setView(view);
        final EditText oid_input = view.findViewById(R.id.oid_input);
        Button fetch_btn = view.findViewById(R.id.oupdate_id_btn);
        final AlertDialog alertDialog=al.show();
        fetch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataDialog(oid_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    private void showDataDialog(final String oid) {
        Othercupcakesclass othercupcakesclass = databaseHelperClass.getother(Integer.parseInt(oid));
        AlertDialog.Builder al = new AlertDialog.Builder(Other.this);
        View view = getLayoutInflater().inflate(R.layout.other_update,null);
        final EditText ocakename = view.findViewById(R.id.ocakename);
        final EditText ocakeid = view.findViewById(R.id.ocakeid);
        final EditText ocakeweight = view.findViewById(R.id.ocakeweight);
        final EditText ocakecolors = view.findViewById(R.id.ocakecolors);
        final EditText ocakenote = view.findViewById(R.id.ocakenote);
        final EditText ocakeprice = view.findViewById(R.id.ocakeprice);
        final EditText ocakeqty = view.findViewById(R.id.ocakeqty);
        Button update_Btn =view.findViewById(R.id.oupdate_btn);
        al.setView(view);

        ocakename.setText(othercupcakesclass.getOcakename());
        ocakeid.setText(othercupcakesclass.getOcakeid());
        ocakeweight.setText(othercupcakesclass.getOcakeweight());
        ocakecolors.setText(othercupcakesclass.getOcakecolors());
        ocakenote.setText(othercupcakesclass.getOcakenote());
        ocakeprice.setText(othercupcakesclass.getOcakeprice());
        ocakeqty.setText(othercupcakesclass.getOcakeqty());

        final AlertDialog alertDialog=al.show();

        update_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Othercupcakesclass othercupcakesclass = new Othercupcakesclass();
                othercupcakesclass.setOcakename(ocakename.getText().toString());
                othercupcakesclass.setOid(oid);
                othercupcakesclass.setOcakeid(ocakeid.getText().toString());
                othercupcakesclass.setOcakeweight(ocakeweight.getText().toString());
                othercupcakesclass.setOcakecolors(ocakecolors.getText().toString());
                othercupcakesclass.setOcakenote(ocakenote.getText().toString());
                othercupcakesclass.setOcakeprice(ocakeprice.getText().toString());
                othercupcakesclass.setOcakeqty(ocakeqty.getText().toString());
                databaseHelperClass.updateother(othercupcakesclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }




    private void showInputDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Other.this);
        View view = getLayoutInflater().inflate(R.layout.other_insert,null);
        final EditText ocakename = view.findViewById(R.id.ocakename);
        final EditText ocakeid = view.findViewById(R.id.ocakeid);
        final EditText ocakeweight = view.findViewById(R.id.ocakeweight);
        final EditText ocakecolors = view.findViewById(R.id.ocakecolors);
        final EditText ocakenote = view.findViewById(R.id.ocakenote);
        final EditText ocakeprice = view.findViewById(R.id.ocakeprice);
        final EditText ocakeqty = view.findViewById(R.id.ocakeqty);
        Button insertBtn =view.findViewById(R.id.oinsert_btn);
        al.setView(view);

        final AlertDialog alertDialog=al.show();
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Othercupcakesclass othercupcakesclass = new Othercupcakesclass();
                othercupcakesclass.setOcakename(ocakename.getText().toString());
                othercupcakesclass.setOcakeid(ocakeid.getText().toString());
                othercupcakesclass.setOcakeweight(ocakeweight.getText().toString());
                othercupcakesclass.setOcakecolors(ocakecolors.getText().toString());
                othercupcakesclass.setOcakenote(ocakenote.getText().toString());
                othercupcakesclass.setOcakeprice(ocakeprice.getText().toString());
                othercupcakesclass.setOcakeqty(ocakeqty.getText().toString());
                Date date = new Date();
                othercupcakesclass.setOcreated_at(""+date.getTime());
                databaseHelperClass.addother(othercupcakesclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }

}