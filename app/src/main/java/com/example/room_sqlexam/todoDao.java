package com.example.room_sqlexam;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface todoDao {
    @Query("SELECT * FROM todo")
    LiveData<List<todo>> getAll();

    @Insert
    void insert(todo to);

    @Update
    void update(todo to);

    @Delete
    void delete(todo to);
}
