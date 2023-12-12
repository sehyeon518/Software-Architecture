package com.example.kcampusmanager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class HelperScheduleActivity extends AppCompatActivity {

    ImageView back;
    Spinner spinner;
    ImageButton swap;
    ImageView schedule;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_schedule);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            finish();
        });

        swap = findViewById(R.id.swap);
        swap.setOnClickListener(v -> {
            finish();
        });

        spinner = findViewById(R.id.helper_spinner);
        schedule = findViewById(R.id.iv_helper_schedule);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.helper_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinnerListener();
    }

    public void spinnerListener() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        schedule.setImageResource(R.drawable.img_schedule_helper_net);
                        break;
                    case 1:
                        schedule.setImageResource(R.drawable.img_schedule_helper_os);
                        break;
                    case 2:
                        schedule.setImageResource(R.drawable.img_schedule_helper_archi);
                        break;
                    case 3:
                        schedule.setImageResource(R.drawable.img_schedule_helper_algo);
                        break;
                    case 4:
                        schedule.setImageResource(R.drawable.img_schedule_helper_sode);
                        break;
                    case 5:
                        schedule.setImageResource(R.drawable.img_schedule_helper_vision);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}