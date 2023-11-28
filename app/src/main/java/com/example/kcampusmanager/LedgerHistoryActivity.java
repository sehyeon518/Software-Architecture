package com.example.kcampusmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LedgerHistoryActivity extends AppCompatActivity {

    ImageView back;
    FloatingActionButton floating;

    int userNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ledger_history);

        Intent getIntent = getIntent();
        userNumber = getIntent.getIntExtra("학번", 20230000);

        back = findViewById(R.id.back);
        floating = findViewById(R.id.floating);

        back.setOnClickListener(v -> {
            finish();
        });
        floating.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SubmitLedgerActivity.class);
            intent.putExtra("학번", userNumber);
            startActivity(intent);
        });
    }
}