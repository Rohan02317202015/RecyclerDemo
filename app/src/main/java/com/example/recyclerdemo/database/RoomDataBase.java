package com.example.recyclerdemo.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = Item.class,version = 1)
public abstract class RoomDataBase extends RoomDatabase {

    public abstract NoteDAO noteDao();

    private static volatile RoomDataBase roomDataBaseInstance;

    public static RoomDataBase getRoomDataBase(final Context con){
        if(roomDataBaseInstance == null){
            synchronized (RoomDataBase.class){
                if(roomDataBaseInstance == null){
                    roomDataBaseInstance = Room.databaseBuilder(con.getApplicationContext(),
                            RoomDataBase.class,"demo_database")
                            .build();
                }
            }
        }
        return roomDataBaseInstance;
    }
}
