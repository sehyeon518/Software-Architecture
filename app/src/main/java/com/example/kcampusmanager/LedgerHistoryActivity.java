package com.example.kcampusmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class LedgerHistoryActivity extends AppCompatActivity {

    ImageView back;
    FloatingActionButton floating;

    int userNumber;

    private static final int SUBMIT_LEDGER_REQUEST_CODE = 100;

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
            Intent intent = new Intent(this, SubmitLedgerActivity.class);
            intent.putExtra("학번", userNumber);
            startActivityForResult(intent, SUBMIT_LEDGER_REQUEST_CODE);
        });

        // 어댑터를 초기화하고 ListView에 연결
        List<LedgerItem> ledgerItems = getLedgerItems();
        LedgerAdapter ledgerAdapter = new LedgerAdapter(this, ledgerItems);
        ListView listView = findViewById(R.id.listview_ledger_history);
        listView.setAdapter(ledgerAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        List<LedgerItem> ledgerItems = getLedgerItems();
        Toast.makeText(getApplicationContext(), "학번/사번을 입력하세요", Toast.LENGTH_SHORT).show();

        if (requestCode == 100 && resultCode == RESULT_OK) {
            if (data != null) {
                LedgerItem newLedger = (LedgerItem) data.getSerializableExtra("newLedger");

                if (newLedger != null) {
                    ledgerItems = addLedgerItem(ledgerItems, newLedger);
                }
            }
        }
        LedgerAdapter ledgerAdapter = new LedgerAdapter(this, ledgerItems);
        ListView listView = findViewById(R.id.listview_ledger_history);
        listView.setAdapter(ledgerAdapter);
    }

    private List<LedgerItem> getLedgerItems() {
        List<LedgerItem> ledgerItems = new ArrayList<>();

        ledgerItems.add(new LedgerItem(3, 20212021, "미래관2층31호실", new Date(2021, 11, 12), "대기", "동아리"));
        ledgerItems.add(new LedgerItem(2, 20222222, "미래관6층11호실", new Date(2021, 10, 11), "승인", "스터디"));
        ledgerItems.add(new LedgerItem(1, 20222222, "미래관6층11호실", new Date(2021, 10, 15), "거부", "스터디"));

        return ledgerItems;
    }

    private List<LedgerItem> addLedgerItem(List<LedgerItem> ledgerItems, LedgerItem newLedger) {
        ledgerItems.add(newLedger);
        ledgerItems.sort((ledgerItem1, ledgerItem2) ->
                Integer.compare(ledgerItem2.getLedgerNumber(), ledgerItem1.getLedgerNumber()));
        return ledgerItems;
    }
}