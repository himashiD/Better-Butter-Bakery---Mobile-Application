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

public class Anniversary_cupcakes extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalist;
    TextView datalist_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anniversary_cupcakes);

        databaseHelperClass = new DatabaseHelperClass(Anniversary_cupcakes.this);
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
        datalist_count.setText("All Data Count : "+databaseHelperClass.getTotala());
        List<Anniversarycakesclass> anniversarycakesclassList = databaseHelperClass.getAllanniversary();
        datalist.setText("");
        for (Anniversarycakesclass anniversarycakesclass : anniversarycakesclassList){
            datalist.append(" No : "+anniversarycakesclass.getAid()+ "\n" +
                    " Cake Name : "+anniversarycakesclass.getAcakename()+ "\n" +
                    " Cake ID : "+anniversarycakesclass.getAcakeid()+ "\n" +
                    " Cake Weight : "+anniversarycakesclass.getAcakeweight()+ "\n" +
                    " Cake colour : "+anniversarycakesclass.getAcakecolors()+ "\n" +
                    " Cake Details : "+anniversarycakesclass.getAcakenote()+ "\n" +
                    " Cake Price : "+anniversarycakesclass.getAcakeprice()+ "\n" +
                    " Cake Qty : "+anniversarycakesclass.getAcakeqty()+ " \n\n");
        }
    }

    private void showDeleteDialog() {
        AlertDialog.Builder al=new AlertDialog.Builder(Anniversary_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.anniversary_delete,null);
        al.setView(view);
        final EditText aid_input = view.findViewById(R.id.aid_input);
        Button delete_btn = view.findViewById(R.id.adelete_btn);

        final AlertDialog alertDialog=al.show();
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteanniversary(aid_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    public void showUpdateIdDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Anniversary_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.anniversary_update_id,null);
        al.setView(view);
        final EditText aid_input = view.findViewById(R.id.aid_input);
        Button fetch_btn = view.findViewById(R.id.aupdate_id_btn);
        final AlertDialog alertDialog=al.show();
        fetch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataDialog(aid_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    private void showDataDialog(final String aid) {
        Anniversarycakesclass anniversarycakesclass = databaseHelperClass.getanniversary(Integer.parseInt(aid));
        AlertDialog.Builder al = new AlertDialog.Builder(Anniversary_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.anniversary_update,null);
        final EditText acakename = view.findViewById(R.id.acakename);
        final EditText acakeid = view.findViewById(R.id.acakeid);
        final EditText acakeweight = view.findViewById(R.id.acakeweight);
        final EditText acakecolors = view.findViewById(R.id.acakecolors);
        final EditText acakenote = view.findViewById(R.id.acakenote);
        final EditText acakeprice = view.findViewById(R.id.acakeprice);
        final EditText acakeqty = view.findViewById(R.id.acakeqty);
        Button update_Btn =view.findViewById(R.id.aupdate_btn);
        al.setView(view);

        acakename.setText(anniversarycakesclass.getAcakename());
        acakeid.setText(anniversarycakesclass.getAcakeid());
        acakeweight.setText(anniversarycakesclass.getAcakeweight());
        acakecolors.setText(anniversarycakesclass.getAcakecolors());
        acakenote.setText(anniversarycakesclass.getAcakenote());
        acakeprice.setText(anniversarycakesclass.getAcakeprice());
        acakeqty.setText(anniversarycakesclass.getAcakeqty());

        final AlertDialog alertDialog=al.show();

        update_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Anniversarycakesclass anniversarycakesclass = new Anniversarycakesclass();
                anniversarycakesclass.setAcakename(acakename.getText().toString());
                anniversarycakesclass.setAid(aid);
                anniversarycakesclass.setAcakeid(acakeid.getText().toString());
                anniversarycakesclass.setAcakeweight(acakeweight.getText().toString());
                anniversarycakesclass.setAcakecolors(acakecolors.getText().toString());
                anniversarycakesclass.setAcakenote(acakenote.getText().toString());
                anniversarycakesclass.setAcakeprice(acakeprice.getText().toString());
                anniversarycakesclass.setAcakeqty(acakeqty.getText().toString());
                databaseHelperClass.updateanniversary(anniversarycakesclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }




    private void showInputDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Anniversary_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.anniversary_insert,null);
        final EditText acakename = view.findViewById(R.id.acakename);
        final EditText acakeid = view.findViewById(R.id.acakeid);
        final EditText acakeweight = view.findViewById(R.id.acakeweight);
        final EditText acakecolors = view.findViewById(R.id.acakecolors);
        final EditText acakenote = view.findViewById(R.id.acakenote);
        final EditText acakeprice = view.findViewById(R.id.acakeprice);
        final EditText acakeqty = view.findViewById(R.id.acakeqty);
        Button insertBtn =view.findViewById(R.id.ainsert_btn);
        al.setView(view);

        final AlertDialog alertDialog=al.show();
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Anniversarycakesclass anniversarycakesclass = new Anniversarycakesclass();
                anniversarycakesclass.setAcakename(acakename.getText().toString());
                anniversarycakesclass.setAcakeid(acakeid.getText().toString());
                anniversarycakesclass.setAcakeweight(acakeweight.getText().toString());
                anniversarycakesclass.setAcakecolors(acakecolors.getText().toString());
                anniversarycakesclass.setAcakenote(acakenote.getText().toString());
                anniversarycakesclass.setAcakeprice(acakeprice.getText().toString());
                anniversarycakesclass.setAcakeqty(acakeqty.getText().toString());
                Date date = new Date();
                anniversarycakesclass.setAcreated_at(""+date.getTime());
                databaseHelperClass.addanniversary(anniversarycakesclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }
}