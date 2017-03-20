package com.sample.bankshare.util;

import com.sample.bankshare.model.Room;
import com.sample.bankshare.model.User;

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

    public static List<User> generateDummyUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("User1", "010-1234-1234"));
        users.add(new User("User2", "010-2345-2345"));
        users.add(new User("User3", "010-3456-3456"));
        users.add(new User("User4", "010-4567-4567"));
        users.add(new User("User5", "010-5678-5678"));

        return users;
    }

}
