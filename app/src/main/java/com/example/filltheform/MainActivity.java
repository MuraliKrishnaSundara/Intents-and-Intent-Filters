package com.example.filltheform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEtOrgName;
    private EditText mEtName;
    private EditText mEtMobileNumber;
    private EditText mEtEmail;
    private EditText mEtAddress;
    private EditText mEtManufactureName;
    private EditText mEtTaxID;
    private EditText mEtCompanyID;
    private Button mBtnCheck;
    private String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mBtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isMobileNumberValid = isMobileNumberValid();
                boolean isEmailValid = isEmailValid();
                if (isEmailValid && isMobileNumberValid) {
                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                    intent.putExtra("orgName", mEtOrgName.getText().toString());
                    intent.putExtra("name", mEtName.getText().toString());
                    intent.putExtra("mobileNumber", mEtMobileNumber.getText().toString());
                    intent.putExtra("email", mEtEmail.getText().toString());
                    intent.putExtra("address", mEtAddress.getText().toString());
                    intent.putExtra("manufactureName", mEtManufactureName.getText().toString());
                    intent.putExtra("taxID", mEtTaxID.getText().toString());
                    intent.putExtra("companyID", mEtCompanyID.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private void initViews() {
        mEtOrgName = findViewById(R.id.etOrganizationName);
        mEtName = findViewById(R.id.etName);
        mEtMobileNumber = findViewById(R.id.etMobileNumber);
        mEtEmail = findViewById(R.id.etEmail);
        mEtAddress = findViewById(R.id.etAddress);
        mEtManufactureName = findViewById(R.id.etManufacturer);
        mEtTaxID = findViewById(R.id.etTax);
        mEtCompanyID = findViewById(R.id.etCompany);
        mBtnCheck = findViewById(R.id.btnCheck);
    }

    private boolean isEmailValid() {
        if (mEtEmail.getText().toString().matches(emailValidation)) {
            return true;
        } else {
            mEtEmail.setError("Invalid Email");
            return false;
        }
    }

    private boolean isMobileNumberValid() {
        if (mEtMobileNumber.getText().toString().length() == 10) {
            return true;
        } else {
            mEtMobileNumber.setError("Enter valid Mobile Number");
            return false;
        }
    }
}