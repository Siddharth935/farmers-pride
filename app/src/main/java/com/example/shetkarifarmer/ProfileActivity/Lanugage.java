package com.example.shetkarifarmer.ProfileActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.example.shetkarifarmer.R;
import com.example.shetkarifarmer.databinding.ActivityLanugageBinding;

import java.util.Locale;

public class Lanugage extends AppCompatActivity {

    private ActivityLanugageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLanugageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadLocale();

        binding.English.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocal(" ");
                recreate();
            }
        });
        binding.Marathi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocal("mr");
                recreate();
            }
        });
        binding.Hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocal("hi");
                recreate();
            }
        });
        binding.Assamese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocal("as");
                recreate();
            }
        }); binding.Punjab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLocal("pa");
                recreate();
            }
        });
    }

    private void setLocal(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getBaseContext().getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("app_lang", language);
        editor.apply();
    }

    private void loadLocale() {
        SharedPreferences preferences = getBaseContext().getSharedPreferences("Settings", MODE_PRIVATE);
        String language = preferences.getString("app_lang", "");
        setLocal(language);
    }
}