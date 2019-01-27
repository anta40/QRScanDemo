package com.app.a0590.qrscandemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentIntegrator scanIntegrator = new IntentIntegrator(ScanActivity.this);
        scanIntegrator.setOrientationLocked(false);
        scanIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (scanResult != null){
            String strResult = scanResult.getContents();
            Intent iii = new Intent(ScanActivity.this, ScanResultActivity.class);
            iii.putExtra("scan_result", strResult);
            startActivity(iii);
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
