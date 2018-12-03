package com.dicoding.crips.katalogkomik;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Request;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class detail_activity extends AppCompatActivity {
    public static String EXTRA_NAME = "extra_name";
    private TextView tvWriter, tvPrice, tvYear, tvDescription, tvUrl;
    public String name, writer, price, year, description, url;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);

        tvWriter = findViewById(R.id.text_writer);
        tvPrice = findViewById(R.id.text_price);
        tvYear = findViewById(R.id.text_year_of);
        tvDescription = findViewById(R.id.text_description);
        imageView = findViewById(R.id.img_comic);

        Intent intent = getIntent();

        //set title
        name = intent.getStringExtra(EXTRA_NAME);
        getSupportActionBar().setTitle(name);

        //get & set picture
        url = intent.getStringExtra("book_url");

        Glide.with(this)
                .load(url)
                .override(450,450)
                .into(imageView);

        //set writer
        writer = intent.getStringExtra("book_writer");
        tvWriter.setText(writer);

        //set price
        price = intent.getStringExtra("book_price");
        tvPrice.setText(price);

        //set year
        year = intent.getStringExtra("book_year");
        tvYear.setText(year);

        //set description
        description = intent.getStringExtra("book_description");
        tvDescription.setText(description);
    }
}