package com.example.lab2;

import static java.lang.ref.Cleaner.create;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    Button add;
    boolean delete_mode;
    Button delete_city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        delete_mode = false;
        cityList = findViewById(R.id.city_list);
        String []cities = {"multan","Bahawalpur","Dhudhi phaphra","pindh dadan Khan", "Khewra", "Rawalpindi","Islamabad","Peshawar","Abottabad","Murree","Karachi","Lahore","Sukkhur","Faisalabad"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this,R.layout.content,dataList);
        cityList.setAdapter(cityAdapter);
        add = findViewById(R.id.add_button);
        delete_city = findViewById(R.id.delete_button);
        add.setOnClickListener(v -> {

            // Create input field
            EditText input = new EditText(MainActivity.this);


            input.setSingleLine(false);

            // Build dialog
            AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                    .setTitle("New City")
                    .setMessage("Name")
                    .setView(input)
                    .setPositiveButton("sui", (dialogInterface, which) -> {

                        String tweetText = input.getText().toString().trim();
                        dataList.add(tweetText);       // Add to the ArrayList
                        cityAdapter.notifyDataSetChanged();


                    })


                    .create();

            dialog.show();
        });
        delete_city.setOnClickListener(v -> {
            delete_mode = !delete_mode;
        });

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(delete_mode){
                dataList.remove(position);


                cityAdapter.notifyDataSetChanged();
            }}
        });









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}