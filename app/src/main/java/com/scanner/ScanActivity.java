package com.scanner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class ScanActivity extends AppCompatActivity {

    Button scan;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        scan = findViewById(R.id.btn_scan2);
        scan.setOnClickListener(V -> scanner());

        back = findViewById(R.id.img_back_scan);
        back.setOnClickListener(V -> {
            Intent intent = new Intent(ScanActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }

    public void scanner(){
        ScanOptions scanOptions = new ScanOptions();
        scanOptions.setPrompt("Volume up to Flash on");
        scanOptions.setBeepEnabled(true);
        scanOptions.setOrientationLocked(true);
        scanOptions.setCaptureActivity(StartScan.class);
        louncer.launch(scanOptions);
    }

    ActivityResultLauncher<ScanOptions> louncer = registerForActivityResult(new ScanContract(),result -> {
        if (result.getContents() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ScanActivity.this);
            builder.setTitle("QR-CODE Result");
            builder.setMessage(result.getContents());
            builder.setPositiveButton("oke", (dialogInterface, i) -> dialogInterface.dismiss()).show();
        }
    });


}