package com.example.spacelearner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.spacelearner.ui.main.SectionsPagerAdapter;


public class MainActivity extends AppCompatActivity {
    public static ActionsDatabase2 database;
    private SectionsPagerAdapter sectionsPagerAdapter;
    private TabLayout tabs;
    private BroadcastReceiver minuteUpdateReceiver;

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
                .databaseBuilder(getApplicationContext(), ActionsDatabase2.class, "actions5")
                .allowMainThreadQueries()
//                .fallbackToDestructiveMigration()
//                .addMigrations(ActionsDatabase2.MIGRATION_1_2)
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
//                  database.actionDao().deleteAll();
//
//                  Before I was trying to reload from the adapter; but it has to be done from the sectionsPagerAdapter
//                  Also you need to add the function getItemPosition in sectionsPagerAdapter
//                  adapter.reload(); // NO
//                  sectionsPagerAdapter.reload(); // YES


            }
        });
    }

    public void startMinuteUpdater() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_TIME_TICK);
        minuteUpdateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                sectionsPagerAdapter.reload();
            }
        };

        registerReceiver(minuteUpdateReceiver, intentFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sectionsPagerAdapter.reload();
//        With onResume we make sure that the tab that opens after coming back from AddActivity is tab "ACTIVITY" (index 1)
        tabs.getTabAt(1).select();
        startMinuteUpdater();
    }

    @Override
    protected void onPause() {
        super.onPause();
//        With onPause we make sure that the tab that opens after coming back from AddActivity is tab "ACTIVITY" (index 1)
//        tabs.getTabAt(1).select();
//        deleted because we might just need this functionality in the onResume() function call
        unregisterReceiver(minuteUpdateReceiver);
    }
}