package com.example.nicklin.activitychangedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int CHECK = 1;
    public static final int RESULT = 2;

    private EditText etAccount;
    private EditText etPassword;
    private Button btnEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initComponment();
        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etAccount.getText().toString().length() > 0 && etPassword.getText().toString().length() > 0) {
                    Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("account", etAccount.getText().toString());
                    bundle.putString("password", etPassword.getText().toString());
                    intent.putExtras(bundle);
                    startActivityForResult(intent, CHECK);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter account and password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initComponment() {
        etAccount = (EditText) findViewById(R.id.etAccount);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnEnter = (Button) findViewById(R.id.btnEnter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CHECK && resultCode == RESULT) {
            Toast.makeText(MainActivity.this, "Authenticate OK!", Toast.LENGTH_LONG).show();
        }
    }
}
