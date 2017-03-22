package com.sample.bankshare.account;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sample.bankshare.R;
import com.sample.bankshare.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserAdapter extends RecyclerView.Adapter {

    private List<User> mUserList;

    UserAdapter() {
        mUserList = new ArrayList<>();
    }

    void setUserList(List<User> users) {
        mUserList = users;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);

        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((UserHolder) holder).bind(mUserList.get(position));
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }


    private static class UserHolder extends RecyclerView.ViewHolder{
        private TextView nameText;
        private ImageView profileImage;

        UserHolder(View itemView) {
            super(itemView);

            nameText = (TextView) itemView.findViewById(R.id.text_user_name);
            profileImage = (ImageView) itemView.findViewById(R.id.image_user_profile);
        }

        void bind(User user) {
            nameText.setText(user.getName());
        }
    }
}
