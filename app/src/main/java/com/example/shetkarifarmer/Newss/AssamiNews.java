package com.example.shetkarifarmer.Newss;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shetkarifarmer.Adapters.NewsAdapter;
import com.example.shetkarifarmer.Models.NewsModel;
import com.example.shetkarifarmer.R;
import com.example.shetkarifarmer.databinding.FragmentAssamiNewsBinding;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AssamiNews extends Fragment {

    private FragmentAssamiNewsBinding binding;
    private DatabaseReference reference;
    private NewsAdapter newsAdapter;
    private ArrayList<NewsModel> list;

    public AssamiNews() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAssamiNewsBinding.inflate(getLayoutInflater());


//        progressBar = view.findViewById(R.id.marathiNewsProgress);
        reference = FirebaseDatabase.getInstance().getReference("AssamiNews");
        binding.NewsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.shimmer.startShimmer();

        list = new ArrayList<>();
        newsAdapter = new NewsAdapter(getContext(), list);
        binding.NewsRecycler.setAdapter(newsAdapter);

        reference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                binding.shimmer.stopShimmer();
                binding.shimmer.setVisibility(View.GONE);
                binding.NewsRecycler.setVisibility(View.VISIBLE);
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    NewsModel newsModel = dataSnapshot.getValue(NewsModel.class);
                    list.add(newsModel);
                }
                newsAdapter.notifyItemInserted(list.size() - 1);
                newsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "error" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
        return  binding.getRoot();
    }
}