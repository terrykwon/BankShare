//package com.sample.bankshare.createroom;
//
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//
//import com.sample.bankshare.R;
//import com.sample.bankshare.model.User;
//import com.sample.bankshare.util.DummyGenerator;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SelectUsersFragment extends Fragment {
//
//    private Button mCreateButton;
//    private RecyclerView mUserRecycler;
//    private SelectableUserAdapter mUserAdapter;
//    private LinearLayoutManager mUserLayoutManager;
//
//    private List<User> mSelectedUsers;
//    private OnUsersSelectedListener mUsersSelectedListener;
//
//    interface OnUsersSelectedListener {
//        void onUsersSelected(List<User> users);
//    }
//
//
//    public static SelectUsersFragment newInstance() {
//        return new SelectUsersFragment();
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_select_users, container, false);
//
//        mSelectedUsers = new ArrayList<>();
//        mUsersSelectedListener = (OnUsersSelectedListener) getActivity();
//
//        mCreateButton = (Button) rootView.findViewById(R.id.button_select_users_create);
//
//        mUserRecycler = (RecyclerView) rootView.findViewById(R.id.recycler_select_users);
//        mUserAdapter = new SelectableUserAdapter();
//        mUserLayoutManager = new LinearLayoutManager(getActivity());
//
//        mUserRecycler.setAdapter(mUserAdapter);
//        mUserRecycler.setLayoutManager(mUserLayoutManager);
//
//        mUserAdapter.setItemCheckedChangeListener(new SelectableUserAdapter.OnItemCheckedChangeListener() {
//            @Override
//            public void OnItemChecked(User user, boolean checked) {
//                if (checked) {
//                    mSelectedUsers.add(user);
//                } else {
//                    mSelectedUsers.remove(user);
//                }
//            }
//        });
//
//        mUserAdapter.setUserList(DummyGenerator.generateDummyUsers());
//
//        mCreateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mUsersSelectedListener.onUsersSelected(mSelectedUsers);
//            }
//        });
//
//        return rootView;
//    }
//}
