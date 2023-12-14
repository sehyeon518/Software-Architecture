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
        setContentView(R.layout.dialog_ledger_history);

    }
}
