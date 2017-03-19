package com.sample.bankshare.main;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample.bankshare.R;
import com.sample.bankshare.model.Room;

import java.util.ArrayList;
import java.util.List;


class RoomAdapter extends RecyclerView.Adapter {

    private List<Room> mRoomList;
    private OnItemClickListener mItemClickListener;

    interface OnItemClickListener {
        void onItemClick();
    }

    RoomAdapter() {
        mRoomList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_room, parent, false);

        return new RoomHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RoomHolder) holder).bind(mRoomList.get(position), mItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mRoomList.size();
    }

    void setRoomList(List<Room> rooms) {
        mRoomList = rooms;
        notifyDataSetChanged();
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }


    private static class RoomHolder extends RecyclerView.ViewHolder {
        TextView nameText, descText;

        public RoomHolder(View itemView) {
            super(itemView);

            nameText = (TextView) itemView.findViewById(R.id.text_room_name);
            descText = (TextView) itemView.findViewById(R.id.text_room_description);

        }

        void bind(Room room, @Nullable final OnItemClickListener clickListener) {
            nameText.setText(room.getName());
            descText.setText(room.getDescription());

            if (clickListener != null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickListener.onItemClick();
                    }
                });
            }
        }
    }

}
