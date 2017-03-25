package com.sample.bankshare.server;

import com.sample.bankshare.model.Room;
import com.sample.bankshare.model.RoomContent;
import com.sample.bankshare.model.Transaction;
import com.sample.bankshare.server.result.Result;
import com.sample.bankshare.server.result.ResultShowRoomList;
import com.sample.bankshare.server.result.RoomType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jj on 26/03/2017.
 */

public class ServerEasyHandler {

    public interface OnRoomListListener {
        void onSuccess(List<Room> list);
        void onFail();
    }

    public interface OnCreateRoomListener {
        void onSuccess();
        void onFail();
    }

    public interface OnRoomContentListener {
        void onSuccess(RoomContent roomContent);
        void onFail();
    }

    public interface OnShareListener {
        void onSuccess(String share);
        void onFail();
    }

    public static void showRoomList(final OnRoomListListener listener){
        ServerConnector connector = ServerConnector.createConnector(ServerConnector.ConnectorType.ShowRoomList);
        connector.connect(new ServerConnector.OnServerConnectorListener<Result>() {
            @Override
            public void onSuccess(Result result) {
                if (result instanceof ResultShowRoomList) {
                    ResultShowRoomList resultShowRoomList = (ResultShowRoomList)result;

                    List<RoomType> roomTypeList = resultShowRoomList.roomList;
                    List<Room> roomList = new ArrayList<Room>();

                    for (RoomType roomType:
                         roomTypeList) {
                        Room room = new Room(roomType.roomName, roomType.roomLabel);
                        roomList.add(room);
                    }

                    listener.onSuccess(roomList);

                } else {
                    listener.onFail();
                }
            }

            @Override
            public void onFail() {
                listener.onFail();
            }
        });
    }



    public static void createRoom(String roomName, String roomInfo, final OnCreateRoomListener listener) {
//'roomname','roominfo','name','birth','bank','account'

        String paramString = String.format("?roomname=%s&roominfo=%s",roomName,roomInfo);

        ServerConnector connector = ServerConnector.createConnector(ServerConnector.ConnectorType.CreateRoom);
        connector.connect(paramString, new ServerConnector.OnServerConnectorListener<Result>() {
            @Override
            public void onSuccess(Result result) {
                listener.onSuccess();
            }

            @Override
            public void onFail() {
                listener.onFail();
            }
        });
    }


    public static void showRoomContent(OnRoomContentListener listener) {
        RoomContent content = new RoomContent();
        content.remain = "221400";
        List<Transaction> transactions = content.transactions = new ArrayList<>();

        transactions.add(new Transaction("SenderA", "RecipientA", 12345L, 12345L));
        transactions.add(new Transaction("SenderB", "RecipientB", 12345L, 12345L));
        transactions.add(new Transaction("SenderC", "RecipientC", 12345L, 12345L));
        transactions.add(new Transaction("SenderD", "RecipientD", 12345L, 12345L));
        transactions.add(new Transaction("SenderE", "RecipientE", 12345L, 12345L));
        transactions.add(new Transaction("SenderF", "RecipientF", 12345L, 12345L));
        transactions.add(new Transaction("SenderG", "RecipientG", 12345L, 12345L));
        transactions.add(new Transaction("SenderH", "RecipientH", 12345L, 12345L));


        listener.onSuccess(content);
    }

    public static void share(OnShareListener listener) {
        String shareText = String.format("얼마썼냐 링크입니다. %s/XndornerE",ServerConnector.SERVER_HOST);
        listener.onSuccess(shareText);
    }

}
