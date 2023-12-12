package com.example.kcampusmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewLedgerAdapter extends ArrayAdapter<LedgerItem> {

    public NewLedgerAdapter(@NonNull Context context, @NonNull List<LedgerItem> ledgerItems) {
        super(context, 0, ledgerItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LedgerItem ledgerItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_ledger_inquire_new, parent, false);
        }

        // 각 TextView에 데이터 설정
        TextView ledgerDateTextView = convertView.findViewById(R.id.ledger_date);
        TextView ledgerClassroomTextView = convertView.findViewById(R.id.ledger_classroom);

        if (ledgerItem != null) {
            ledgerClassroomTextView.setText(ledgerItem.getClassroomName());
            ledgerDateTextView.setText(ledgerItem.getFormattedReservationDate());
        }
        return convertView;
    }

    private String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("M/dd");
        return sdf.format(date);
    }
}

