package com.example.kcampusmanager;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
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
    TextView portal, cs, ecampus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        logout = findViewById(R.id.logout);
        userNumber = findViewById(R.id.managerNumber);
        timetable = findViewById(R.id.timetable);
        ledger = findViewById(R.id.ledger);
        classroom = findViewById(R.id.classroom);
        portal = findViewById(R.id.portal);
        cs = findViewById(R.id.cs);
        ecampus = findViewById(R.id.ecampus);

        Intent managerNumber = getIntent();
        userNumber.setText(String.valueOf(managerNumber.getIntExtra("사번", 2023000)));

        setTextBold();

        logout.setOnClickListener(v -> {
            finish();
        });
        timetable.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ClassScheduleActivity.class);
            startActivity(intent);
        });
        ledger.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), InquireLedgerActivity.class);
            startActivity(intent);
        });
        portal.setOnClickListener(v -> {
            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://portal.kookmin.ac.kr"));
            startActivity(urlintent);
        });
        cs.setOnClickListener(v -> {
            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cs.kookmin.ac.kr"));
            startActivity(urlintent);
        });
        ecampus.setOnClickListener(v -> {
            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ecampus.kookmin.ac.kr"));
            startActivity(urlintent);
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