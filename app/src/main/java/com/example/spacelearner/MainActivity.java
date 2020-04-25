package com.example.spacelearner;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.spacelearner.ui.main.SectionsPagerAdapter;


public class MainActivity extends AppCompatActivity {
    public static ActionsDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        database = Room
                .databaseBuilder(getApplicationContext(), ActionsDatabase.class, "actions")
                .allowMainThreadQueries()
                .build();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.actionDao().create();

                // In case you need to delete the database elements for testing (uncomment following line)
                // database.actionDao().deleteAll("New action");

                // Before I was trying to reload from the adapter; but it has to be done from the sectionsPagerAdapter
                // Also you need to add the function getItemPosition in sectionsPagerAdapter
                //adapter.reload();
                sectionsPagerAdapter.reload();


            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//    }

}