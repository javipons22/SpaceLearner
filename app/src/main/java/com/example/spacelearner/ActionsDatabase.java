package com.example.spacelearner;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Action.class}, version = 1)
public abstract class ActionsDatabase extends RoomDatabase {
    public abstract ActionDao actionDao();
}