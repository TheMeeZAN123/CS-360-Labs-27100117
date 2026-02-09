package com.example.listycitylab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class CityFragment extends DialogFragment {
    public interface CityEditedListener{
        void onCityEdited(int position,String new_name);
    }

    public void setListener(CityEditedListener listener) {
        this.listener = listener;
    }

    private static final String ARG_CITY_NAME = "city_name";
    private static final String ARG_POS = "position";


    private String cityName;
    private int position;
    private CityEditedListener listener;


    // Factory method to create a new instance with arguments
    public static CityFragment newInstance(String cityName, int position) {
        CityFragment fragment = new CityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CITY_NAME, cityName);
        args.putInt(ARG_POS,position);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve the arguments passed to this fragment
        if (getArguments() != null) {
            cityName = getArguments().getString(ARG_CITY_NAME);
            position = getArguments().getInt(ARG_POS);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_city, container, false);

        // Find views and set data





        EditText edit = view.findViewById(R.id.edit_city_name);
        edit.setText(cityName);
        Button saveButton = view.findViewById(R.id.button_save);
        Button cancel=  view.findViewById(R.id.button_cancel);
        saveButton.setOnClickListener(v -> {
            String newCityName = edit.getText().toString();
            if (listener != null) {
                listener.onCityEdited(position, newCityName);  // Call the interface method
            }
            dismiss();  // Close the dialog
        });
        cancel.setOnClickListener(v -> {
            dismiss();
        });
        return view;
    }
}