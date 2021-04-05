package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditAddActivity extends AppCompatActivity {
    EditText etUserName, etPhoneNumber;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_add);

        etUserName = findViewById(R.id.etUserName);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btnSave = findViewById(R.id.btnLogin);

        Intent intent = getIntent();

        boolean isCheck = intent.getBooleanExtra("check", false);

        if (isCheck) setTitle("EditActivity");
        else setTitle("AddActivity");

        etUserName.setText(intent.getStringExtra("user"));
        etPhoneNumber.setText(intent.getStringExtra("phoneNumber"));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent();

                intent1.putExtra("userEditAdd",etUserName.getText().toString());
                intent1.putExtra("phoneEditAdd",etPhoneNumber.getText().toString());

                setResult(RESULT_OK,intent1);
                finish();
            }
        });


    }
}