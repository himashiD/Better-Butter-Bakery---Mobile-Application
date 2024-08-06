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

public class Admin_signin extends AppCompatActivity {

    private boolean passwordShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signin);

        final EditText Femail = findViewById(R.id.Femail);
        final EditText Fpassword = findViewById(R.id.Fpassword);
        final ImageView Fpasswordicon = findViewById(R.id.admin_passwordup_icon);
        final TextView Fsignup = findViewById(R.id.admin_signup_btn);
        final Button Fsigninbtn = findViewById(R.id.admin_signin_btn);

        Fpasswordicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Checking if password is showing or not
                if(passwordShowing){
                    passwordShowing = false;

                    Fpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    Fpasswordicon.setImageResource(R.drawable.showpassword);
                }
                else {
                    Fpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    Fpasswordicon.setImageResource(R.drawable.showpassword);
                }

                // Move the cursor at last of the text
                Fpassword.setSelection(Fpassword.length());
            }
        });

        Fsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_signin.this, Admin_signup.class));
            }
        });

        Fsigninbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Femail.getText().toString();
                String password = Fpassword.getText().toString();
                Database db = new Database(getApplicationContext(),"SweetCake",null,1);
                if(Femail.length()==0 || Fpassword.length()==0){
                    Toast.makeText(getApplicationContext(),"Please Fill All Details", Toast.LENGTH_SHORT).show();

                }else {
                    if(db.Fsignin(email,password)==1){
                        Toast.makeText(getApplicationContext(),"Login success",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email", email);
                        editor.apply();

                        startActivity(new Intent(Admin_signin.this,Admin_home.class));
                    }else {
                        Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });


    }
}