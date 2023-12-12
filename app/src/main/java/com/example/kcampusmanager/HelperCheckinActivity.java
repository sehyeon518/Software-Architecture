package com.example.kcampusmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HelperCheckinActivity extends AppCompatActivity {

    ImageView back;
    TextView helper_name, helper_classroom, helper_class, helper_professor, helper_schedule;
    TextView checkin_text, checkin;

    int userNumber;
    boolean isCheckedIn; // 출근 여부를 나타내는 변수

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
        checkin_text = findViewById(R.id.checkin_text);
        checkin = findViewById(R.id.checkin);

        back.setOnClickListener(v -> {
            finish();
        });
        helper_name.setText(userNumber + " 헬퍼");

        SharedPreferences preferences = getSharedPreferences("CheckinPreferences", Context.MODE_PRIVATE);
        isCheckedIn = preferences.getBoolean("isCheckedIn", false);

        // 출근 상태에 따라 버튼 텍스트 설정
        updateButtonText();

        back.setOnClickListener(v -> {
            finish();
        });

        helper_name.setText(userNumber + " 헬퍼");

        checkin.setOnClickListener(v -> {
            // 출근 상태 토글
            if(isCheckedIn) {
                Toast.makeText(getApplicationContext(), userNumber + " 학생 퇴근하였습니다.", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), userNumber + " 학생 출근 완료하였습니다.", Toast.LENGTH_SHORT).show();
            }
            isCheckedIn = !isCheckedIn;

            // SharedPreferences에 출근 상태 저장
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isCheckedIn", isCheckedIn);
            editor.apply();

            // 버튼 텍스트 업데이트
            updateButtonText();
        });
    }

    // 출근 버튼 텍스트 업데이트 메서드
    private void updateButtonText() {
        if (isCheckedIn) {
            checkin_text.setText("퇴근하시겠습니까?");
            checkin.setText("퇴근하기");
        } else {
            checkin_text.setText("출근하시겠습니까?");
            checkin.setText("출근하기");
        }
    }
}