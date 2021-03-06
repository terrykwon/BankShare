package com.sample.bankshare.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.sample.bankshare.R;
import com.sample.bankshare.account.AccountActivity;
import com.sample.bankshare.createroom.CreateRoomActivity;
import com.sample.bankshare.model.Room;
import com.sample.bankshare.server.ServerEasyHandler;
import com.sample.bankshare.util.DummyGenerator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRoomRecycler;
    private RoomAdapter mRoomAdapter;
    private LinearLayoutManager mLayoutManager;
    private FloatingActionButton mCreateRoomFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        serverDebug();

        mCreateRoomFab = (FloatingActionButton) findViewById(R.id.fab_main_create_room);

        // Set up toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        mRoomRecycler = (RecyclerView) findViewById(R.id.recycler_main_rooms);
        mLayoutManager = new LinearLayoutManager(this);
        mRoomAdapter = new RoomAdapter();
        mRoomAdapter.setOnItemClickListener(new RoomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick() {
                Intent intent = new Intent(MainActivity.this, AccountActivity.class);
                startActivity(intent);
            }
        });

        mRoomRecycler.setLayoutManager(mLayoutManager);
        mRoomRecycler.setAdapter(mRoomAdapter);

        mCreateRoomFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateRoomActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        refreshRoomList();
    }

    private void refreshRoomList() {
        ServerEasyHandler.showRoomList(new ServerEasyHandler.OnRoomListListener() {
            @Override
            public void onSuccess(List<Room> list) {
                mRoomAdapter.setRoomList(list);
            }

            @Override
            public void onFail() {

            }
        });
    }


}
