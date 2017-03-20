package com.sample.bankshare.model;


public class User {
    private String mName, mProfileUrl, mPhoneNumber;

    public User(String name) {
        mName = name;
    }

    public User(String name, String phoneNumber) {
        mName = name;
        mPhoneNumber = phoneNumber;
    }

    public String getName() {
        return mName;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public String getProfileUrl() {
        return mProfileUrl;
    }
}
