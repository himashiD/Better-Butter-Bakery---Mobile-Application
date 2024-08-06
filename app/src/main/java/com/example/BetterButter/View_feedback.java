package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class View_feedback extends AppCompatActivity {

    DatabaseHelperClass databaseHelperClass;
    TextView datalistc;
    TextView datalist_countc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feedback);

        databaseHelperClass = new DatabaseHelperClass(View_feedback.this);
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
        datalist_countc.setText("All Data Count : "+databaseHelperClass.getTotalfeedback());
        List<FeedbackClass> feedbackClassList = databaseHelperClass.getAllfeedback();
        datalistc.setText("");
        for (FeedbackClass feedbackClass : feedbackClassList){
            datalistc.append(" No : "+feedbackClass.getFid()+ "\n" +
                    " Customer Name : "+feedbackClass.getFeedusername()+ "\n" +
                    " Customer Feedback : "+feedbackClass.getFeednotes()+ "\n" +
                    " Customer Feedback Status : "+feedbackClass.getFeedstatus()+ "\n\n");
        }
    }
}