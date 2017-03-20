package com.sample.bankshare.account;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.sample.bankshare.R;
import com.sample.bankshare.util.DummyGenerator;

public class AccountActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private RecyclerView mUserRecycler, mAccountRecycler;
    private UserAdapter mUserAdapter;
    private LinearLayoutManager mUserLayoutManager, mAccountLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_account);
        setSupportActionBar(toolbar);

        mUserRecycler = (RecyclerView) findViewById(R.id.recycler_account_drawer_members);
        mUserAdapter = new UserAdapter();
        mUserLayoutManager = new LinearLayoutManager(this);

        mUserRecycler.setLayoutManager(mUserLayoutManager);
        mUserRecycler.setAdapter(mUserAdapter);

        // Debug
        mUserAdapter.setUserList(DummyGenerator.generateDummyUsers());
    }
}
