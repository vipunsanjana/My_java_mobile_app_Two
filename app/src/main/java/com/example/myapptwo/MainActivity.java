package com.example.myapptwo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_SMS;
    private Button btn_Call;
    private Button btn_Email;
    private Button btn_Share;
    private Button btn_WebView;

    private ImageView iv_lan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_SMS = findViewById(R.id.btn_SMS);
        btn_Call = findViewById(R.id.btn_Call);
        btn_Email = findViewById(R.id.btn_Email);
        btn_Share = findViewById(R.id.btn_Share);
        btn_WebView = findViewById(R.id.btn_WebView);
        iv_lan = findViewById(R.id.iv_lan);

        btn_SMS.setOnClickListener(this);
        btn_Call.setOnClickListener(this);
        btn_Email.setOnClickListener(this);
        btn_Share.setOnClickListener(this);
        btn_WebView.setOnClickListener(this);
        iv_lan.setOnClickListener(this);

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
            Intent intentWeb = new Intent(getApplicationContext(), WebViewActivity.class);
            startActivity(intentWeb);
        } else if (id == R.id.iv_lan) {

            String[] lang = {"English", "සිංහල"};

            AlertDialog.Builder m_builder = new AlertDialog.Builder(MainActivity.this);
            m_builder.setTitle("Choose Language...");
            m_builder.setSingleChoiceItems(lang, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int position) {

                    if(position == 0){

                        setLocal("en");
                        recreate();
                    } else if (position == 1) {
                        
                        setLocal("si");
                        recreate();
                    }
                }
            });

            AlertDialog dialog = m_builder.create();
            dialog.show();
        }
    }

    private void setLocal(String lang) {

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
    }
}