package com.example.restoran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    Menu menu;
    RecyclerView recyclerView;
    List<Menu> menuList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Menangkap bundle dari Form Activity
        String tanggal = getIntent().getExtras().getString("Tanggal");
        String jam = getIntent().getExtras().getString("Jam");
        String noMeja = getIntent().getExtras().getString("Nomor Meja");

        // Menampilkan hasil dari menangkap bundle pada fungsi diatas
        TextView tampilmeja, tampiltj;
        tampilmeja = findViewById(R.id.tampil1);
        tampiltj = findViewById(R.id.tampil2);
        tampilmeja.setText(noMeja);
        tampiltj.setText(tanggal+" "+jam);




        // khusus recycler view
        recyclerView = findViewById(R.id.rv);

        menu = new Menu("Kopi Letek", "Kopi berfaedah", 200000, R.drawable.splacesreen);
        menuList.add(menu);

        MenuAdapter menuAdapter = new MenuAdapter(menuList);
        recyclerView.setAdapter(menuAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
