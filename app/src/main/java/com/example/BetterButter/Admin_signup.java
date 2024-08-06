package com.example.BetterButter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Admin_signup extends AppCompatActivity {

    private boolean passwordShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_signup);

        final EditText Ffullname = findViewById(R.id.Afullname);
        final EditText Femail = findViewById(R.id.Aemail);
        final EditText Fpassword = findViewById(R.id.Apassword);
        final EditText Fconpassword = findViewById(R.id.Aconpassword);
        final ImageView Fpasswordiconsignup = findViewById(R.id.admin_passwordin_icon);
        final ImageView Fconpasswordiconsignup = findViewById(R.id.admin_conpasswordup_icon);
        final TextView Fsignin = findViewById(R.id.admin_signinup_btn);
        final Button Fsignupbtn = findViewById(R.id.admin_signuporg_btn);

        Fpasswordiconsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Checking if password is showing or not
                if(passwordShowing){
                    passwordShowing = false;

                    Fpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    Fpasswordiconsignup.setImageResource(R.drawable.showpasswordss);
                }
                else {
                    Fpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    Fpasswordiconsignup.setImageResource(R.drawable.showpassword);
                }

                // Move the cursor at last of the text
                Fpassword.setSelection(Fpassword.length());
            }
        });

        Fconpasswordiconsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Checking if password is showing or not
                if(passwordShowing){
                    passwordShowing = false;

                    Fconpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    Fconpasswordiconsignup.setImageResource(R.drawable.showpasswordss);
                }
                else {
                    Fconpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    Fconpasswordiconsignup.setImageResource(R.drawable.showpassword);
                }

                // Move the cursor at last of the text
                Fpassword.setSelection(Fpassword.length());
            }
        });

        Fsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Admin_signup.this, Admin_signin.class));
            }
        });

        Fsignupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = Ffullname.getText().toString();
                String email = Femail.getText().toString();
                String password = Fpassword.getText().toString();
                String confirmpassword = Fconpassword.getText().toString();
                Database db = new Database(getApplicationContext(),"SweetCake",null,1);

                if (fullname.length() == 0 || email.length() == 0 || password.length() == 0 || confirmpassword.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirmpassword) == 0) {
                        if(isValid(password)){
                            db.Fsignup(fullname,email,password);
                            Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Admin_signup.this,Admin_signin.class));

                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Password must contain at least characters,having letter,digit and special symbol",Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Passsword and Confirm Password didn't match", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });

    }
    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
            if (f1 == 1 && f2 == 1 && f3 == 1)
                return true;
            return false;
        }
    }
}