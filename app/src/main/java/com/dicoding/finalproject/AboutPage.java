package com.dicoding.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutPage extends AppCompatActivity {

    private ImageView profile, back, instagram, linkedin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        getSupportActionBar().hide();

        profile = findViewById(R.id.about_page);
        back = findViewById(R.id.arrow);
        instagram = findViewById(R.id.instagram);
        linkedin = findViewById(R.id.linkedin);

        profile.setVisibility(View.GONE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AboutPage.super.onBackPressed();
                finish();
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("https://www.instagram.com/shofwanabdulkadir/");
                intent.setData(uri);
                startActivity(intent);

            }
        });

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.linkedin.com/in/shofwan-abd-kadir-nasution-62108a1b8/");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
}