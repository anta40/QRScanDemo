package com.app.a0590.qrscandemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class ScanResultActivity extends AppCompatActivity {

    EditText txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);

        txtResult = (EditText) findViewById(R.id.txtResult);

        Bundle bnd = getIntent().getExtras();
        String result = bnd.getString("scan_result");

        txtResult.setText(result);

    }
}
