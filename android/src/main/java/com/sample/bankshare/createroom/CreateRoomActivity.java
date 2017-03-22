package com.sample.bankshare.createroom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.sample.bankshare.R;
import com.sample.bankshare.model.User;

import java.util.List;

/**
 * Activity for creating a new room.
 */

public class CreateRoomActivity extends AppCompatActivity
        implements SetUpRoomFragment.OnSetUpRoomListener, SelectUsersFragment.OnUsersSelectedListener {

    private String mRoomName, mRoomDescription;
    private List<User> mSelectedUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_create_room);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            Fragment fragment = SetUpRoomFragment.newInstance();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.layout_create_room_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onSetUpRoom(String roomName, String roomDescription) {
        mRoomName = roomName;
        mRoomDescription = roomDescription;
    }


    @Override
    public void onUsersSelected(List<User> users) {
        mSelectedUsers = users;

        for (User user : mSelectedUsers) {
            Log.d("CREATE_ROOM", user.getName());
        }

        createRoom();
    }

    // TODO: implement
    private void createRoom() {
        finish();
    }
}
