package com.sample.bankshare.createroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.sample.bankshare.R;

public class CreateRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_create_room);
        setSupportActionBar(toolbar);


    }
}
