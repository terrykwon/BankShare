package com.sample.bankshare;

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

}
