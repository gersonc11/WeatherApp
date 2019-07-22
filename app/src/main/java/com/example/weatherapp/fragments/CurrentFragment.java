package com.example.weatherapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weatherapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentFragment extends Fragment {
    String currentCity;
    TextView tvCity;

    @BindView(R.id.)

    public CurrentFragment () {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        tvCity =

        View view = inflater.inflate(R.layout.current_fragment, container, false);

        ButterKnife.bind(this, view);

        return view;

    }

}
