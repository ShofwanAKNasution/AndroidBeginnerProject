package com.dicoding.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvLaptop;
    private ArrayList<Laptop> list = new ArrayList<>();
    private Context context;
    private ImageView profil, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        profil = findViewById(R.id.about_page);
        back = findViewById(R.id.arrow);

        back.setVisibility(View.GONE);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutPage.class);
                startActivity(intent);
            }
        });

        context = getApplicationContext();

        rvLaptop = findViewById(R.id.rv_lptp);
        rvLaptop.setHasFixedSize(true);

        list.addAll(getListHeroes());
        showRecycleList();

    }

    private void showRecycleList() {
        rvLaptop.setLayoutManager(new LinearLayoutManager(this));
        ListAdapter listAdapter = new ListAdapter(context, list);
        rvLaptop.setAdapter(listAdapter);
    }

    public  ArrayList<Laptop>getListHeroes(){
        String[] Name = getResources().getStringArray(R.array.data_name);
        String[] Price = getResources().getStringArray(R.array.data_price);
        String[] Description = getResources().getStringArray(R.array.data_description);
        String[] Link = getResources().getStringArray(R.array.link);
        TypedArray Picture = getResources().obtainTypedArray(R.array.data_picture);

        ArrayList<Laptop> listLaptop = new ArrayList<>();
        for (int i = 0; i < Name.length; i++) {
            Laptop laptop = new Laptop();
            laptop.setName(Name[i]);
            laptop.setPrice(Price[i]);
            laptop.setSpecification(Description[i]);
            laptop.setLink(Link[i]);
            laptop.setPicture(Picture.getResourceId(i, -1));
            listLaptop.add(laptop);
        }
        return listLaptop;

    }
}