package com.example.spacelearner;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "actions")
public class Action {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "content")
    public String content;
}
