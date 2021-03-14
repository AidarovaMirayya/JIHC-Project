package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<String> teacherslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teacherslist = new ArrayList<>();
        teacherslist.add("Kabdushev Erdaulet");
        teacherslist.add("Myktybaev Bakytzhan");
        teacherslist.add("Yerkin Jayshibekov");
        teacherslist.add("Abylaikhan Zhussip");
        teacherslist.add("Aldiyar Sarsenbayev");
        teacherslist.add("Almaz Saulebay");
        teacherslist.add("Bakytzhan Kazangapov");
        teacherslist.add("Kalamkas Aliyeva");
        teacherslist.add("Ms.Lazzat");
        teacherslist.add("Ms.Gaziza");
        teacherslist.add("Ms.Aidana");
        teacherslist.add("Ms. Alua");
        teacherslist.add("Nevzat Bekar");
        teacherslist.add("Mr. YILDIRAY");
        teacherslist.add("Miss Shati");
        teacherslist.add("Nurmakhan Abduyev");
        teacherslist.add("Sarbasova Akmarzhan");
        teacherslist.add("Rustem Kusainov");
        teacherslist.add("Seitugali teacher");
        teacherslist.add("TalgatKulkeyev");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(teacherslist);
        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}