package com.sample.bankshare.account;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.sample.bankshare.R;
import com.sample.bankshare.util.DummyGenerator;

public class AccountActivity extends AppCompatActivity {
    private RecyclerView mTransactionRecycler;
    private TransactionAdapter mTransactionAdapter;
    private LinearLayoutManager  mTransactionLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_account);
        setSupportActionBar(toolbar);

        mTransactionRecycler = (RecyclerView) findViewById(R.id.recycler_account_transaction);
        mTransactionLayoutManager = new LinearLayoutManager(this);
        mTransactionAdapter = new TransactionAdapter();

        mTransactionRecycler.setLayoutManager(mTransactionLayoutManager);
        mTransactionRecycler.setAdapter(mTransactionAdapter);

        // Debug
        mTransactionAdapter.setTransactionList(DummyGenerator.generateDummyTransactions());
    }
}
