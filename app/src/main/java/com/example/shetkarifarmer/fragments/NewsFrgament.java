package com.example.shetkarifarmer.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shetkarifarmer.Adapters.ViewPagerAdpaters;
import com.example.shetkarifarmer.Newss.AssamiNews;
import com.example.shetkarifarmer.Newss.HindiNews;
import com.example.shetkarifarmer.Newss.MarathiNews;
import com.example.shetkarifarmer.Newss.PunjabiNews;
import com.example.shetkarifarmer.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class NewsFrgament extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public NewsFrgament() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_frgaments, container, false);
        addFragment(view);
        return view;
    }
    private void addFragment(View view) {
        tabLayout = view.findViewById(R.id.NewsLanguage);
        viewPager = view.findViewById(R.id.NewsLanguageViewPager);

        ViewPagerAdpaters adpaters = new ViewPagerAdpaters(getChildFragmentManager());
        adpaters.addFragment(new MarathiNews(),"Marathi");
        adpaters.addFragment(new HindiNews(),"Hindi");
        adpaters.addFragment(new PunjabiNews(),"Punjabi");
        adpaters.addFragment(new AssamiNews(),"Assamese");
        viewPager.setAdapter(adpaters);
        tabLayout.setupWithViewPager(viewPager);

        Objects.requireNonNull(tabLayout.getTabAt(0)).setText(R.string.Marathi);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setText(R.string.Hindi);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setText(R.string.Punjabi);
        Objects.requireNonNull(tabLayout.getTabAt(3)).setText(R.string.Assamese);
    }
}