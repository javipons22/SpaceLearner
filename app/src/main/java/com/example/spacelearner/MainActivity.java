package com.example.spacelearner;

import android.content.Intent;
import android.os.Bundle;

import com.example.spacelearner.adapters.ActivityAdapter;
import com.example.spacelearner.adapters.TodoAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.spacelearner.ui.main.SectionsPagerAdapter;

import java.security.AccessController;

public class MainActivity extends AppCompatActivity {
    public static ActionsDatabase database;
    private ActivityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        adapter = new ActivityAdapter();

        database = Room
                .databaseBuilder(getApplicationContext(), ActionsDatabase.class, "actions")
                .allowMainThreadQueries()
                .build();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.actionDao().create();
                adapter.reload();
            }
        });
    }
}