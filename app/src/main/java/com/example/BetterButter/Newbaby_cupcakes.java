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

public class Newbaby_cupcakes extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalist;
    TextView datalist_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newbaby_cupcakes);

        databaseHelperClass = new DatabaseHelperClass(Newbaby_cupcakes.this);
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
        datalist_count.setText("All Data Count : "+databaseHelperClass.getTotaln());
        List<Newbabycakesclass> newbabycakesclassList = databaseHelperClass.getAllnewbaby();
        datalist.setText("");
        for (Newbabycakesclass newbabycakesclass : newbabycakesclassList){
            datalist.append(" No : "+newbabycakesclass.getNid()+ "\n" +
                    " Cake Name : "+newbabycakesclass.getNcakename()+ "\n" +
                    " Cake ID : "+newbabycakesclass.getNcakeid()+ "\n" +
                    " Cake Flavors : "+newbabycakesclass.getNcakeweight()+ "\n" +
                    " Cake Colour : "+newbabycakesclass.getNcakecolors()+ "\n" +
                    " Cake Details : "+newbabycakesclass.getNcakenote()+ "\n" +
                    " Cake Price : "+newbabycakesclass.getNcakeprice()+ "\n" +
                    " Cake Qty : "+newbabycakesclass.getNcakeqty()+ " \n\n");
        }
    }

    private void showDeleteDialog() {
        AlertDialog.Builder al=new AlertDialog.Builder(Newbaby_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.newbaby_delete,null);
        al.setView(view);
        final EditText nid_input = view.findViewById(R.id.nid_input);
        Button delete_btn = view.findViewById(R.id.ndelete_btn);

        final AlertDialog alertDialog=al.show();
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deletenewbaby(nid_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    public void showUpdateIdDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Newbaby_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.newbaby_update_id,null);
        al.setView(view);
        final EditText nid_input = view.findViewById(R.id.nid_input);
        Button fetch_btn = view.findViewById(R.id.nupdate_id_btn);
        final AlertDialog alertDialog=al.show();
        fetch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataDialog(nid_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    private void showDataDialog(final String nid) {
        Newbabycakesclass newbabycakesclass = databaseHelperClass.getnewbaby(Integer.parseInt(nid));
        AlertDialog.Builder al = new AlertDialog.Builder(Newbaby_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.newbaby_update,null);
        final EditText ncakename = view.findViewById(R.id.ncakename);
        final EditText ncakeid = view.findViewById(R.id.ncakeid);
        final EditText ncakeweight = view.findViewById(R.id.ncakeweight);
        final EditText ncakecolors = view.findViewById(R.id.ncakecolors);
        final EditText ncakenote = view.findViewById(R.id.ncakenote);
        final EditText ncakeprice = view.findViewById(R.id.ncakeprice);
        final EditText ncakeqty = view.findViewById(R.id.ncakeqty);
        Button update_Btn =view.findViewById(R.id.nupdate_btn);
        al.setView(view);

        ncakename.setText(newbabycakesclass.getNcakename());
        ncakeid.setText(newbabycakesclass.getNcakeid());
        ncakeweight.setText(newbabycakesclass.getNcakeweight());
        ncakecolors.setText(newbabycakesclass.getNcakecolors());
        ncakenote.setText(newbabycakesclass.getNcakenote());
        ncakeprice.setText(newbabycakesclass.getNcakeprice());
        ncakeqty.setText(newbabycakesclass.getNcakeqty());

        final AlertDialog alertDialog=al.show();

        update_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Newbabycakesclass newbabycakesclass = new Newbabycakesclass();
                newbabycakesclass.setNcakename(ncakename.getText().toString());
                newbabycakesclass.setNid(nid);
                newbabycakesclass.setNcakeid(ncakeid.getText().toString());
                newbabycakesclass.setNcakeweight(ncakeweight.getText().toString());
                newbabycakesclass.setNcakecolors(ncakecolors.getText().toString());
                newbabycakesclass.setNcakenote(ncakenote.getText().toString());
                newbabycakesclass.setNcakeprice(ncakeprice.getText().toString());
                newbabycakesclass.setNcakeqty(ncakeqty.getText().toString());
                databaseHelperClass.updatenewbaby(newbabycakesclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }




    private void showInputDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Newbaby_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.newbaby_insert,null);
        final EditText ncakename = view.findViewById(R.id.ncakename);
        final EditText ncakeid = view.findViewById(R.id.ncakeid);
        final EditText ncakeweight = view.findViewById(R.id.ncakeweight);
        final EditText ncakecolors = view.findViewById(R.id.ncakecolors);
        final EditText ncakenote = view.findViewById(R.id.ncakenote);
        final EditText ncakeprice = view.findViewById(R.id.ncakeprice);
        final EditText ncakeqty = view.findViewById(R.id.ncakeqty);
        Button insertBtn =view.findViewById(R.id.ninsert_btn);
        al.setView(view);

        final AlertDialog alertDialog=al.show();
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Newbabycakesclass newbabycakesclass = new Newbabycakesclass();
                newbabycakesclass.setNcakename(ncakename.getText().toString());;
                newbabycakesclass.setNcakeid(ncakeid.getText().toString());
                newbabycakesclass.setNcakeweight(ncakeweight.getText().toString());
                newbabycakesclass.setNcakecolors(ncakecolors.getText().toString());
                newbabycakesclass.setNcakenote(ncakenote.getText().toString());
                newbabycakesclass.setNcakeprice(ncakeprice.getText().toString());
                newbabycakesclass.setNcakeqty(ncakeqty.getText().toString());
                Date date = new Date();
                newbabycakesclass.setNcreated_at(""+date.getTime());
                databaseHelperClass.addnewbaby(newbabycakesclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }
}