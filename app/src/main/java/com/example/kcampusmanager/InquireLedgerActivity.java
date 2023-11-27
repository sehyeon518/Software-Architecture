package com.example.kcampusmanager;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class InquireLedgerActivity extends AppCompatActivity {

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inquire_ledger);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            finish();
        });

    }
}