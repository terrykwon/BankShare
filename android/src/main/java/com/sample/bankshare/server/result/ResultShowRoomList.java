package com.sample.bankshare.server.result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jj on 26/03/2017.
 */

public class ResultShowRoomList extends Result {

    public List<RoomType> roomList;

    @Override
    public void loadJSONObject(JSONObject object) throws JSONException {
        super.loadJSONObject(object);
        roomList = new ArrayList<>();
        JSONArray array = object.getJSONArray("roomlist");
        int length = array.length();
        for (int i = 0; i < length; i++) {
            JSONObject element = array.getJSONObject(i);
            RoomType roomType = new RoomType();
            roomType.loadJSONObject(element);
            roomList.add(roomType);
        }
    }
}
