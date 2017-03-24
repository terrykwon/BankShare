package com.sample.bankshare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sample.bankshare.createroom.SelectableUserAdapter;
import com.sample.bankshare.model.User;
import com.sample.bankshare.util.DummyGenerator;

import java.util.ArrayList;
import java.util.List;


public class SelectUserActivity extends AppCompatActivity {

    private Button mInviteButton;
    private RecyclerView mUserRecycler;
    private SelectableUserAdapter mUserAdapter;
    private LinearLayoutManager mUserLayoutManager;

    private List<User> mSelectedUsers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        mSelectedUsers = new ArrayList<>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_select_user);
        setSupportActionBar(toolbar);

        mInviteButton = (Button) findViewById(R.id.button_select_user_invite);
        mUserRecycler = (RecyclerView) findViewById(R.id.recycler_select_user);
        mUserAdapter = new SelectableUserAdapter();
        mUserLayoutManager = new LinearLayoutManager(this);

        mUserRecycler.setAdapter(mUserAdapter);
        mUserRecycler.setLayoutManager(mUserLayoutManager);

        mUserAdapter.setItemCheckedChangeListener(new SelectableUserAdapter.OnItemCheckedChangeListener() {
            @Override
            public void OnItemChecked(User user, boolean checked) {
                if (checked) {
                    mSelectedUsers.add(user);
                } else {
                    mSelectedUsers.remove(user);
                }
            }
        });

        mUserAdapter.setUserList(DummyGenerator.generateDummyUsers());

        mInviteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invite();
            }
        });
    }

    //TODO: implement
    private void invite() {
        Toast.makeText(this, "Invite button clicked", Toast.LENGTH_SHORT).show();
    }

}
