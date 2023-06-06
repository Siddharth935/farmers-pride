package com.example.shetkarifarmer.vegitablesFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shetkarifarmer.CropActivity.Corn;
import com.example.shetkarifarmer.CropActivity.Ginger;
import com.example.shetkarifarmer.CropActivity.Onion;
import com.example.shetkarifarmer.CropActivity.Peanut;
import com.example.shetkarifarmer.CropActivity.Potato;
import com.example.shetkarifarmer.CropActivity.Rice;
import com.example.shetkarifarmer.R;
import com.example.shetkarifarmer.databinding.FragmentVegetableBinding;

public class Vegetable extends Fragment {


    private FragmentVegetableBinding binding;

    public Vegetable() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVegetableBinding.inflate(getLayoutInflater());

        binding.potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Potato.class);
                startActivity(intent);

            }
        });
        binding.Corn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), Corn.class);
                startActivity(intent);

            }
        });
        binding.Onion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Onion.class);
                startActivity(intent);

            }
        });
        binding.Peanut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Peanut.class);
                startActivity(intent);

            }
        });
        binding.Rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Rice.class);
                startActivity(intent);

            }
        });
        binding.Ginger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), Ginger.class);
                startActivity(intent);

            }
        });
        return binding.getRoot();
    }
}