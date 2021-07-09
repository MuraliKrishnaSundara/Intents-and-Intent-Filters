package com.example.filltheform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    private EditText mEtOrgName;
    private EditText mEtName;
    private EditText mEtMobileNumber;
    private EditText mEtEmail;
    private EditText mEtAddress;
    private EditText mEtManufactureName;
    private EditText mEtTaxID;
    private EditText mEtCompanyID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        initViews();
        Intent intent = getIntent();
        String orgName = intent.getStringExtra("orgName");
        mEtOrgName.setText(orgName);
        String name = intent.getStringExtra("name");
        mEtName.setText(name);
        String mobileNumber = intent.getStringExtra("mobileNumber");
        mEtMobileNumber.setText(mobileNumber);
        String email = intent.getStringExtra("email");
        mEtEmail.setText(email);
        String address = intent.getStringExtra("address");
        mEtAddress.setText(address);
        String manufactureName = intent.getStringExtra("manufactureName");
        mEtManufactureName.setText(manufactureName);
        String taxID = intent.getStringExtra("taxID");
        mEtTaxID.setText(taxID);
        String companyID = intent.getStringExtra("companyID");
        mEtCompanyID.setText(companyID);
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
    }
}