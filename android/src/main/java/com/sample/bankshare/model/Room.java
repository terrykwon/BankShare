package com.sample.bankshare.model;


import android.support.annotation.NonNull;

public class Room {
    private String mName, mDescription;

    public Room(@NonNull String title) {
        mName = title;
    }

    public Room(@NonNull String title, @NonNull String description) {
        this(title);
        mDescription = description;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
