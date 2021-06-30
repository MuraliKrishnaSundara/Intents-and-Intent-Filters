package com.example.opencustomactivityfromappselectorscreen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mBtnSend;
    private EditText mEtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnSend = findViewById(R.id.btnSend);
        mEtName = findViewById(R.id.etName);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.murali.myownaction");
                intent.setType("plain/text");
                intent.putExtra("key", mEtName.getText().toString());

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> list = packageManager.queryIntentActivities(intent,0);
                if (list != null && list.size() >= 1){
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this,"No apps found to open intent" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}