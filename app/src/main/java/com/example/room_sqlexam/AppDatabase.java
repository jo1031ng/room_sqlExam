package com.example.room_sqlexam;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities =  {todo.class},version =  1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract todoDao todoDao();


}
