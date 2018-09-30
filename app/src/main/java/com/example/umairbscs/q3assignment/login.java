package com.example.umairbscs.q3assignment;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity
{
 //private  Button button=(Button)findViewById(R.id.btnsignup);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText email=(EditText) findViewById(R.id.etuusername);
        final EditText password=(EditText) findViewById(R.id.etpassword);
        Button login=(Button)findViewById(R.id.btnlogin);
        Button signup=(Button)findViewById(R.id.signupbtn);
       signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1=new Intent(login.this,register.class);
                startActivity(intent1);
            }


        });



            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean check=false;
                    if (email.getText().toString().equals(""))
                    {
                        email.setError("Invalid Email");
                        check = true;
                    }
                   else if ((password.getText().toString().equals(""))&&(password.getText().toString().length()<5))
                    {
                        password.setError("Invalid Password");
                        check=true;
                    }
                    else
                     {
                        Intent intent2 = new Intent(login.this, home.class);
                        startActivity(intent2);
                    }}


            });
             }







    }

