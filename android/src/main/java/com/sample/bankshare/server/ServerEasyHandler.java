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
        content.remain = "632,439";
        List<Transaction> transactions = content.transactions = new ArrayList<>();


        /*
2017.03.23	출금	1	632438
2017.03.23	입금	1	632439
2017.03.20	입금	7000	632439
2017.03.17	입금	10	576439
2017.03.17	입금	7000	583439
2017.03.17	입금	7000	590439
2017.03.17	입금	7000	597439
2017.03.17	입금	7000	604439
2017.03.17	입금	7000	611439
2017.03.17	입금	7000	618439
2017.03.17	입금	7000	625439
2017.03.16	입금	100	576429
2017.03.07	입금	200000	576249
2017.03.07	입금	100	576349
2017.03.07	출금	10	576339
2017.03.07	출금	10	576329
2017.03.03	출금	10	173559
2017.03.03	입금	10	173569
        *
        * */

        transactions.add(new Transaction("2017.03.23", TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("출금", 1, 1, TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("입금", 1, 1, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("2017.03.20", TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("입금", 7000, 7000, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("2017.03.17", TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("입금", 10, 10, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("입금", 7000, 7000, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("입금", 7000, 7000, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("입금", 7000, 7000, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("입금", 7000, 7000, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("입금", 7000, 7000, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("입금", 7000, 7000, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("입금", 7000, 7000, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("2017.03.16", TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("입금", 100, 100, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("2017.03.07", TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("입금", 200000, 200000, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("입금", 100, 100, TransactionAdapter.TRANSACTION_PLUS));
        transactions.add(new Transaction("출금", 10, 10, TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("출금", 10, 10, TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("2017.03.03", TransactionAdapter.TRANSACTION_DATE));
        transactions.add(new Transaction("출금", 10, 10, TransactionAdapter.TRANSACTION_MINUS));
        transactions.add(new Transaction("입금", 10, 10, TransactionAdapter.TRANSACTION_PLUS));


        listener.onSuccess(content);
    }

    public static void share(OnShareListener listener) {
        String shareText = String.format("얼마썼냐 링크입니다. %s/myaccount/XndornerE",ServerConnector.SERVER_HOST);
        listener.onSuccess(shareText);
    }

}
