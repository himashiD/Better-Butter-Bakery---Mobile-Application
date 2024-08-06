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

public class Birthday_cupcakes extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalist;
    TextView datalist_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_cupcakes);

        databaseHelperClass = new DatabaseHelperClass(Birthday_cupcakes.this);
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
        datalist_count.setText("All Data Count : "+databaseHelperClass.getTotalb());
        List<Birthdaycakesclass> birthdaycakesclassList = databaseHelperClass.getAllbirthday();
        datalist.setText("");
        for (Birthdaycakesclass birthdaycakesclass : birthdaycakesclassList){
            datalist.append(" No : "+birthdaycakesclass.getBid()+ "\n" +
                    " Cake Name : "+birthdaycakesclass.getBcakename()+ "\n" +
                    " Cake ID : "+birthdaycakesclass.getBcakeid()+ "\n" +
                    " Cake Weight : "+birthdaycakesclass.getBcakeweight()+ "\n" +
                    " Cake colour : "+birthdaycakesclass.getBcakecolors()+ "\n" +
                    " Cake Details : "+birthdaycakesclass.getBcakenote()+ "\n" +
                    " Cake Price : "+birthdaycakesclass.getBcakeprice()+ "\n" +
                    " Cake Qty : "+birthdaycakesclass.getBcakeqty()+ " \n\n");
        }
    }

    private void showDeleteDialog() {
        AlertDialog.Builder al=new AlertDialog.Builder(Birthday_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.birthday_delete,null);
        al.setView(view);
        final EditText bid_input = view.findViewById(R.id.bid_input);
        Button delete_btn = view.findViewById(R.id.bdelete_btn);

        final AlertDialog alertDialog=al.show();
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deletebirthday(bid_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    public void showUpdateIdDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Birthday_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.birthday_update_id,null);
        al.setView(view);
        final EditText Bid_input = view.findViewById(R.id.bid_input);
        Button Bfetch_btn = view.findViewById(R.id.bupdate_id_btn);
        final AlertDialog alertDialog=al.show();
        Bfetch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataDialog(Bid_input.getText().toString());
                alertDialog.dismiss();
                refreshData();
            }
        });

    }


    private void showDataDialog(final String bid) {
        Birthdaycakesclass birthdaycakesclass = databaseHelperClass.getbirthday(Integer.parseInt(bid));
        AlertDialog.Builder al = new AlertDialog.Builder(Birthday_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.birthday_update,null);
        final EditText bcakename = view.findViewById(R.id.bcakename);
        final EditText bcakeid = view.findViewById(R.id.bcakeid);
        final EditText bcakeweight = view.findViewById(R.id.bcakeweight);
        final EditText bcakecolors = view.findViewById(R.id.bcakecolors);
        final EditText bcakenote = view.findViewById(R.id.bcakenote);
        final EditText bcakeprice = view.findViewById(R.id.bcakeprice);
        final EditText bcakeqty = view.findViewById(R.id.bcakeqty);
        Button update_Btn =view.findViewById(R.id.bupdate_btn);
        al.setView(view);

        bcakename.setText(birthdaycakesclass.getBcakename());
        bcakeid.setText(birthdaycakesclass.getBcakeid());
        bcakeweight.setText(birthdaycakesclass.getBcakeweight());
        bcakecolors.setText(birthdaycakesclass.getBcakecolors());
        bcakenote.setText(birthdaycakesclass.getBcakenote());
        bcakeprice.setText(birthdaycakesclass.getBcakeprice());
        bcakeqty.setText(birthdaycakesclass.getBcakeqty());

        final AlertDialog alertDialog=al.show();

        update_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Birthdaycakesclass birthdaycakesclass = new Birthdaycakesclass();
                birthdaycakesclass.setBcakename(bcakename.getText().toString());
                birthdaycakesclass.setBid(bid);
                birthdaycakesclass.setBcakeid(bcakeid.getText().toString());
                birthdaycakesclass.setBcakeweight(bcakeweight.getText().toString());
                birthdaycakesclass.setBcakecolors(bcakecolors.getText().toString());
                birthdaycakesclass.setBcakenote(bcakenote.getText().toString());
                birthdaycakesclass.setBcakeprice(bcakeprice.getText().toString());
                birthdaycakesclass.setBcakeqty(bcakeqty.getText().toString());
                databaseHelperClass.updatebirthday(birthdaycakesclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }




    private void showInputDialog() {
        AlertDialog.Builder al = new AlertDialog.Builder(Birthday_cupcakes.this);
        View view = getLayoutInflater().inflate(R.layout.birthday_insert,null);
        final EditText bcakename = view.findViewById(R.id.bcakename);
        final EditText bcakeid = view.findViewById(R.id.bcakeid);
        final EditText bcakeweight = view.findViewById(R.id.bcakeweight);
        final EditText bcakecolors = view.findViewById(R.id.bcakecolors);
        final EditText bcakenote = view.findViewById(R.id.bcakenote);
        final EditText bcakeprice = view.findViewById(R.id.bcakeprice);
        final EditText bcakeqty = view.findViewById(R.id.bcakeqty);
        Button insertBtn =view.findViewById(R.id.binsert_btn);
        al.setView(view);

        final AlertDialog alertDialog=al.show();
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Birthdaycakesclass birthdaycakesclass = new Birthdaycakesclass();
                birthdaycakesclass.setBcakename(bcakename.getText().toString());
                birthdaycakesclass.setBcakeid(bcakeid.getText().toString());
                birthdaycakesclass.setBcakeweight(bcakeweight.getText().toString());
                birthdaycakesclass.setBcakecolors(bcakecolors.getText().toString());
                birthdaycakesclass.setBcakenote(bcakenote.getText().toString());
                birthdaycakesclass.setBcakeprice(bcakeprice.getText().toString());
                birthdaycakesclass.setBcakeqty(bcakeqty.getText().toString());
                Date date = new Date();
                birthdaycakesclass.setBCreated_at(""+date.getTime());
                databaseHelperClass.addbirthday(birthdaycakesclass);
                alertDialog.dismiss();
                refreshData();
            }
        });
    }
}