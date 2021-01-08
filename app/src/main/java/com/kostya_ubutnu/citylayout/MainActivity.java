package com.kostya_ubutnu.citylayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kostya_ubutnu.citylayout.models.Model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Model> list;
    private Adapter adapter;

    private BottomNavigationView bottomBar;
    private ImageView addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recView);
        bottomBar = findViewById(R.id.bottom_bar);
        addBtn = findViewById(R.id.action_add);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Была нажата кнопка Добавить", Toast.LENGTH_SHORT).show();
            }
        });

        bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                switch (id){

                    case R.id.news:
                        Toast.makeText(MainActivity.this, "Пункт новости", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.main:
                        Toast.makeText(MainActivity.this, "Пункт Основное", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.profile:
                        Toast.makeText(MainActivity.this, "Пункт Профиль", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });

        list = new ArrayList<>();
        list.add(new Model(R.drawable.ic_launcher_foreground,getResources().getString(R.string.main_tv_text),getResources().getString(R.string.data_tv),getResources().getString(R.string.time_tv)));
        list.add(new Model(R.drawable.ic_launcher_foreground,getResources().getString(R.string.main_tv_text),getResources().getString(R.string.data_tv),getResources().getString(R.string.time_tv)));
        adapter = new Adapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
