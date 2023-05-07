package com.scanner;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class GenerateActivity extends AppCompatActivity {

   private Button btn_scan;
    private ImageView back, result;
   private EditText edt_input;
   private MultiFormatWriter multiFormatWritet = new MultiFormatWriter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);

        btn_scan  = findViewById(R.id.btn_generate2);

        result = findViewById(R.id.imgview);

        edt_input = findViewById(R.id.edt_input);

        back = findViewById(R.id.img_back);
        back.setOnClickListener(V  -> {
            Intent intent = new Intent(GenerateActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        btn_scan.setOnClickListener(V -> {
            generate();
        });

    }

    public void generate() {
        try {
            String input = edt_input.getText().toString();
            if (input != null) {
                BitMatrix bitMatrix = multiFormatWritet.encode(input, BarcodeFormat.QR_CODE, 300, 300);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                result.setImageBitmap(bitmap);
            } else {
                Toast.makeText(getApplicationContext(),"Harap beri input", Toast.LENGTH_SHORT).show();
            }

        } catch (WriterException e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

        }
    }

}