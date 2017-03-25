package com.sample.bankshare.server.result;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jeonghan on 9. 27..
 */
public class Result implements ResultReadable{

    @Override
    public void loadJSONObject(JSONObject object) throws JSONException {}

    public static Result createResult(JSONObject object){
        Result result = null;
        try {
            if(object.has("roomlist")) {
                result = new ResultShowRoomList();
            } else {
                result = new Result();
            }

            if (result != null) {
                result.loadJSONObject(object);
            }

        } catch (JSONException e){
            ResultFail fail = new ResultFail();
            fail.reason = "fail to parse JSON";
            result = fail;
        }
        return result;
    }


}
