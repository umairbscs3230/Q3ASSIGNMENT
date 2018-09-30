package com.example.umairbscs.q3assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;


public class register extends AppCompatActivity {
    Button signup ;
    EditText firstname,lastname,password,confirmpass,username;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{6,}" +               //at least 4 characters
                    "$");

    String str1,str2,str3,str4,str5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
         firstname=(EditText) findViewById(R.id.etfirstname);
         lastname=(EditText) findViewById(R.id.etlastname);
         password=(EditText) findViewById(R.id.etpassword);
         confirmpass=(EditText) findViewById(R.id.etconfirmpass);
         username=(EditText) findViewById(R.id.etusername);
        signup=(Button)findViewById(R.id.btnsignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                if(firstname() && lastname() && password() && confirmpass()&&validateLUsername())
                    OpenHome_Activity();


            }


        });





    }

    private boolean firstname() {
        str1=firstname.getText().toString();

        str1 = firstname.getText().toString().trim();

        if (str1.isEmpty()) {
            firstname.setError("Field can't be empty");
            return false;
        } else if (firstname.length() > 15) {
            firstname.setError("Username too long");
            return false;
        } else {
            firstname.setError(null);
            return true;
        }

    }
    private boolean lastname() {
        str2=lastname.getText().toString();

        str2 = lastname.getText().toString().trim();

        if (str2.isEmpty()) {
            lastname.setError("Field can't be empty");
            return false;
        } else if (lastname.length() > 15) {
            lastname.setError("Username too long");
            return false;
        } else {
            lastname.setError(null);
            return true;
        }
    }
    private boolean password() {
        str3=password.getText().toString();
        if (str3.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(str2).matches()) {
            password.setError("Password too weak");
            return false;
        } else {
            password.setError(null);
            return true;
        }
    }
    private boolean confirmpass() {
        str4=confirmpass.getText().toString();
        if (str4.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        } else if ((password.getText()!=confirmpass.getText())) {
            password.setError("password not match");
            return false;
        }
        else {
            password.setError(null);
            return true;
        }
    }

    private boolean validateLUsername() {
        str5 = username.getText().toString().trim();

        if (str5.isEmpty()) {
            username.setError("Field can't be empty");
            return false;
        } else if (username.length() > 15) {
            username.setError("Username too long");
            return false;
        } else {
            username.setError(null);
            return true;
        }

    }
    public void OpenHome_Activity()
    {
        Intent homee = new Intent(register.this, home.class);
        startActivity(homee);
    }




}
