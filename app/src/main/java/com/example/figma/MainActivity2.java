package com.example.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity2 extends AppCompatActivity {

    private TextInputEditText emailET;
    private TextInputEditText passwordET;

    private TextInputLayout emailL;
    private TextInputLayout passwordL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        emailET = findViewById(R.id.emailLogET);
        passwordET = findViewById(R.id.passLogET);

        emailL = findViewById(R.id.emailLogL);
        passwordL = findViewById(R.id.passLogL);
    }

    public void onClickLog(View v) {
        Intent intent = new Intent(this, MainActivity3.class);
        Intent intent1 = new Intent(this, MainActivity4.class);
        switch (v.getId()) {
            case R.id.btnLogSignIn:
                String emailText = emailET.getText().toString();
                String passwordText = passwordET.getText().toString();

                emailL.setErrorEnabled(false);
                passwordL.setErrorEnabled(false);

                Pattern pattern = Pattern.compile("[a-z0-9]+[@][a-z0-9]+[.][a-z]{1,3}");
                Matcher matcher = pattern.matcher(emailText);
                boolean match = matcher.matches();

                if(emailText.equals(""))
                    emailL.setError("Enter the data!");
                if(passwordText.equals(""))
                    passwordL.setError("Enter the data!");
                else if(!match) emailL.setError("Email isn't corrected!");
                else {
                    intent1.putExtra("email", emailText);
                    intent1.putExtra("password", passwordText);
                    startActivity(intent1);
                }
                break;

            case R.id.btnLogSignUp:
                startActivity(intent);
                break;
        }
    }
}