package com.example.shetkarifarmer.IndustrialActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.shetkarifarmer.R;
import com.example.shetkarifarmer.databinding.ActivitySugarBinding;

public class SugarActivity extends AppCompatActivity {

    private ActivitySugarBinding binding;
    private String selectState, selectSugarFactory;
    private Spinner stateSpineer, sugarFactriesSpinner;
    private ArrayAdapter<CharSequence> stateAdapter, sugarFactoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySugarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        stateSpineer = findViewById(R.id.indianState);

        stateAdapter = ArrayAdapter.createFromResource(this, R.array.array_indian_states, R.layout.spinner_layout);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpineer.setAdapter(stateAdapter);

        stateSpineer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sugarFactriesSpinner = findViewById(R.id.indianSugarFactories);
                selectState = stateSpineer.getSelectedItem().toString();
                int parentID = parent.getId();
                if (parentID == R.id.indianState) {
                    switch (selectState) {
                        case "Select Your State":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                    R.array.array_default_state, R.layout.spinner_layout);
                            break;
                        case "Andhra Pradesh":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
                            break;
                        case "Arunachal Pradesh":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_arunachal_pradesh_districts, R.layout.spinner_layout);
                            break;
                        case "Assam":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_assam_districts, R.layout.spinner_layout);
                            break;
                        case "Bihar":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_bihar_districts, R.layout.spinner_layout);
                            break;
                        case "Chandigarh":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_chandigarh_districts, R.layout.spinner_layout);
                            break;
                        case "Chhattisgarh":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_chhattisgarh_districts, R.layout.spinner_layout);
                            break;
                        case "Dadra and Nagar Haveli":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_dadra_nagar_haveli_districts, R.layout.spinner_layout);
                            break;
//                        case "Daman and Diu":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
//                        case "Delhi":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
                        case "Goa":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_goa_districts, R.layout.spinner_layout);
                            break;
                        case "Gujarat":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_gujarat_districts, R.layout.spinner_layout);
                            break;
                        case "Haryana":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_haryana_districts, R.layout.spinner_layout);
                            break;
//                        case "Himachal Pradesh":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
//                        case "Jammu and Kashmir":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
//                        case "Jharkhand":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
                        case "Karnataka":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_karnataka_districts, R.layout.spinner_layout);
                            break;
                        case "Kerala":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_kerala_districts, R.layout.spinner_layout);
                            break;
//                        case "Ladakh":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
//                        case "Lakshadweep":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
                        case "Madhya Pradesh":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_madhya_pradesh_districts, R.layout.spinner_layout);
                            break;
                        case "Maharashtra":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_maharashtra_districts, R.layout.spinner_layout);
                            break;
//                        case "Manipur":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
//                        case "Meghalaya":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
//                        case "Mizoram":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
                        case "Nagaland":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_nagaland_districts, R.layout.spinner_layout);
                            break;
                        case "Orissa":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_odisha_districts, R.layout.spinner_layout);
                            break;
                        case "Puducherry":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_puducherry_districts, R.layout.spinner_layout);
                            break;
                        case "Punjab":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_punjab_districts, R.layout.spinner_layout);
                            break;
                        case "Rajasthan":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_rajasthan_districts, R.layout.spinner_layout);
                            break;
//                        case "Sikkim":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
                        case "Tamil Nadu":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_tamil_nadu_districts, R.layout.spinner_layout);
                            break;
//                        case "Telangana":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
//                        case "Tripura":
//                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_andhra_pradesh_districts, R.layout.spinner_layout);
//                            break;
                        case "Uttarakhand":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_uttarakhand_districts, R.layout.spinner_layout);
                            break;
                        case "Uttar Pradesh":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_uttar_pradesh_districts, R.layout.spinner_layout);
                            break;
                        case "West Bengal":
                            sugarFactoryAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.array_west_bengal_districts, R.layout.spinner_layout);
                            break;
                        default:
                            break;
                    }
                    sugarFactoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sugarFactriesSpinner.setAdapter(sugarFactoryAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}