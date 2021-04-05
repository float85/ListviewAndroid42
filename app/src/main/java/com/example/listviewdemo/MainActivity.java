package com.example.listviewdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvContactCode;
    Contact contact, contact1, contact2, contact3, contact4;
    List<Contact> contactList;
    AdapterContact adapterContact;

    View btnAdd;
    int location = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvContactCode = findViewById(R.id.lvContact);
        btnAdd = findViewById(R.id.btnAdd);

        Intent intent = getIntent();
        String username = intent.getStringExtra("User");

        setTitle(username);

        contact = new Contact("Android 42", "0124563789", R.drawable.ic_launcher_background);
        contact1 = new Contact("Samsung", "0123456789", R.drawable.ic_launcher_background);
        contact2 = new Contact("IOS", "0123456789", R.drawable.ic_launcher_background);
        contact3 = new Contact("PHP", "0123456789", R.drawable.ic_launcher_background);
        contact4 = new Contact(".NET", "0123456789", R.drawable.ic_launcher_background);

        contactList = new ArrayList<>();
        contactList.add(contact);
        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);

        adapterContact = new AdapterContact(contactList);

        lvContactCode.setAdapter(adapterContact);

        lvContactCode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact contact = contactList.get(position);
                String _username = contact.getName();
                String phoneNumber = contact.getPhonenumber();

                location = position;

                Intent intent1 = new Intent(getBaseContext(), EditAddActivity.class);
                intent1.putExtra("user", _username);
                intent1.putExtra("phoneNumber", phoneNumber);

                intent1.putExtra("check", true);
//                startActivity(intent1);
                startActivityForResult(intent1, 113);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAdd = new Intent(getBaseContext(), EditAddActivity.class);
                startActivityForResult(intentAdd, 115);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 113) {
                String userNew = data.getStringExtra("userEditAdd");
                String phoneNew = data.getStringExtra("phoneEditAdd");

                Contact contact = new Contact(userNew, phoneNew, R.drawable.ic_baseline_add_24);

                contactList.set(location, contact);
            } else if (requestCode == 115) {
                String userNew = data.getStringExtra("userEditAdd");
                String phoneNew = data.getStringExtra("phoneEditAdd");
                Contact contact = new Contact(userNew, phoneNew, R.drawable.ic_baseline_add_24);

                contactList.add(contact);

            }
        }

    }
}