package com.example.spacelearner;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Action3.class}, version = 2)
public abstract class ActionsDatabase2 extends RoomDatabase {
    public abstract ActionDao actionDao();

    // Sample migration in case you need to migrate the database
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE 'actions3' ADD COLUMN 'maxRevisions' INTEGER NOT NULL DEFAULT 3");
        }
    };

//    static Migration migration = new Migration(1,2) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE 'actions' ADD COLUMN 'addedDate' TEXT NOT NULL DEFAULT ''");
//        }
//    };



//    static ActionsDatabase getDatabase(Context context) {
//        if (mDB == null) {
//            synchronized (ActionsDatabase.class){
//                if (mDB == null) {
//                    mDB = Room.databaseBuilder(context.getApplicationContext(),
//                            ActionsDatabase.class, DATABASE_NAME)
//                            .addMigrations(migration)
//                            .build();
//
//                }
//            }
//        }
//
//    return mDB;
//    }
}


