package com.example.room_sqlexam;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class todo {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title ;

    public todo(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
