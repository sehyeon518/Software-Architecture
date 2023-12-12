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

public class LedgerAdapter extends ArrayAdapter<LedgerItem> {

    public LedgerAdapter(@NonNull Context context, @NonNull List<LedgerItem> ledgerItems) {
        super(context, 0, ledgerItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LedgerItem ledgerItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_ledger_history_previous, parent, false);
        }

        // 각 TextView에 데이터 설정
        TextView ledgerNumberTextView = convertView.findViewById(R.id.ledger_number);
        TextView ledgerStatusTextView = convertView.findViewById(R.id.ledger_status);
        TextView ledgerClassroomTextView = convertView.findViewById(R.id.ledger_classroom);
        TextView ledgerDateTextView = convertView.findViewById(R.id.ledger_date);

        if (ledgerItem != null) {
            ledgerNumberTextView.setText(String.valueOf(ledgerItem.getLedgerNumber()));
            ledgerStatusTextView.setText(ledgerItem.getReservationStatus());
            ledgerClassroomTextView.setText(ledgerItem.getClassroomName());
            ledgerDateTextView.setText(formatDate(ledgerItem.getReservationTime()));

            if ("승인".equals(ledgerItem.getReservationStatus())) {
                ledgerStatusTextView.setBackgroundResource(R.drawable.greenbutton);
            } else if ("거부".equals(ledgerItem.getReservationStatus())) {
                ledgerStatusTextView.setBackgroundResource(R.drawable.yellowbutton);
            } else {
                ledgerStatusTextView.setBackgroundResource(R.drawable.graybutton);
            }
        }

        return convertView;
    }

    private String formatDate(Date date) {
        if (date == null) {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
        return sdf.format(date);
    }
}

