package com.example.recyclerdemo.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.recyclerdemo.database.Item;
import com.example.recyclerdemo.database.NoteDAO;
import com.example.recyclerdemo.database.RoomDataBase;

import java.util.List;


public class MainViewModel extends AndroidViewModel {
    private NoteDAO noteDAO;
    private RoomDataBase noteDb;
    private LiveData<List<Item>> mList;

    public MainViewModel(@NonNull Application application) {
        super(application);

        noteDb = RoomDataBase.getRoomDataBase(application);
        noteDAO = noteDb.noteDao();
        mList = noteDAO.getAllItems();
    }

   public LiveData<List<Item>> getAllItems(){
        return mList;
    }

    public void insert(Item item){
        new InsertAsyncTask(noteDAO).execute(item);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

    private class InsertAsyncTask extends AsyncTask<Item ,Void,Void>{
        NoteDAO noteDAO;

        public InsertAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Item... items) {
            noteDAO.insert(items[0]);
            return null;
        }
    }
}
