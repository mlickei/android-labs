package com.example.matthew.myapplication;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.matthew.myapplication.data.AppDatabase;
import com.example.matthew.myapplication.data.ExampleEntity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    EditText editText;
    List<ExampleEntity> values = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        recyclerView = findViewById(R.id.constrained_list_view);

        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerViewAdapter = new RecylerViewAdapter(values);
        recyclerView.setAdapter(recyclerViewAdapter);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "example-db").build();
    }

    public void addItem(View v) {
        String text = editText.getText().toString();
        ExampleEntity newEntity = new ExampleEntity();
        newEntity.setName(text);
        values.add(newEntity);
        updateListView();
    }

    public void updateListView() {
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
