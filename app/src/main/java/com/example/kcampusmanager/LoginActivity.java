package com.example.kcampusmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText userNumber, userPassword;
    TextView loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNumber = findViewById(R.id.userNumber);
        userPassword = findViewById(R.id.userPassword);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> {
            if (userNumber.getText().length() == 7) {
                Intent intent = new Intent(getApplicationContext(), ManagerActivity.class);
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                startActivity(intent);
            }
        });
    }
}