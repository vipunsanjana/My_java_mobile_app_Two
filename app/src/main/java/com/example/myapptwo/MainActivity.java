package com.example.myapptwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_SMS;
    private Button btn_Call;
    private Button btn_Email;
    private Button btn_Share;
    private Button btn_WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_SMS = findViewById(R.id.btn_SMS);
        btn_Call = findViewById(R.id.btn_Call);
        btn_Email = findViewById(R.id.btn_Email);
        btn_Share = findViewById(R.id.btn_Share);
        btn_WebView = findViewById(R.id.btn_WebView);

        btn_SMS.setOnClickListener(this);
        btn_Call.setOnClickListener(this);
        btn_Email.setOnClickListener(this);
        btn_Share.setOnClickListener(this);
        btn_WebView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (id == R.id.btn_SMS) {
            Intent intentSMS = new Intent(getApplicationContext(), SendSMS.class);
            startActivity(intentSMS);
        } else if (id == R.id.btn_Call) {
            Intent intentCall = new Intent(getApplicationContext(), SendCall.class);
            startActivity(intentCall);
        } else if (id == R.id.btn_Email) {
            Intent intentEmail = new Intent(getApplicationContext(), SendEmail.class);
            startActivity(intentEmail);
        } else if (id == R.id.btn_Share) {
            Intent intentShare = new Intent(getApplicationContext(), OpenShare.class);
            startActivity(intentShare);
        } else if (id == R.id.btn_WebView) {
            Intent intentWeb = new Intent(getApplicationContext(), WebView.class);
            startActivity(intentWeb);
        }
    }
}