package com.example.myapptwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendEmail extends AppCompatActivity implements View.OnClickListener {

    private EditText et_to;
    private EditText et_subject;
    private EditText et_msg;
    private Button btn_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        et_to = findViewById(R.id.et_to);
        et_subject = findViewById(R.id.et_sub);
        et_msg = findViewById(R.id.et_msg);
        btn_email = findViewById(R.id.btn_mail);





        btn_email.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        String to = et_to.getText().toString().trim();
        String subject = et_subject.getText().toString().trim();
        String message = et_msg.getText().toString().trim();

        if (id == R.id.btn_mail) {

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("message/rfc822");
            emailIntent.putExtra(Intent.EXTRA_EMAIL , new String[]{to});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            emailIntent.putExtra(Intent.EXTRA_TEXT , message);
            try {
                startActivity(Intent.createChooser(emailIntent, "Done!"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(SendEmail.this, "No Email client found!!",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}