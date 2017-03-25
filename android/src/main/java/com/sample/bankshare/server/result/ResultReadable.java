package com.sample.bankshare.server.result;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jeonghan on 9. 29..
 */
public interface ResultReadable {
    public void loadJSONObject(JSONObject object) throws JSONException;
}
