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

public class SetUpRoomFragment extends Fragment {
    private EditText mNameEditText, mDescEditText;
    private Button mNextButton;
    private OnSetUpRoomListener mSetUpRoomListener;

    interface OnSetUpRoomListener {
        void onSetUpRoom(String roomName, String roomDescription);
    }

    public static SetUpRoomFragment newInstance() {
        return new SetUpRoomFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_set_up_room, container, false);

        mNameEditText = (EditText) rootView.findViewById(R.id.edittext_set_up_room_name);
        mDescEditText = (EditText) rootView.findViewById(R.id.edittext_set_up_room_description);
        mNextButton = (Button) rootView.findViewById(R.id.button_set_up_room_next);

        mSetUpRoomListener = (OnSetUpRoomListener) getActivity();

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEditText.getText().toString();
                String description = mDescEditText.getText().toString();

                mSetUpRoomListener.onSetUpRoom(name, description);

                Fragment fragment = SetUpAccountFragment.newInstance();
                getFragmentManager().beginTransaction()
                        .replace(R.id.layout_create_room_container, fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }
}
