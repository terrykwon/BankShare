package com.sample.bankshare.createroom;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.sample.bankshare.R;
import com.sample.bankshare.model.User;

import java.util.ArrayList;
import java.util.List;


public class SelectableUserAdapter extends RecyclerView.Adapter {

    private List<User> mUserList;
    private static List<User> mSelectedUsers;
    private OnItemCheckedChangeListener mItemCheckedChangeListener;

    public interface OnItemCheckedChangeListener {
        void OnItemChecked(User user, boolean checked);
    }

    public SelectableUserAdapter() {
        mUserList = new ArrayList<>();
        mSelectedUsers = new ArrayList<>();
    }

    public void setItemCheckedChangeListener(OnItemCheckedChangeListener listener) {
        mItemCheckedChangeListener = listener;
    }

    public void setUserList(List<User> users) {
        mUserList = users;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_selectable_user, parent, false);

        return new SelectableUserHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SelectableUserHolder) holder).bind(
                mUserList.get(position),
                isSelected(mUserList.get(position)),
                mItemCheckedChangeListener);
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    private boolean isSelected(User user) {
        return mSelectedUsers.contains(user);
    }

    private static class SelectableUserHolder extends RecyclerView.ViewHolder {
        private TextView nameText;
        private ImageView profileImage;
        private CheckBox checkBox;

        SelectableUserHolder(View itemView) {
            super(itemView);

            nameText = (TextView) itemView.findViewById(R.id.text_selectable_user_name);
            profileImage = (ImageView) itemView.findViewById(R.id.image_selectable_user_profile);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox_selectable_user);
        }

        void bind(final User user, boolean isSelected, final OnItemCheckedChangeListener listener) {
            nameText.setText(user.getName());

            if (isSelected) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkBox.setChecked(!checkBox.isChecked());
                }
            });

            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    listener.OnItemChecked(user, isChecked);

                    if (isChecked) {
                        mSelectedUsers.add(user);
                    } else {
                        mSelectedUsers.remove(user);
                    }
                }
            });
        }
    }
}
