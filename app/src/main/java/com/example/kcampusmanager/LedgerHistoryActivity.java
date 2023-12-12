package com.example.kcampusmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class LedgerHistoryActivity extends AppCompatActivity {

    ImageView back;
    FloatingActionButton floating;

    int userNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledger_history);

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

        // 어댑터를 초기화하고 ListView에 연결
        List<LedgerItem> ledgerItems = getLedgerItems();
        LedgerAdapter ledgerAdapter = new LedgerAdapter(this, ledgerItems);
        ListView listView = findViewById(R.id.listview_ledger_history);
        listView.setAdapter(ledgerAdapter);

    }

    private List<LedgerItem> getLedgerItems() {
        List<LedgerItem> ledgerItems = new ArrayList<>();

        ledgerItems.add(new LedgerItem(1, 20212021, "미래관2층31호실", new Date(2021, 12, 12), "대기", "동아리"));
        ledgerItems.add(new LedgerItem(2, 20222222, "미래관6층11호실", new Date(2021, 11, 11), "승인", "스터디"));
        ledgerItems.add(new LedgerItem(3, 20222222, "미래관6층11호실", new Date(2021, 11, 15), "거부", "스터디"));

        return ledgerItems;
    }
}