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

public class Customer_signup extends AppCompatActivity {

    private boolean passwordShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signup);

        final EditText Cfullname = findViewById(R.id.Cfullname);
        final EditText Cemail = findViewById(R.id.Cemail);
        final EditText Cpassword = findViewById(R.id.Cpassword);
        final EditText Cconpassword = findViewById(R.id.Cconpassword);
        final ImageView Cpasswordiconsignup = findViewById(R.id.customer_passwordin_icon);
        final ImageView Cconpasswordiconsignup = findViewById(R.id.customer_conpasswordup_icon);
        final TextView Csignin = findViewById(R.id.customer_signinup_btn);
        final Button Csignupbtn = findViewById(R.id.customer_signuporg_btn);

        Cpasswordiconsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Checking if password is showing or not
                if(passwordShowing){
                    passwordShowing = false;

                    Cpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    Cpasswordiconsignup.setImageResource(R.drawable.showpasswordss);
                }
                else {
                    Cpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    Cpasswordiconsignup.setImageResource(R.drawable.showpassword);
                }

                // Move the cursor at last of the text
                Cpassword.setSelection(Cpassword.length());
            }
        });

        Cconpasswordiconsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Checking if password is showing or not
                if(passwordShowing){
                    passwordShowing = false;

                    Cconpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    Cconpasswordiconsignup.setImageResource(R.drawable.showpasswordss);
                }
                else {
                    Cconpassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    Cconpasswordiconsignup.setImageResource(R.drawable.showpassword);
                }

                // Move the cursor at last of the text
                Cpassword.setSelection(Cpassword.length());
            }
        });

        Csignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Customer_signup.this, Customer_signin.class));
            }
        });

        Csignupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = Cfullname.getText().toString();
                String email = Cemail.getText().toString();
                String password = Cpassword.getText().toString();
                String confirmpassword = Cconpassword.getText().toString();
                Database db = new Database(getApplicationContext(),"SweetCake",null,1);

                if (fullname.length() == 0 || email.length() == 0 || password.length() == 0 || confirmpassword.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirmpassword) == 0) {
                        if(isValid(password)){
                            db.Csignup(fullname,email,password);
                            Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Customer_signup.this,Customer_signin.class));

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
