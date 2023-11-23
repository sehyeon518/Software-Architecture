package com.example.kcampusmanager;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
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
    TextView portal, cs, ecampus, sugang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        logout = findViewById(R.id.logout);
        studentNumber = findViewById(R.id.studentNumber);
        timetable = findViewById(R.id.timetable);
        writeLedger = findViewById(R.id.writeLedger);
        helperCheck = findViewById(R.id.helperCheck);
        portal = findViewById(R.id.portal);
        cs = findViewById(R.id.cs);
        ecampus = findViewById(R.id.ecampus);
        sugang = findViewById(R.id.sugang);

        setTextBold();

        logout.setOnClickListener(v -> {
            finish();
        });
        portal.setOnClickListener(v -> {
            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://portal.kookmin.ac.kr"));
        });
        cs.setOnClickListener(v -> {
            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cs.kookmin.ac.kr"));
            startActivity(urlintent);
        });
        ecampus.setOnClickListener(v -> {
            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ecampus.kookmin.ac.kr"));
            startActivity(urlintent);
        });
        sugang.setOnClickListener(v -> {
            Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sugang.kookmin.ac.kr"));
            startActivity(urlintent);
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