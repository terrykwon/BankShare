package com.sample.bankshare.server.result;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jeonghan on 2015. 9. 29..
 */
public class ResultFail extends Result {
    public String reason = "";

    @Override
    public void loadJSONObject(JSONObject object) throws JSONException {
        super.loadJSONObject(object);
        reason = object.getString("REASON");
    }

    public static ResultFail failWith(String reason){
        ResultFail result = new ResultFail();
        result.reason = reason;
        return result;
    }

}
