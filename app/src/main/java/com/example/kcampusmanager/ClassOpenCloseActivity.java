package com.example.kcampusmanager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class ClassOpenCloseActivity extends AppCompatActivity {
    ImageView back;
    ListView listview;
    ClassListViewAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom_open_close);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            finish();
        });

        adapter = new ClassListViewAdapter();

        listview = (ListView) findViewById(R.id.lv_classroom_op_class);
        listview.setAdapter(adapter);

        adapter.addItem("미래관 2층 31호실", false);
        adapter.addItem("미래관 2층 32호실", false);
        adapter.addItem("미래관 4층 24호실", false);
        adapter.addItem("미래관 4층 45호실", false);
        adapter.addItem("미래관 4층 47호실", false);
        adapter.addItem("미래관 6층 11호실", false);
    }
}
