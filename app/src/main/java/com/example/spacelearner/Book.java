package com.example.spacelearner;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "books")
public class Book {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "chapter")
    public String chapter;

    @ColumnInfo(name = "addedDate")
    public Long addedDate;

    @ColumnInfo(name = "nextRevision")
    public Long nextRevision;

    @ColumnInfo(name = "revisionsAmount")
    public int revisions;

    @ColumnInfo(name = "maxRevisions")
    public int maxRevisions;
}
