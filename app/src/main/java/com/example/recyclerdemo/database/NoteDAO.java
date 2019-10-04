package com.example.recyclerdemo.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NoteDAO {

    @Insert
    void insert(Item item);

    @Query("SELECT * FROM notes")
    LiveData<List<Item>> getAllItems();
}
