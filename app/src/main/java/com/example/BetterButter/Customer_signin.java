package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Customer_signin extends AppCompatActivity {

    private boolean passwordShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signin);

        final EditText Cemail = findViewById(R.id.Cemail);
        final EditText Cpassword = findViewById(R.id.Cpassword);
        final ImageView Cpasswordicon = findViewById(R.id.customer_passwordup_icon);
        final TextView Csignup = findViewById(R.id.customer_signup_btn);
        final Button Csigninbtn = findViewById(R.id.customer_signin_btn);

        Cpasswordicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Checking if password is showing or not
                if(passwordShowing){
                    passwordShowing = false;

                    Cpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    Cpasswordicon.setImageResource(R.drawable.showpassword);
                }
                else {
                    Cpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    Cpasswordicon.setImageResource(R.drawable.showpassword);
                }

                // Move the cursor at last of the text
                Cpassword.setSelection(Cpassword.length());
            }
        });

        Csignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Customer_signin.this, Customer_signup.class));
            }
        });

        Csigninbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Cemail.getText().toString();
                String password = Cpassword.getText().toString();
                Database db = new Database(getApplicationContext(),"SweetCake",null,1);
                if(Cemail.length()==0 || Cpassword.length()==0){
                    Toast.makeText(getApplicationContext(),"Please Fill All Details", Toast.LENGTH_SHORT).show();

                }else {
                    if(db.Csignin(email,password)==1){
                        Toast.makeText(getApplicationContext(),"Login success",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email", email);
                        editor.apply();

                        startActivity(new Intent(Customer_signin.this,Customer_home.class));
                    }else {
                        Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });


    }
}