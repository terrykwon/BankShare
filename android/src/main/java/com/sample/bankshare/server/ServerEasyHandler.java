package com.sample.bankshare.server;

import com.sample.bankshare.account.TransactionAdapter;
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

        transactions.add(new Transaction("2017. 03. 25", TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("SenderA", 300000L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderB", 12345L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderC",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("2017. 03. 24",TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("SenderD",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("SenderE", 12345L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderF",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("SenderG",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("2017. 03. 23",TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("SenderA", 12345L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderB", 12345L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderC",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("SenderD",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("SenderE", 12345L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderF",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("SenderG",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("2017. 03. 22",TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("SenderE", 12345L, 12345L, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("SenderF",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("SenderG",  12345L, 12345L,TransactionAdapter.TRANSACTION_MINUS));


        listener.onSuccess(content);
    }

    public static void share(OnShareListener listener) {
        String shareText = String.format("얼마썼냐 링크입니다. %s/XndornerE",ServerConnector.SERVER_HOST);
        listener.onSuccess(shareText);
    }

}