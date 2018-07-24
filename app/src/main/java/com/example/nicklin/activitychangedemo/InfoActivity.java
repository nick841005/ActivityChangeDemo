package com.example.nicklin.activitychangedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    private static final int RESULT = 2;

    private TextView tvShowAccount;
    private TextView tvShowPassword;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initComponment();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bundle bundle = getIntent().getExtras();
        tvShowAccount.setText(bundle.getString("account"));
        tvShowPassword.setText(bundle.getString("password"));
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT, getIntent());
                finish();
            }
        });
    }

    private void initComponment() {
        tvShowAccount = (TextView) findViewById(R.id.tvShowAccount);
        tvShowPassword = (TextView) findViewById(R.id.tvShowPassword);
        btnBack = (Button) findViewById(R.id.btnBack);
    }
}
