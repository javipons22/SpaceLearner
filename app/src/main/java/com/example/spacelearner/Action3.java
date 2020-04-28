package com.example.spacelearner;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "actions3")
public class Action3 {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "content")
    public String content;

    @ColumnInfo(name = "addedDate")
    public Long addedDate;

    @ColumnInfo(name = "nextRevision")
    public Long nextRevision;

    @ColumnInfo(name = "revisionsAmount")
    public int revisions;
}
