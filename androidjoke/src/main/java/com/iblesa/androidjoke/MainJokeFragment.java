package com.iblesa.androidjoke;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainJokeFragment extends Fragment {
    public MainJokeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main_fragment, container, false);


        String stringExtra = getActivity().getIntent().getStringExtra(Constants.JOKE);
        TextView viewById = rootView.findViewById(R.id.tv_joke);
        viewById.setText(stringExtra);
        return rootView;
    }
}
