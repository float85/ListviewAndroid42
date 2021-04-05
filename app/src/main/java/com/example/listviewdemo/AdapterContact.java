package com.example.listviewdemo;

import android.companion.WifiDeviceFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterContact extends BaseAdapter {
    List<Contact> contactList;

    public AdapterContact(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_caontact, parent, false);

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvPhoneNumber = view.findViewById(R.id.tvPhoneNumber);
        ImageView imgAvata = view.findViewById(R.id.imgAvata);

        Contact contact = contactList.get(position);

        tvName.setText(contact.getName());
        tvPhoneNumber.setText(contact.getPhonenumber());

        imgAvata.setImageResource(contact.imagerAvata);

//        if (contact.isImagerAvata()) imgAvata.setVisibility(View.VISIBLE);
//        else imgAvata.setVisibility(View.GONE);

        return view;
    }
}
