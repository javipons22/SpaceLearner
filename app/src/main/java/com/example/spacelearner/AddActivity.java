package com.example.spacelearner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    String content;
    EditText bookName;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        bookName = (EditText) findViewById(R.id.book_name);
        submitButton = (Button) findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content = bookName.getText().toString();
                if (content.length() > 0) {
                    MainActivity.database.actionDao().create(content);
                    finish();
                }

            }
        });

    }
}
