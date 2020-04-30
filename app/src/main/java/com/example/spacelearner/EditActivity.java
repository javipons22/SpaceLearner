package com.example.spacelearner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class EditActivity extends AppCompatActivity {
    String content;
    String previousTab;
    EditText bookName;
    EditText chapter;
    Button editButton;
    Button deleteButton;
    Button reviseButton;
    String name;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        name = getIntent().getStringExtra("name");
        id = getIntent().getIntExtra("id",0);
        previousTab = getIntent().getStringExtra("FROM_TAB");

        bookName = (EditText) findViewById(R.id.book_name);
        editButton = (Button) findViewById(R.id.button_edit);
        deleteButton = (Button) findViewById(R.id.button_delete);
        reviseButton = (Button) findViewById(R.id.button_revised);
        chapter = (EditText) findViewById(R.id.chapter);

        bookName.setText(name);
        chapter.setText(Integer.toString(id));

        if (previousTab.equals("TAB2")){
            reviseButton.setVisibility(View.GONE);
        }

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content = bookName.getText().toString();
//                if (content.length() > 0) {
//                    now = new Date();
//                    currentDate = now.getTime();
//                    nextRevisionDate = currentDate + 24 * 60 * 60 * 1000;
                    MainActivity.database.actionDao().updateValues(content,id);
                    finish();
//                }

            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.database.actionDao().delete(id);
                finish();
            }
        });
    }
}
