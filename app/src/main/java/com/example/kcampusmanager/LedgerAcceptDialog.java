package com.example.kcampusmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class LedgerAcceptDialog extends Activity {

    TextView ledger_breakdown;
    TextView ledger_deny, ledger_accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        setContentView(R.layout.dialog_ledger_new);

        ledger_breakdown = findViewById(R.id.ledger_breakdown);
        Intent getIntent = getIntent();
        if (getIntent.hasExtra("breakdown")) {
            LedgerItem receivedItem = (LedgerItem) getIntent.getSerializableExtra("breakdown");
            String classroom = receivedItem.getClassroomName();
            String studentName = String.valueOf(receivedItem.getStudentNumber());
            String dateAndTime = new SimpleDateFormat("MM월 dd일").format(receivedItem.getReservationTime());
            String reason = receivedItem.getReservationReason();

            TextView ledgerBreakdownTextView = findViewById(R.id.ledger_breakdown);
            String breakdownText = "강의실: " + classroom + "\n"
                    + "신청자: " + studentName + "\n"
                    + "날짜: " + dateAndTime + "\n"
                    + "사유: " + reason;
            ledgerBreakdownTextView.setText(breakdownText);
        }

        ledger_deny = findViewById(R.id.ledger_deny);
        ledger_accept = findViewById(R.id.ledger_accept);

        ledger_deny.setOnClickListener(v -> {
            finish();
        });
        ledger_accept.setOnClickListener(v -> {
            finish();
        });
    }
}
