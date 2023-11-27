package com.example.kcampusmanager;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LedgerHistoryActivity extends AppCompatActivity {

    ImageView back;
    FloatingActionButton floating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ledger_history);

        back = findViewById(R.id.back);
        floating = findViewById(R.id.floating);

        back.setOnClickListener(v -> {
            finish();
        });
        floating.setOnClickListener(v -> {
            // TODO 장부 신청하기 액티비티
        });
    }
}