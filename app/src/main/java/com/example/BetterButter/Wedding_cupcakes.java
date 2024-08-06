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

public class Wedding_cupcakes extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalist;
    TextView datalist_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding_cupcakes);

        databaseHelperClass = new DatabaseHelperClass(Wedding_cupcakes.this);
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
        datalist_count.setText("All Data Count : "+databaseHelperClass.getTotalw());
        List<Weddingcakesclass> weddingcakesclassList = databaseHelperClass.getAllwedding();
        datalist.setText("");
        for (Weddingcakesclass weddingcakesclass : weddingcakesclassList){
            datalist.append(" No : "+weddingcakesclass.getWid()+ "\n" +
                    " Cake Name : "+weddingcakesclass.getWcakename()+ "\n" +
                    " Cake ID : "+weddingcakesclass.getWcakeid()+ "\n" +
                    " Cake Weight : "+weddingcakesclass.getWcakeweight()+ "\n" +
                    " Cake colour : "+weddingcakesclass.getWcakecolors()+ "\n" +
                    " Cake Details : "+weddingcakesclass.getWcakenote()+ "\n" +
                    " Cake Price : "+weddingcakesclass.getWcakeprice()+ "\n" +
                    " Cake Qty : "+weddingcakesclass.getWcakeqty()+ " \n\n");
        }
    }

    private void showDeleteDialog() {
        AlertDialog.Builder al=new AlertDialog.Builder(Wedding_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.wedding_delete,null);
        al.setView(view);
        final EditText wid_input = view.findViewById(R.id.wid_input);
        Button delete_btn = view.findViewById(R.id.wdelete_btn);

        final AlertDialog alertDialog=al.show();
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deletewedding(wid_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    public void showUpdateIdDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Wedding_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.wedding_update_id,null);
        al.setView(view);
        final EditText wid_input = view.findViewById(R.id.wid_input);
        Button fetch_btn = view.findViewById(R.id.wupdate_id_btn);
        final AlertDialog alertDialog=al.show();
        fetch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataDialog(wid_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    private void showDataDialog(final String wid) {
        Weddingcakesclass weddingcakesclass = databaseHelperClass.getwedding(Integer.parseInt(wid));
        AlertDialog.Builder al = new AlertDialog.Builder(Wedding_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.wedding_update,null);
        final EditText wcakename = view.findViewById(R.id.wcakename);
        final EditText wcakeid = view.findViewById(R.id.wcakeid);
        final EditText wcakeweight = view.findViewById(R.id.wcakeweight);
        final EditText wcakecolors = view.findViewById(R.id.wcakecolors);
        final EditText wcakenote = view.findViewById(R.id.wcakenote);
        final EditText wcakeprice = view.findViewById(R.id.wcakeprice);
        final EditText wcakeqty = view.findViewById(R.id.wcakeqty);
        Button update_Btn =view.findViewById(R.id.wupdate_btn);
        al.setView(view);

        wcakename.setText(weddingcakesclass.getWcakename());
        wcakeid.setText(weddingcakesclass.getWcakeid());
        wcakeweight.setText(weddingcakesclass.getWcakeweight());
        wcakecolors.setText(weddingcakesclass.getWcakecolors());
        wcakenote.setText(weddingcakesclass.getWcakenote());
        wcakeprice.setText(weddingcakesclass.getWcakeprice());
        wcakeqty.setText(weddingcakesclass.getWcakeqty());

        final AlertDialog alertDialog=al.show();

        update_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Weddingcakesclass weddingcakesclass = new Weddingcakesclass();
                weddingcakesclass.setWcakename(wcakename.getText().toString());
                weddingcakesclass.setWid(wid);
                weddingcakesclass.setWcakeid(wcakeid.getText().toString());
                weddingcakesclass.setWcakeweight(wcakeweight.getText().toString());
                weddingcakesclass.setWcakecolors(wcakecolors.getText().toString());
                weddingcakesclass.setWcakenote(wcakenote.getText().toString());
                weddingcakesclass.setWcakeprice(wcakeprice.getText().toString());
                weddingcakesclass.setWcakeqty(wcakeqty.getText().toString());
                databaseHelperClass.updatewedding(weddingcakesclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }




    private void showInputDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Wedding_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.wedding_insert,null);
        final EditText wcakename = view.findViewById(R.id.wcakename);
        final EditText wcakeid = view.findViewById(R.id.wcakeid);
        final EditText wcakeweight = view.findViewById(R.id.wcakeweight);
        final EditText wcakecolors = view.findViewById(R.id.wcakecolors);
        final EditText wcakenote = view.findViewById(R.id.wcakenote);
        final EditText wcakeprice = view.findViewById(R.id.wcakeprice);
        final EditText wcakeqty = view.findViewById(R.id.wcakeqty);
        Button insertBtn =view.findViewById(R.id.winsert_btn);
        al.setView(view);

        final AlertDialog alertDialog=al.show();
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Weddingcakesclass weddingcakesclass = new Weddingcakesclass();
                weddingcakesclass.setWcakename(wcakename.getText().toString());
                weddingcakesclass.setWcakeid(wcakeid.getText().toString());
                weddingcakesclass.setWcakeweight(wcakeweight.getText().toString());
                weddingcakesclass.setWcakecolors(wcakecolors.getText().toString());
                weddingcakesclass.setWcakenote(wcakenote.getText().toString());
                weddingcakesclass.setWcakeprice(wcakeprice.getText().toString());
                weddingcakesclass.setWcakeqty(wcakeqty.getText().toString());
                Date date = new Date();
                weddingcakesclass.setWcakeqty(""+date.getTime());
                databaseHelperClass.addwedding(weddingcakesclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }

}