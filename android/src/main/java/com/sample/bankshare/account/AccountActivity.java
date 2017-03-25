package com.sample.bankshare.account;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sample.bankshare.R;
import com.sample.bankshare.model.RoomContent;
import com.sample.bankshare.server.ServerEasyHandler;
import com.sample.bankshare.util.DummyGenerator;

import java.util.List;

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

        ServerEasyHandler.showRoomContent(new ServerEasyHandler.OnRoomContentListener() {
            @Override
            public void onSuccess(RoomContent roomContent) {
                mTransactionAdapter.setTransactionList(roomContent.transactions);
                TextView remainTextView = (TextView)findViewById(R.id.text_account_balance);
                remainTextView.setText(roomContent.remain);
            }

            @Override
            public void onFail() {

            }
        });

        findViewById(R.id.bt_account_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ServerEasyHandler.share(new ServerEasyHandler.OnShareListener() {
                    @Override
                    public void onSuccess(String share) {
                        Context context = AccountActivity.this;
                        Toast.makeText(AccountActivity.this, "클립보드에 복사되었습니다. 붙여넣기 해주세요!",Toast.LENGTH_SHORT).show();
                        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                        android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", share);
                        clipboard.setPrimaryClip(clip);
                    }

                    @Override
                    public void onFail() {

                    }
                });
            }
        });
    }
}
