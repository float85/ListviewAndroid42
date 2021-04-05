package com.example.listviewdemo;

public class Contact {
    String name;
    String   phonenumber;
    int imagerAvata;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int isImagerAvata() {
        return imagerAvata;
    }

    public void setImagerAvata(int   imagerAvata) {
        this.imagerAvata = imagerAvata;
    }

    public Contact(String name, String phonenumber, int  imagerAvata) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.imagerAvata = imagerAvata;
    }
}
