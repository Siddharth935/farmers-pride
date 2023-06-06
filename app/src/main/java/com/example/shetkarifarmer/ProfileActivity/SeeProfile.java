package com.example.shetkarifarmer.ProfileActivity;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.shetkarifarmer.databinding.ActivitySeeProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SeeProfile extends AppCompatActivity {

    private ActivitySeeProfileBinding binding;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeeProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        profile();
        binding.Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeeProfile.this, EditProfile.class);
                startActivity(intent);
            }
        });
    }

    private void profile() {

        reference = FirebaseDatabase.getInstance().getReference("UserProfile").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    binding.profileProgress.setVisibility(View.GONE);
                    String getfarmerName = snapshot.child("farmerName").getValue().toString();
                    binding.farmerName.setText(getfarmerName);
                    String profileImage = snapshot.child("getUserImage").getValue().toString();
                    Glide.with(getApplicationContext()).load(profileImage).into(binding.getCustomerProfileImage);
                    String getfarmerMobileNumber = snapshot.child("farmerMobileNumber").getValue().toString();
                    binding.farmerMobileNumber.setText(getfarmerMobileNumber);
                    String getfarmerMobileNumberTwo = snapshot.child("farmerMobileNumberTwo").getValue().toString();
                    binding.farmerMobileNumberTwo.setText(getfarmerMobileNumberTwo);
                    String getfarmerEmail = snapshot.child("farmerEmail").getValue().toString();
                    binding.farmerEmail.setText(getfarmerEmail);
                    String getSatbaraNo = snapshot.child("satBaraNo").getValue().toString();
                    binding.satBaraNo.setText(getSatbaraNo);

                    String getPincode = snapshot.child("pincode").getValue().toString();
                    binding.PinCode.setText(getPincode);
                    String getState = snapshot.child("state").getValue().toString();
                    binding.State.setText(getState);
                    String getCity = snapshot.child("city").getValue().toString();
                    binding.City.setText(getCity);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}