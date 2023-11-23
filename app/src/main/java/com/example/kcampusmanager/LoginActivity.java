package com.example.kcampusmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
            String userNum = userNumber.getText().toString();
            int length = userNum.length();
            int user = Integer.parseInt(userNum);

            String password = userPassword.getText().toString();

            if (length == 7) {
                Intent intent = new Intent(getApplicationContext(), ManagerActivity.class);
                startActivity(intent);
            }
            else if (length == 8) {
                Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), "올바른 학번/사번이 아닙니다", Toast.LENGTH_SHORT).show();
            }

        });
    }
}