package com.example.myapptwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.Manifest;

public class SendSMS extends AppCompatActivity implements View.OnClickListener {

    private EditText et_number;
    private EditText et_msg;
    private Button btn_SMS;


    private String phone_number;
    private String msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

        et_number = findViewById(R.id.et_number);
        et_msg = findViewById(R.id.et_msg);
        btn_SMS = findViewById(R.id.btn_SMS);

        btn_SMS.setOnClickListener(this);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
                Log.d("SMS Permission", "Request permission to send SMS...");
                String[] permissions = {Manifest.permission.SEND_SMS};
                requestPermissions(permissions, 1000);
            }
        }
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (id == R.id.btn_SMS) {
            phone_number = et_number.getText().toString().trim();
            msg = et_msg.getText().toString().trim();

            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage("+94"+phone_number, null, msg, null, null);

        }
    }
}