package com.sample.bankshare.server;


/**
 * Created by jj on 26/03/2017.
 */

class ServerConnectorShowRoomList extends ServerConnector {
    @Override
    protected String getServerURLString() {
        return SERVER_HOST+"/main";
    }

}
