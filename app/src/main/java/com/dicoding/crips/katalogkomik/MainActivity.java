package com.dicoding.crips.katalogkomik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rvCategory;
    private ArrayList<Komik> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(DataKomik.getListData());

        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewKomikAdapter cardViewKomikAdapter = new CardViewKomikAdapter(this);
        cardViewKomikAdapter.setListKomik(list);
        rvCategory.setAdapter(cardViewKomikAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent moveWithData = new Intent(MainActivity.this, detail_activity.class);
        moveWithData.putExtra(detail_activity.EXTRA_NAME, Komik.class.getName());
        startActivity(moveWithData);
    }
}