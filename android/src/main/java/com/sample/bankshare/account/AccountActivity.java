package com.sample.bankshare.account;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

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
        ((ImageView)findViewById(R.id.iv_account_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // Debug
        mTransactionAdapter.setTransactionList(DummyGenerator.generateDummyTransactions());
    }
}
