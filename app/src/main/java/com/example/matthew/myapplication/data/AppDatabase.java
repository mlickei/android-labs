package com.example.matthew.myapplication.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Matthew on 3/25/2018.
 */
@Database(entities = {ExampleEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ExampleEntityDAO exampleEntityDAO();
}
