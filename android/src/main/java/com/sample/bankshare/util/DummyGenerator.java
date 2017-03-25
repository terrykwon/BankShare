package com.sample.bankshare.util;

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

        transactions.add(new Transaction("SenderA", "RecipientA", 12345L, 12345L));
        transactions.add(new Transaction("SenderB", "RecipientB", 12345L, 12345L));
        transactions.add(new Transaction("SenderC", "RecipientC", 12345L, 12345L));
        transactions.add(new Transaction("SenderD", "RecipientD", 12345L, 12345L));
        transactions.add(new Transaction("SenderE", "RecipientE", 12345L, 12345L));
        transactions.add(new Transaction("SenderF", "RecipientF", 12345L, 12345L));
        transactions.add(new Transaction("SenderG", "RecipientG", 12345L, 12345L));
        transactions.add(new Transaction("SenderH", "RecipientH", 12345L, 12345L));

        return transactions;
    }


}
