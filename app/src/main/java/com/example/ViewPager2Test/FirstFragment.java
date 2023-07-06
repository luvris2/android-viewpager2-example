package com.example.ViewPager2Test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FirstFragment extends Fragment {
    //private static final String ARG_POSITION = "position";
    public static final String ARG_OBJECT = "object";

    private int position;

//    public static Fragment newInstance(int position) {
//        Fragment fragment = new FirstFragment();
//        Bundle args = new Bundle();
//        args.putInt(ARG_POSITION, position);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            position = getArguments().getInt(ARG_POSITION);
//        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_first, container, false);

        return rootView;
    }
}