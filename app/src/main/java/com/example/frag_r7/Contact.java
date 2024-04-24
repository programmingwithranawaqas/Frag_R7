package com.example.frag_r7;

public class Contact {
    private String name, location, url, phone;

    public Contact() {
    }

    public Contact(String name, String location, String url, String phone) {
        this.name = name;
        this.location = location;
        this.url = url;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
