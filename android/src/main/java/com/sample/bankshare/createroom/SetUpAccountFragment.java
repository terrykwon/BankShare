package com.sample.bankshare.createroom;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sample.bankshare.R;

public class SetUpAccountFragment extends Fragment {

    public static SetUpAccountFragment newInstance() {
        return new SetUpAccountFragment();
    }
    SharedPreferences sharedPreferences;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_up_account, container, false);
        sharedPreferences = getActivity().getSharedPreferences("PPAP", Context.MODE_PRIVATE);

        ((EditText)rootView.findViewById(R.id.edittext_set_up_room_name)).setText(sharedPreferences.getString("name","홍길동"));
        ((EditText)rootView.findViewById(R.id.et_create_room_birth)).setText(sharedPreferences.getString("birth","920327"));
        (rootView.findViewById(R.id.button_set_up_room_next)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CreateRoomActivity)getActivity()).createRoom();
            }
        });
        return rootView;
    }


}
