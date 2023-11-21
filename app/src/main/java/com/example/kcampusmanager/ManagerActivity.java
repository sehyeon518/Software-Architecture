package com.example.kcampusmanager;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ManagerActivity extends AppCompatActivity {

    ImageView logout;
    TextView userNumber;
    TextView timetable,  ledger, classroom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        logout = findViewById(R.id.logout);
        userNumber = findViewById(R.id.userNumber2);
        timetable = findViewById(R.id.timetable);
        ledger = findViewById(R.id.ledger);
        classroom = findViewById(R.id.classroom);

        setTextBold();

        logout.setOnClickListener(v -> {
            finish();
        });
    }

    void setTextBold() {
        SpannableStringBuilder spannable = new SpannableStringBuilder("시간표\n조회");
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        spannable.setSpan(boldSpan, 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        timetable.setText(spannable);

        spannable = new SpannableStringBuilder("장부\n조회");
        boldSpan = new StyleSpan(Typeface.BOLD);
        spannable.setSpan(boldSpan, 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);;
        ledger.setText(spannable);

        spannable = new SpannableStringBuilder("강의실\n개폐");
        boldSpan = new StyleSpan(Typeface.BOLD);
        spannable.setSpan(boldSpan, 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);;
        classroom.setText(spannable);
    }
}