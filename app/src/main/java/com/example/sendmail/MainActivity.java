package com.example.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mEtEmail;
    private EditText mEtCcEmail;
    private EditText mEtSubject;
    private EditText mEtContent;
    private Button mBtnSend;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isEmailValid = isEmailValid();
                if (isEmailValid) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"murali123@gmil.com"});
                    intent.putExtra(Intent.EXTRA_CC, new String[]{"murali100@gmail.com , murali111@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, mEtSubject.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, mEtContent.getText().toString());
                    intent.setType("message/rfc822");
                    if (intent.resolveActivity(getPackageManager()) != null)
                        startActivity(intent);
                    else
                        Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initViews() {
        mEtEmail = findViewById(R.id.etEmail);
        mEtCcEmail = findViewById(R.id.etCcEmail);
        mEtSubject = findViewById(R.id.etSubject);
        mEtContent = findViewById(R.id.etContent);
        mBtnSend = findViewById(R.id.btnSend);
    }

    private boolean isEmailValid() {
        if (mEtEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mEtEmail.setError("Invalid Email");
            return false;
        }
    }

}