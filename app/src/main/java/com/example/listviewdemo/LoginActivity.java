package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etUserName, etPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = findViewById(R.id.etUserName);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUserName.getText().toString().equals("") ||
                        etPass.getText().toString().equals("")
                ) {
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.login_error),
                            Toast.LENGTH_LONG).show();
                } else {
                    //Chuyển activity
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    String username = etUserName.getText().toString();
                    intent.putExtra("User", username);
                    startActivity(intent);
                }


            }
        });

    }


}