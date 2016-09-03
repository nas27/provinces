package com.example.nastasia.assignment2_nastasia_hyam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lstProvinces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstProvinces = (ListView)findViewById(R.id.lstProvinces);

        lstProvinces.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //get the adapter, cast to province
                MyArrayAdapter adapter = (MyArrayAdapter)parent.getAdapter();

                //get the selected province from the adapter
                Province selectedProvince = adapter.getItem(position);

                //toast to display name of province when clicked
                Toast.makeText(MainActivity.this,selectedProvince.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getProvinces(View view) {

        ArrayList<Province> provinces = Province.getProvinces(this);

        // create the ArrayAdapter
        MyArrayAdapter adapter = new MyArrayAdapter(this,R.layout.list_provinces,provinces);

        // set the drop down view
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        lstProvinces.setAdapter(adapter);

    }
}