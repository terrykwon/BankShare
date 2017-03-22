package com.sample.bankshare.createroom;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sample.bankshare.R;

/**
 * Fragment for setting room title and description.
 */

public class CreateRoomFragment extends Fragment {
    private EditText mNameEditText, mDescEditText;
    private Button mNextButton;

    public static CreateRoomFragment newInstance() {
        return new CreateRoomFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_room, container, false);

        mNameEditText = (EditText) rootView.findViewById(R.id.edittext_create_room_name);
        mDescEditText = (EditText) rootView.findViewById(R.id.edittext_create_room_description);
        mNextButton = (Button) rootView.findViewById(R.id.button_create_room_next);

        return rootView;
    }
}
