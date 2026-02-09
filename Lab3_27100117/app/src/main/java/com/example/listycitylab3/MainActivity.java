package com.example.listycitylab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements CityFragment.CityEditedListener {

    private ArrayList<String> dataList;
    private ListView cityList;
    private ArrayAdapter<String> cityAdapter;
    @Override
    public void onCityEdited(int position, String newCityName) {
        // Update the city name in your ArrayList
        dataList.set(position, newCityName);  // Assuming you have a City class with setName()
        // Or if still using Strings: dataList.set(position, newCityName);

        // Refresh the ListView
        cityAdapter.notifyDataSetChanged();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] cities = {
                "Edmonton", "Vancouver", "Moscow",
                "Sydney", "Berlin", "Vienna",
                "Tokyo", "Beijing", "Osaka", "New Delhi"
        };

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityList = findViewById(R.id.city_list);
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);
        cityList.setOnItemClickListener((parent,view,position,id)->{
            String selected_city = dataList.get(position);

            CityFragment fragment = CityFragment.newInstance(selected_city,position);
            fragment.setListener(this);
            fragment.show(getSupportFragmentManager(),"edit");
        });
    }
}