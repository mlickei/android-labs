package com.example.matthew.myapplication.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;

import com.example.matthew.myapplication.data.AppDatabase;
import com.example.matthew.myapplication.data.ExampleEntity;

import java.util.List;

/**
 * Created by Matthew on 4/5/2018.
 */

public class ExampleViewModel extends AndroidViewModel {

    private LiveData<List<ExampleEntity>> entities;
    private AppDatabase appDatabase;

    public ExampleViewModel(Application application) {
        super(application);

        appDatabase = Room.databaseBuilder(application.getApplicationContext(), AppDatabase.class, "example-db").build();
        entities = appDatabase.exampleEntityDAO().getAll();
    }

    public LiveData<List<ExampleEntity>> getEntities() {
        return entities;
    }

    public void insertEntities(ExampleEntity... entities) {
        new AddAsyncTask(appDatabase).execute(entities);
    }

    private static class AddAsyncTask extends AsyncTask<ExampleEntity, Void, Void> {

        private AppDatabase appDatabase;

        AddAsyncTask(AppDatabase appDatabase) {
            this.appDatabase = appDatabase;
        }

        @Override
        protected Void doInBackground(ExampleEntity... entities) {
            appDatabase.exampleEntityDAO().insertAll(entities);
            return null;
        }
    }
}
