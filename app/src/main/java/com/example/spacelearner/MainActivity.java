package com.example.spacelearner;

import android.content.Context;
import android.content.Intent;
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
    private SectionsPagerAdapter sectionsPagerAdapter;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        database = Room
                .databaseBuilder(getApplicationContext(), ActionsDatabase.class, "actions")
                .allowMainThreadQueries()
                .build();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                In case you need to delete the database elements for testing (uncomment following line)
//                database.actionDao().deleteAll();

                Context context = v.getContext();
                Intent intent = new Intent(v.getContext(), AddActivity.class);
                context.startActivity(intent);
//                  In case you need to delete the database elements for testing (uncomment following line)
//                  database.actionDao().deleteAll("New action");
//
//                  Before I was trying to reload from the adapter; but it has to be done from the sectionsPagerAdapter
//                  Also you need to add the function getItemPosition in sectionsPagerAdapter
//                  adapter.reload(); // NO
//                  sectionsPagerAdapter.reload(); // YES


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        sectionsPagerAdapter.reload();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        With onPause we make sure that the tab that opens after coming back from AddActivity is tab "ACTIVITY" (index 1)
        tabs.getTabAt(1).select();
    }
}