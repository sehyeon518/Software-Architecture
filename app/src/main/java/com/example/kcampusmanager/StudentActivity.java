package com.example.kcampusmanager;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StudentActivity extends AppCompatActivity {

    ImageView logout;
    TextView studentNumber;
    TextView timetable, writeLedger, helperCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        logout = findViewById(R.id.logout);
        studentNumber = findViewById(R.id.studentNumber);
        timetable = findViewById(R.id.timetable);
        writeLedger = findViewById(R.id.writeLedger);
        helperCheck = findViewById(R.id.helperCheck);

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

        spannable = new SpannableStringBuilder("장부\n작성하기");
        boldSpan = new StyleSpan(Typeface.BOLD);
        spannable.setSpan(boldSpan, 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);;
        writeLedger.setText(spannable);

        spannable = new SpannableStringBuilder("헬퍼\n근무");
        boldSpan = new StyleSpan(Typeface.BOLD);
        spannable.setSpan(boldSpan, 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);;
        helperCheck.setText(spannable);
    }
}