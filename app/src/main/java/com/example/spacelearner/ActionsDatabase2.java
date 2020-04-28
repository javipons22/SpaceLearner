package com.example.spacelearner;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Action3.class}, version = 1)
public abstract class ActionsDatabase2 extends RoomDatabase {
    public abstract ActionDao actionDao();

//    static Migration migration = new Migration(1,2) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE 'actions' ADD COLUMN 'addedDate' TEXT NOT NULL DEFAULT ''");
//        }
//    };
//
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