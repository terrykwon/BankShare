package com.sample.bankshare.server;

import android.os.AsyncTask;
import android.util.Log;

import com.sample.bankshare.server.result.Result;
import com.sample.bankshare.server.result.ResultFail;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jj on 26/03/2017.
 */

public abstract class ServerConnector {

    protected static String SERVER_HOST = "http://10.10.55.239:7000";
    private static boolean TEST = true;

    public static enum ConnectorType {
        ShowRoomList,
        CreateRoom,
        ShowRoomContent,
        Share
    }

    public static interface OnServerConnectorListener<T extends Result> {
        public void onSuccess(T result);
        public void onFail();
    }

    public ServerDialog dialog = null;

    public static ServerConnector createConnector(ConnectorType type){
        ServerConnector connector;
        switch (type) {
            case ShowRoomList:
                connector = new ServerConnectorShowRoomList();
                break;
            case CreateRoom:
                connector = new ServerConnectorCreateRoom();
                break;
            case ShowRoomContent:
                connector = new ServerConnectorShowRoomContent();
                break;
            case Share:
            default:
                connector = new ServerConnectorShare();
        }
        return connector;
    }


    public void connect(OnServerConnectorListener<?> listener) {
        connect(null, listener);
    }

    public void connect(String paramString, OnServerConnectorListener<?> listener) {
        if (dialog != null) dialog.show();
        try {
            doSendCall(paramString,listener);
        } catch (Exception e) {
            //parameter error;
        }
        finally {
            if (dialog != null) dialog.dismiss();
        }
    }

    protected abstract String getServerURLString();

    private boolean isNetworkEnabled(){
        return true;
    }

    private void doSendCall(final String param, final OnServerConnectorListener listener){
        if(!isNetworkEnabled()){
            listener.onFail();
            return;
        }

        final String serverURL = getServerURLString();
        final String postParam = param;

        AsyncTask<Void,Void,Result> task = new AsyncTask<Void, Void, Result>() {

            private void setHttpDefault(HttpURLConnection http){
                http.setDefaultUseCaches(false);
                http.setConnectTimeout(50000);
                http.setReadTimeout(50000);
                http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            }

            @Override
            protected Result doInBackground(Void... params) {
                try {
                    String urlString = postParam == null ? serverURL : serverURL+postParam;

                    URL url = new URL(urlString);

                    HttpURLConnection http = (HttpURLConnection) url.openConnection();
                    setHttpDefault(http);
                    InputStream is = http.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is,"UTF-8");
                    BufferedReader reader = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder();
                    String str;
                    while ((str = reader.readLine()) != null){
                        sb.append(str);
                    }
                    reader.close();
                    isr.close();

                    if (TEST){
                        Log.i("ServerConnector("+ServerConnector.this.getClass().toString()+")",sb.toString());
                    }

                    JSONObject object = new JSONObject(sb.toString());
                    return Result.createResult(object);

                } catch (Exception e) {
                    return ResultFail.failWith(e.toString());
                }
            }

            @Override
            protected void onPostExecute(Result result) {
                if (result != null){
                    listener.onSuccess(result);
                }else{
                    if (result instanceof ResultFail){
                        listener.onFail();
                    }
                }
            }
        };

        task.execute();
    }

}
