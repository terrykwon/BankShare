package com.sample.bankshare.createroom;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.bankshare.R;

public class SetUpAccountFragment extends Fragment {

    public static SetUpAccountFragment newInstance() {
        return new SetUpAccountFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_up_account, container, false);
        (rootView.findViewById(R.id.button_set_up_room_next)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CreateRoomActivity)getActivity()).createRoom();
            }
        });
        return rootView;
    }


}
