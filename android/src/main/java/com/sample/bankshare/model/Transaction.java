package com.sample.bankshare.model;


public class Transaction {

    private String mSender, mRecipient;
    private long mTimestamp, mAmount;

    public Transaction(String sender, String recipient, long amount, long timestamp) {
        mSender = sender;
        mRecipient = recipient;
        mAmount = amount;
        mTimestamp = timestamp;
    }

    public String getSender() {
        return mSender;
    }

    public String getRecipient() {
        return mRecipient;
    }

    public Long getAmount() {
        return mAmount;
    }

    public Long getTimestamp() {
        return mTimestamp;
    }

}

