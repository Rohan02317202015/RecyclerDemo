package com.example.recyclerdemo.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "notes")
public class Item{

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name = "note" )
    public String mNote;

    public Item(@NonNull String id, @NonNull String note) {
        this.id = id;
        this.mNote = note;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getmNote() {
        return mNote;
    }

    public void setmNote(@NonNull String note) {
        this.mNote = note;
    }
}
