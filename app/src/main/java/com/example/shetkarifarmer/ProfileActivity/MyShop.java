package com.example.shetkarifarmer.ProfileActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.shetkarifarmer.Adapters.CropInformationAdapter;
import com.example.shetkarifarmer.Models.CropInformationModel;
import com.example.shetkarifarmer.R;
import com.example.shetkarifarmer.databinding.ActivityMyShopBinding;
import com.example.shetkarifarmer.fragments.Setting;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyShop extends AppCompatActivity {
    private CropInformationAdapter cropInformationAdapter;
    private ArrayList<CropInformationModel> cropInformationModelArrayList;
    private ActivityMyShopBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyShopBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.backToSettingActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Setting.class);
//                startActivity(intent);
//                finish();
//
//            }
//        });
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(
                "Vegetable").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        binding.myRecyclerView.setLayoutManager(new LinearLayoutManager(MyShop.this));
        binding.myshimmer.startShimmer();
        cropInformationModelArrayList = new ArrayList<>();
        cropInformationAdapter = new CropInformationAdapter(MyShop.this, cropInformationModelArrayList);
        binding.myRecyclerView.setAdapter(cropInformationAdapter);

        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                binding.myshimmer.stopShimmer();
                binding.myshimmer.setVisibility(View.GONE);
                binding.myRecyclerView.setVisibility(View.VISIBLE);
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    CropInformationModel cropInformationModel = dataSnapshot.getValue(CropInformationModel.class);
                    cropInformationModelArrayList.add(cropInformationModel);
                }
                cropInformationAdapter.notifyItemInserted(cropInformationModelArrayList.size() - 1);
                cropInformationAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(MyShop.this, "error" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }
}