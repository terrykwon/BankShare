package com.sample.bankshare.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.sample.bankshare.R;
import com.sample.bankshare.util.DummyGenerator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRoomRecycler;
    private RoomAdapter mRoomAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        mRoomRecycler = (RecyclerView) findViewById(R.id.recycler_main_rooms);
        mLayoutManager = new LinearLayoutManager(this);
        mRoomAdapter = new RoomAdapter();

        mRoomRecycler.setLayoutManager(mLayoutManager);
        mRoomRecycler.setAdapter(mRoomAdapter);

        // Debug
        mRoomAdapter.setRoomList(DummyGenerator.generateDummyRooms());
    }
}
