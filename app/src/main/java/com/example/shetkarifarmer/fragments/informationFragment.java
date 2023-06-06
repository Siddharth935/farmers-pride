package com.example.shetkarifarmer.fragments;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shetkarifarmer.Adapters.CropInformationAdapter;
import com.example.shetkarifarmer.Models.CropInformationModel;
import com.example.shetkarifarmer.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class informationFragment extends Fragment {
    private CropInformationAdapter cropInformationAdapter;
    private ArrayList<CropInformationModel> cropInformationModelArrayList;
    private ShimmerFrameLayout shimmerFrameLayout;
    private RecyclerView recyclerView;
    public informationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_information, container, false);
//        getContext().getTheme().applyStyle(R.style.Theme_ShetkariFarmer_statusBar,true);
        shimmerFrameLayout = view.findViewById(R.id.infoshimmer);
        recyclerView = view.findViewById(R.id.infoRecyclerView);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(
                "Vegetable").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        shimmerFrameLayout.startShimmer();
        cropInformationModelArrayList = new ArrayList<>();
        cropInformationAdapter = new CropInformationAdapter(getContext(), cropInformationModelArrayList);
        recyclerView.setAdapter(cropInformationAdapter);



        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    CropInformationModel cropInformationModel = dataSnapshot.getValue(CropInformationModel.class);
                    cropInformationModelArrayList.add(cropInformationModel);
                }
                cropInformationAdapter.notifyItemInserted(cropInformationModelArrayList.size() - 1);
                cropInformationAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "error" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
        return view;
    }
}