package com.example.kcampusmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HelperCheckinActivity extends AppCompatActivity {

    ImageView back;
    TextView helper_name, helper_classroom, helper_class, helper_professor, helper_schedule;
    TextView checkin_text, checkin;

    int userNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_checkin);

        Intent getIntent = getIntent();
        userNumber = getIntent.getIntExtra("학번", 20230000);

        back = findViewById(R.id.back);
        helper_name = findViewById(R.id.helper_name);
        helper_classroom = findViewById(R.id.helper_classroom);
        helper_class = findViewById(R.id.helper_class);
        helper_professor = findViewById(R.id.helper_professor);
        helper_schedule = findViewById(R.id.helper_schedule);
        checkin = findViewById(R.id.checkin);

        back.setOnClickListener(v -> {
            finish();
        });
        helper_name.setText(userNumber + " 헬퍼");
        checkin.setOnClickListener(v -> {
            // TODO sharedpreference
            finish();
        });
    }
}