package com.example.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity3 extends AppCompatActivity {
    private TextInputEditText nameET;
    private TextInputEditText emailET;
    private TextInputEditText password1ET;
    private TextInputEditText password2ET;

    private TextInputLayout nameL;
    private TextInputLayout emailL;
    private TextInputLayout password1L;
    private TextInputLayout password2L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nameET = findViewById(R.id.nameRegET);
        emailET = findViewById(R.id.emailRegET);
        password1ET = findViewById(R.id.passReg1ET);
        password2ET = findViewById(R.id.passReg2ET);

        nameL = findViewById(R.id.nameRegL);
        emailL = findViewById(R.id.emailRegL);
        password1L = findViewById(R.id.passReg1L);
        password2L = findViewById(R.id.passReg2L);
    }

    public void onClickReg(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        switch (v.getId()) {
            case R.id.btnRegSignUp:
                String nameText = nameET.getText().toString();
                String emailText = emailET.getText().toString();
                String password1Text = password1ET.getText().toString();
                String password2Text = password2ET.getText().toString();

                Pattern pattern = Pattern.compile("[a-z0-9]+[@][a-z0-9]+[.][a-z]{1,3}");
                Matcher matcher = pattern.matcher(emailText);
                boolean match = matcher.matches();

                nameL.setErrorEnabled(false);
                emailL.setErrorEnabled(false);
                password1L.setErrorEnabled(false);
                password2L.setErrorEnabled(false);

                if(nameText.equals(""))
                    nameL.setError("Enter the data!");
                if(emailText.equals(""))
                    emailL.setError("Enter the data!");
                if(password1Text.equals(""))
                    password1L.setError("Enter the data!");
                if(password2Text.equals(""))
                    password2L.setError("Enter the data!");
                else if(!match) emailL.setError("Email isn't corrected!");
                else startActivity(intent);
                break;

            case R.id.btnRegCancel:
                startActivity(intent);
                break;
        }
    }
}