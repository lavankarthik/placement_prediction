package com.example.placement_predict;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView userName =(TextView) findViewById(R.id.editTextEmail);
        TextView password =(TextView) findViewById(R.id.editTextPassword);

        MaterialButton btnSubmit = (MaterialButton) findViewById(R.id.buttonLogin);

        //admin and admin

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().equals("2011cs010266@mallareddyuniversity.ac.in") && password.getText().toString().equals("lavan@143")) {
                    //correct
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                    startActivity(intent);
                } else
                    //incorrect
                    Toast.makeText(LoginActivity.this, "LOGIN FAILED !!!", Toast.LENGTH_SHORT).show();
            }


        });
    }
    }
