package com.example.kcampusmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class InquireLedgerActivity extends AppCompatActivity {

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquire_ledger);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            finish();
        });

        List<LedgerItem> newLedgerItems = getNewLedgerItems();
        NewLedgerAdapter newLedgerAdapter = new NewLedgerAdapter(this, newLedgerItems);
        ListView newListView = findViewById(R.id.listview_ledger_new);
        newListView.setAdapter(newLedgerAdapter);
        newListView.setOnItemClickListener((parent, view, position, id) -> {
            LedgerItem selectedLedgerItem = newLedgerAdapter.getItem(position);
            Intent intent = new Intent(getApplicationContext(), LedgerAcceptDialog.class);
            intent.putExtra("breakdown", selectedLedgerItem);
            startActivity(intent);
        });

        List<LedgerItem> previousLedgerItems = getPreviousLedgerItems();
        PreviousLedgerAdapter previousLedgerAdapter = new PreviousLedgerAdapter(this, previousLedgerItems);
        ListView previousListView = findViewById(R.id.listview_ledger_history);
        previousListView.setAdapter(previousLedgerAdapter);
        previousListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LedgerItem selectedLedgerITem = newLedgerAdapter.getItem(position);

                // 다이얼로그 표시
            }
        });

    }

    private List<LedgerItem> getNewLedgerItems() {
        List<LedgerItem> ledgerItems = new ArrayList<>();

        ledgerItems.add(new LedgerItem(4, 20213043, "미래관2층31호실", new Date(2024, 1, 12), "대기", "동아리 활동"));
        ledgerItems.add(new LedgerItem(5, 20213043, "미래관6층11호실", new Date(2024, 2, 25), "대기", "스터디"));
        ledgerItems.add(new LedgerItem(6, 20213043, "미래관6층11호실", new Date(2024, 3, 2), "대기", "학생회의"));

        return ledgerItems;
    }

    private List<LedgerItem> getPreviousLedgerItems() {
        List<LedgerItem> ledgerItems = new ArrayList<>();

        ledgerItems.add(new LedgerItem(3, 20212021, "미래관2층31호실", new Date(2021, 11, 12), "대기", "동아리"));
        ledgerItems.add(new LedgerItem(2, 20222222, "미래관6층11호실", new Date(2021, 10, 11), "승인", "스터디"));
        ledgerItems.add(new LedgerItem(1, 20222222, "미래관6층11호실", new Date(2021, 10, 15), "거부", "스터디"));

        return ledgerItems;
    }

}