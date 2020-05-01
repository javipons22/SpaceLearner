package com.example.spacelearner;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@androidx.room.Database(entities = {Book.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {
    public abstract BookDao actionDao();

    // Sample migration in case you need to migrate the database
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE 'actions3' ADD COLUMN 'maxRevisions' INTEGER NOT NULL DEFAULT 3");
        }
    };

}


