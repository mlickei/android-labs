package com.example.matthew.myapplication.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Matthew on 3/25/2018.
 */
@Dao
public interface ExampleEntityDAO {

    @Query("SELECT * FROM entry;")
    LiveData<List<ExampleEntity>> getAll();

    @Insert
    void insertAll(ExampleEntity... entries);

    @Update
    void updateUsers(ExampleEntity... entries);

    @Delete
    void delete(ExampleEntity entry);
}
