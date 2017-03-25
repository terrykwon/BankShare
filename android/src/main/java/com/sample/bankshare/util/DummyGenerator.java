package com.sample.bankshare.util;

import com.sample.bankshare.account.TransactionAdapter;
import com.sample.bankshare.model.Room;
import com.sample.bankshare.model.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Util class for generating dummy data.
 */

public class DummyGenerator {

    // Prevent instantiation
    private DummyGenerator() {

    }

    public static List<Room> generateDummyRooms() {
        List<Room> rooms = new ArrayList<>();

        rooms.add(new Room("RoomA", "This is room A"));
        rooms.add(new Room("RoomB", "This is room B"));
        rooms.add(new Room("RoomC", "This is room C"));
        rooms.add(new Room("RoomD", "This is room D"));
        rooms.add(new Room("RoomE", "This is room E"));

        return rooms;
    }


    public static List<Transaction> generateDummyTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("2017. 03. 25", TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("SenderA", 300000L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderB", 12345L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderC",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("2017. 03. 24",TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("SenderD",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("SenderE", 12345L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderF",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("SenderG",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("2017. 03. 23",TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("SenderA", 12345L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderB", 12345L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderC",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("SenderD",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("SenderE", 12345L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderF",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("SenderG",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("2017. 03. 22",TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("SenderE", 12345L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderF",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("SenderG",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        return transactions;
    }


}
