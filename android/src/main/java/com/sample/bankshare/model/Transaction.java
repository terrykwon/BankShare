package com.sample.bankshare.model;


public class Transaction {

    private String mSender,mDate;
    private long mTimestamp, mAmount;
    private int mItemType;

    public String getmSender() {
        return mSender;
    }

    public void setmSender(String mSender) {
        this.mSender = mSender;
    }

    public long getmTimestamp() {
        return mTimestamp;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public void setmTimestamp(long mTimestamp) {
        this.mTimestamp = mTimestamp;
    }

    public long getmAmount() {
        return mAmount;
    }

    public void setmAmount(long mAmount) {
        this.mAmount = mAmount;
    }

    public int getmItemType() {
        return mItemType;
    }

    public void setmItemType(int mItemType) {
        this.mItemType = mItemType;
    }

    public Transaction(String mDate, int mItemType) {
        this.mDate = mDate;
        this.mItemType = mItemType;
    }

    public Transaction(String mSender, long mTimestamp, long mAmount, int mItemType) {

        this.mSender = mSender;
        this.mTimestamp = mTimestamp;
        this.mAmount = mAmount;
        this.mItemType = mItemType;
    }

    public String getSender() {
        return mSender;
    }

    public Long getAmount() {
        return mAmount;
    }

    public Long getTimestamp() {
        return mTimestamp;
    }

}

