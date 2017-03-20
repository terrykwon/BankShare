package com.sample.bankshare.account;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample.bankshare.R;
import com.sample.bankshare.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter{

    private List<Transaction> mTransactionList;

    TransactionAdapter() {
        mTransactionList = new ArrayList<>();
    }

    void setTransactionList(List<Transaction> transactions) {
        mTransactionList = transactions;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaction, parent, false);

        return new TransactionHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TransactionHolder) holder).bind(mTransactionList.get(position));
    }

    @Override
    public int getItemCount() {
        return mTransactionList.size();
    }

    private static class TransactionHolder extends RecyclerView.ViewHolder {
        private TextView dateText, senderText, amountText;

        TransactionHolder(View itemView) {
            super(itemView);

            dateText = (TextView) itemView.findViewById(R.id.text_transaction_date);
            senderText = (TextView) itemView.findViewById(R.id.text_transaction_sender);
            amountText = (TextView) itemView.findViewById(R.id.text_transaction_amount);
        }

        void bind(Transaction transaction) {
            dateText.setText(String.valueOf(transaction.getTimestamp()));
            senderText.setText(transaction.getSender());
            amountText.setText(String.valueOf(transaction.getAmount()));
        }
    }
}
