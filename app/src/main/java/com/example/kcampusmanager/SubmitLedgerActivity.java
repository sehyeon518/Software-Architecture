package com.example.kcampusmanager;

import static java.lang.String.valueOf;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SubmitLedgerActivity extends AppCompatActivity {

    ImageView back, calendar;
    TextView studentNumber, borrowDate, submit;
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