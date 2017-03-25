package com.sample.bankshare.account;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample.bankshare.R;
import com.sample.bankshare.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter {
    public static final int TRANSACTION_PLUS = 1;
    public static final int TRANSACTION_DATE = 0;
    public static final int TRANSACTION_MINUS = 2;

    private List<Transaction> mTransactionList;

    TransactionAdapter() {
        mTransactionList = new ArrayList<>();
    }

    void setTransactionList(List<Transaction> transactions) {
        mTransactionList = transactions;
        notifyDataSetChanged();
    }
    //테스트 커밋

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;


        switch (viewType) {

            case TRANSACTION_DATE:
                view = inflater.inflate(R.layout.item_transaction_title, parent, false);
                DateViewHolder dateViewHolder = new DateViewHolder(view);
                return dateViewHolder;

            case TRANSACTION_PLUS:
                view = inflater.inflate(R.layout.item_transaction_plus, parent, false);
                PlusViewHolder plusViewHolder = new PlusViewHolder(view);
                return plusViewHolder;


            case TRANSACTION_MINUS:
                view = inflater.inflate(R.layout.item_transaction_minus, parent, false);
                MinusViewHolder minusViewHolder = new MinusViewHolder(view);
                return minusViewHolder;

        }


        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Transaction item = mTransactionList.get(position);
        switch (item.getmItemType()) {
            case TRANSACTION_PLUS:
                PlusViewHolder plusViewHolder = (PlusViewHolder) holder;
                plusViewHolder.tvPlusAmount.setText(item.getmAmount() + "");
                plusViewHolder.tvPlusSender.setText(item.getmSender());
                break;

            case TRANSACTION_DATE:
                DateViewHolder dateViewHolder = (DateViewHolder) holder;
                dateViewHolder.tvItemDate.setText(item.getmDate());
                break;

            case TRANSACTION_MINUS:
                MinusViewHolder minusViewHolder = (MinusViewHolder) holder;
                minusViewHolder.tvMinusAmount.setText(item.getmAmount() + "");
                minusViewHolder.tvMinusSender.setText(item.getmSender());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mTransactionList.get(position).getmItemType();
    }

    @Override
    public int getItemCount() {
        return mTransactionList.size();
    }

    private static class DateViewHolder extends RecyclerView.ViewHolder {
        public TextView tvItemDate;

        public DateViewHolder(View itemView) {
            super(itemView);
            tvItemDate = (TextView) itemView.findViewById(R.id.text_transaction_date);
        }
    }

    private static class PlusViewHolder extends RecyclerView.ViewHolder {
        public TextView tvPlusAmount, tvPlusSender;

        public PlusViewHolder(View itemView) {
            super(itemView);
            tvPlusAmount = (TextView) itemView.findViewById(R.id.text_transaction_plus_amount);
            tvPlusSender = (TextView) itemView.findViewById(R.id.text_transaction_plus_sender);

        }
    }

    private static class MinusViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMinusAmount, tvMinusSender;

        public MinusViewHolder(View itemView) {
            super(itemView);
            tvMinusAmount = (TextView) itemView.findViewById(R.id.text_transaction_minus_amount);
            tvMinusSender = (TextView) itemView.findViewById(R.id.text_transaction_minus_sender);

        }
    }
}
