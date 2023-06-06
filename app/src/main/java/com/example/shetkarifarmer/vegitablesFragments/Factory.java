package com.example.shetkarifarmer.vegitablesFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shetkarifarmer.IndustrialActivity.SugarActivity;
import com.example.shetkarifarmer.R;
import com.example.shetkarifarmer.databinding.FragmentFactoryBinding;


public class Factory extends Fragment {

    private FragmentFactoryBinding binding;
    public Factory() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFactoryBinding.inflate(getLayoutInflater());
        binding.sugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SugarActivity.class);
                startActivity(intent);
            }
        });

       return binding.getRoot();
    }
}