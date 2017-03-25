package com.sample.bankshare.server.result;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jj on 26/03/2017.
 */

public class RoomType implements ResultReadable {

    //room_id:int, room_name:string, room_label:string

    public int roomId;
    public String roomName;
    public String roomLabel;

    @Override
    public void loadJSONObject(JSONObject object) throws JSONException {
        roomId = object.getInt("room_id");
        roomName = object.getString("room_name");
        roomLabel = object.getString("room_label");
    }
}
