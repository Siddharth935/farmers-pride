package com.example.shetkarifarmer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.example.shetkarifarmer.databinding.ActivitySelectLanguageBinding;

import java.util.Locale;

public class SelectLanguage extends AppCompatActivity {

    private ActivitySelectLanguageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadLocale();

        binding.language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage();
            }
        });

        binding.languagenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectLanguage.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        String FirstTime = sharedPreferences.getString("FirstTimeInstall", "");
        if (FirstTime.equals("Yes")) {
            Intent intent = new Intent(SelectLanguage.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("FirstTimeInstall", "Yes");
            editor.apply();
        }
    }

    private void changeLanguage() {
        final String[] language = {"English", "मराठी", "हिन्दी", "ਪੰਜਾਬੀ", "অসমীয়া"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mBuilder.setTitle("Select Your Language");
        mBuilder.setSingleChoiceItems(language, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    setLocal("");
                    recreate();
                } else if (i == 1) {
                    setLocal("mr");
                    recreate();
                } else if (i == 2) {
                    setLocal("hi");
                    recreate();
                } else if (i == 3) {
                    setLocal("pa");
                    recreate();
                } else if (i == 4) {
                    setLocal("as");
                    recreate();
                }
            }
        });
        mBuilder.create();
        mBuilder.show();
    }

    private void setLocal(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("app_lang", language);
        editor.apply();
    }

    private void loadLocale() {
        SharedPreferences preferences = getSharedPreferences("Settings", MODE_PRIVATE);
        String language = preferences.getString("app_lang", "");
        setLocal(language);
    }
}