package com.example.myapptwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.Manifest;

public class SendCall extends AppCompatActivity implements View.OnClickListener {

    private EditText et_number;
    private Button btn_call;

    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_call);

        et_number = findViewById(R.id.et_number);
        btn_call = findViewById(R.id.btn_Call);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
                Log.d("SMS Permission", "Request permission to send SMS...");
                String[] permissions = {Manifest.permission.CALL_PHONE};
                requestPermissions(permissions, 1000);
            }
        }

        btn_call.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        number = et_number.getText().toString().trim();

        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+number));
        startActivity(callIntent);
    }
}