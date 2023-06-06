package com.example.shetkarifarmer.fragments;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shetkarifarmer.Adapters.ViewPagerAdpaters;
import com.example.shetkarifarmer.ProfileActivity.SeeProfile;
import com.example.shetkarifarmer.R;
import com.example.shetkarifarmer.vegitablesFragments.Factory;
import com.example.shetkarifarmer.vegitablesFragments.Fruits;
import com.example.shetkarifarmer.vegitablesFragments.Vegetable;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class HomeFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DatabaseReference reference;
    private TextView Name, mobileNo, HI;
    private ImageView profileIMage;
    private LinearLayout btnhide, btnshow;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Name = view.findViewById(R.id.Name);
        profileIMage = view.findViewById(R.id.profileImageView);
        mobileNo = view.findViewById(R.id.farmerMobileNumber);
//        HI = view.findViewById(R.id.hiiiii);
        btnhide = view.findViewById(R.id.Hii);
        btnshow = view.findViewById(R.id.showLayout);

        btnhide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int isvisible = btnshow.getVisibility();
                if (isvisible == View.VISIBLE) {
                    btnshow.setVisibility(View.GONE);
//                    HI.setText("Hiiii");
                } else {
//                    HI.setText("Bye");
                    btnshow.setVisibility(View.VISIBLE);
                }
            }
        });
        Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int isvisible = btnshow.getVisibility();
                if (isvisible == View.VISIBLE) {
                    btnshow.setVisibility(View.GONE);
//                    HI.setText("Hiiii");
                } else {
//                    HI.setText("Bye");
                    btnshow.setVisibility(View.VISIBLE);
                }
            }
        });

        profileIMage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int isvisible = btnshow.getVisibility();
                if (isvisible == View.VISIBLE) {
                    btnshow.setVisibility(View.GONE);
//                    HI.setText("Hiiii");
                } else {
//                    HI.setText("Bye");
                    btnshow.setVisibility(View.VISIBLE);
                }
            }
        });
        getProfile();
        addFragment(view);
        return view;
    }

    private void getProfile() {
        reference = FirebaseDatabase.getInstance().getReference("UserProfile").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
//                    String getCity = snapshot.child("city").getValue().toString();
//                    binding.City.setText(getCity);
                    String getfarmerName = snapshot.child("farmerName").getValue().toString();
                    Name.setText(getfarmerName);
                    String profileImage = snapshot.child("getUserImage").getValue().toString();
                    Glide.with(getApplicationContext()).load(profileImage).into(profileIMage);
                    String getfarmerMobileNumber = snapshot.child("farmerMobileNumber").getValue().toString();
                    mobileNo.setText(getfarmerMobileNumber);
//                    String getfarmerMobileNumberTwo = snapshot.child("farmerMobileNumberTwo").getValue().toString();
//                    binding.farmerMobileNumberTwo.setText(getfarmerMobileNumberTwo);
//                    String getfarmerEmail = snapshot.child("farmerEmail").getValue().toString();
//                    binding.farmerEmail.setText(getfarmerEmail);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void addFragment(View view) {
        tabLayout = view.findViewById(R.id.Categories);
        viewPager = view.findViewById(R.id.viewpager2);

        ViewPagerAdpaters adpaters = new ViewPagerAdpaters(getChildFragmentManager());
        adpaters.addFragment(new Vegetable(), "Vegetable");
        adpaters.addFragment(new Fruits(), "Fruits");
        adpaters.addFragment(new Factory(), "Factory");
        viewPager.setAdapter(adpaters);
        tabLayout.setupWithViewPager(viewPager);


        Objects.requireNonNull(tabLayout.getTabAt(0)).setText(R.string.Vegetable).setIcon(R.drawable.vegetable);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setText(R.string.Fruits).setIcon(R.drawable.fruits);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setText(R.string.Factory).setIcon(R.drawable.factory);
//        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager){
//            @Override
//            public void onTabSelected(@NonNull TabLayout.Tab tab) {
//                super.onTabSelected(tab);
//                int tabIconColor = ContextCompat.getColor(requireContext(), R.color.black);
//                Objects.requireNonNull(tab.getIcon()).setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
//            }
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                super.onTabUnselected(tab);
//                int tabIconColor = ContextCompat.getColor(requireContext(), R.color.white);
//                Objects.requireNonNull(tab.getIcon()).setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//                super.onTabReselected(tab);
//            }
//        });
    }
}