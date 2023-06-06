package com.example.shetkarifarmer.vegitablesFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shetkarifarmer.R;
import com.example.shetkarifarmer.databinding.FragmentFruitsBinding;

public class Fruits extends Fragment {


    private FragmentFruitsBinding binding;

    public Fruits() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFruitsBinding.inflate(getLayoutInflater());

//        binding.Apple.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), Apple.class);
//                startActivity(intent);
//            }
//        });
//        binding.Coconut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), Coconut.class);
//                startActivity(intent);
//            }
//        });
//        binding.Guava.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), Guava.class);
//                startActivity(intent);
//            }
//        });
//        binding.Mango.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getContext(), Mango.class);
//                startActivity(intent);
//            }
//        });
        return binding.getRoot();
    }
}