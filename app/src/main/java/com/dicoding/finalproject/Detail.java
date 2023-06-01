package com.dicoding.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends AppCompatActivity {
    public static final String EXTRA_PICTURE = "";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PRICE = "extra_price";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    public static final String EXTRA_LINK = "extra_link";
    private Button buy;

    private ImageView profile, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().hide();

        TextView lp_name, lp_price, lp_description;
        lp_name = findViewById(R.id.lp_name);
        lp_price = findViewById(R.id.lp_price);
        lp_description = findViewById(R.id.lp_description);
        ImageView lp_picture = findViewById(R.id.lp_picture);
        buy = findViewById(R.id.action_share);

        profile = findViewById(R.id.about_page);
        back = findViewById(R.id.arrow);

        profile.setVisibility(View.GONE);

        String picture = getIntent().getStringExtra(EXTRA_PICTURE);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String price = getIntent().getStringExtra(EXTRA_PRICE);
        String description = getIntent().getStringExtra(EXTRA_DESCRIPTION);
        String link = getIntent().getStringExtra(EXTRA_LINK);

        Integer Picture = getResources().getIdentifier(picture, "drawable", getPackageName());
        lp_picture.setImageResource(Picture);
        lp_name.setText(name);
        lp_price.setText(price);
        lp_description.setText(description);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Detail.super.onBackPressed();
                finish();
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse(link);
                intent.setData(uri);
                startActivity(intent);

            }
        });


    }
}