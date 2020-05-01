package com.example.spacelearner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class AddActivity extends AppCompatActivity {

    String title;
    String chapterNumber;
    EditText bookName;
    EditText chapter;
    Button submitButton;
    Date now;
    Long currentDate;
    Long nextRevisionDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        bookName = (EditText) findViewById(R.id.book_name);
        chapter = (EditText) findViewById(R.id.chapter);
        submitButton = (Button) findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = bookName.getText().toString();
                chapterNumber = chapter.getText().toString();
                if (title.length() > 0 && chapterNumber.length() > 0) {
                    now = new Date();
                    currentDate = now.getTime();
                    nextRevisionDate = currentDate + 1 * 60 * 1000;
                    MainActivity.database.actionDao().create(title,chapterNumber,currentDate,0,nextRevisionDate,3);
                    finish();
                }

            }
        });

    }
}
