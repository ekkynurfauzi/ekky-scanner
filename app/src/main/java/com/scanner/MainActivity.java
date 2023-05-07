package com.scanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_scan, btn_generate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_scan = findViewById(R.id.btn_scan);
        btn_scan.setOnClickListener(V -> {
            Intent scan = new Intent(MainActivity.this, ScanActivity.class);
            startActivity(scan);
            finish();
        });

        btn_generate = findViewById(R.id.btn_generate);
        btn_generate.setOnClickListener(V -> {
            Intent generate = new Intent(MainActivity.this, GenerateActivity.class);
            startActivity(generate);
            finish();
        });
    }
}