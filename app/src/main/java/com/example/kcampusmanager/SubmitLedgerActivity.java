package com.example.kcampusmanager;

import static java.lang.String.valueOf;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SubmitLedgerActivity extends AppCompatActivity {

    ImageView back, calendar;
    TextView studentNumber, borrowDate, submit;
    EditText reason;
    Spinner spinner;

    int userNumber;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_ledger);

        Intent getIntent = getIntent();
        userNumber = getIntent.getIntExtra("학번", 20230000);

        back = findViewById(R.id.back);
        studentNumber = findViewById(R.id.userNumber);
        spinner = findViewById(R.id.classroom_spinner);
        borrowDate = findViewById(R.id.borrowDate);
        calendar = findViewById(R.id.calendar);
        reason = findViewById(R.id.reason);
        submit = findViewById(R.id.submit);

        back.setOnClickListener(v -> {
            finish();
        });
        studentNumber.setText(valueOf(userNumber));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.classroom_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        submit.setOnClickListener(v -> {
            String selectedClassroom = spinner.getSelectedItem().toString();
            String selectedDate = borrowDate.getText().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date parsedDate = null;
            try {
                parsedDate = sdf.parse(selectedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String borrowReason = reason.getText().toString();
            LedgerItem newLedger = new LedgerItem(4, userNumber, selectedClassroom, parsedDate, "대기", borrowReason);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("newLedger", newLedger);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        calendar.setOnClickListener(view -> {
            Calendar cal = Calendar.getInstance();
            int pYear = cal.get(Calendar.YEAR);
            int pMonth = cal.get(Calendar.MONTH);
            int pDay = cal.get(Calendar.DAY_OF_MONTH);

            datePickerDialog = new DatePickerDialog(SubmitLedgerActivity.this, (datePicker, year, month, day) -> {
                month = month + 1;
                String date = year + "/" + month + "/" + day;
                borrowDate.setText(date);
            }, pYear, pMonth, pDay);
            datePickerDialog.show();
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}