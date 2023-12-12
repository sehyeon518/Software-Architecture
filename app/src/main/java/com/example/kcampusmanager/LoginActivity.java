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
            if (userNum.trim().isEmpty()) {
                Toast.makeText(getApplicationContext(), "학번/사번을 입력하세요", Toast.LENGTH_SHORT).show();
                return;
            }

            int userLength = userNum.length();
            int user = Integer.parseInt(userNum);

            String password = userPassword.getText().toString();
            int pwLength = password.length();

            if (userLength == 7 && user > 1000000 && user < 2024000 && pwLength >= 6 && pwLength <= 12) {
                Intent intent = new Intent(getApplicationContext(), ManagerActivity.class);
                intent.putExtra("사번", user);
                startActivity(intent);
            }
            else if (userLength == 8 && user > 10000000 && user < 20240000 && pwLength >= 6 && pwLength <= 12) {
                Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
                intent.putExtra("학번", user);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), "올바른 학번/사번/비밀번호가 아닙니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}