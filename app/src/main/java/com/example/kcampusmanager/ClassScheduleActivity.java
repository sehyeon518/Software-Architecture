package com.example.kcampusmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class ClassScheduleActivity extends AppCompatActivity {

    ImageView back;
    Spinner spinner;
    LinearLayout swap;
    ImageView schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom_schedule);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            finish();
        });

        swap = findViewById(R.id.swap);
        swap.setOnClickListener(v -> {
            ; // TODO 헬퍼 시간표 swap
        });

        spinner = findViewById(R.id.classroom_spinner);
        schedule = findViewById(R.id.iv_classroom_schedule);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.classroom_array, android.R.layout.simple_spinner_item);
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
                        schedule.setImageResource(R.drawable.img_schedule_classroom_231);
                        break;
                    case 1:
                        schedule.setImageResource(R.drawable.img_schedule_classroom_232);
                        break;
                    case 2:
                        schedule.setImageResource(R.drawable.img_schedule_classroom_424);
                        break;
                    case 3:
                        schedule.setImageResource(R.drawable.img_schedule_classroom_445);
                        break;
                    case 4:
                        schedule.setImageResource(R.drawable.img_schedule_classroom_447);
                        break;
                    case 5:
                        schedule.setImageResource(R.drawable.img_schedule_classroom_611);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}