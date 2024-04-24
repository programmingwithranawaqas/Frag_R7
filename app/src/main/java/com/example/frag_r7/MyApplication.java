package com.example.frag_r7;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {
    public static ArrayList<Contact> contacts;

    @Override
    public void onCreate() {
        super.onCreate();
        contacts = new ArrayList<>();
        contacts.add(new Contact("Ali Raza", "Wapda Town", "https://www.google.com", "04235971122"));
        contacts.add(new Contact("Mahmood Hassan", "Link Road Model Town", "https://www.ucp.edu.pk", "04235972233"));
        contacts.add(new Contact("Jawad Ghauri", "Gujranwala", "https://www.yahoo.com", "04235972211"));
    }
}
