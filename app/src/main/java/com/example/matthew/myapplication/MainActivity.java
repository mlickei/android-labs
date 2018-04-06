package com.example.matthew.myapplication;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.matthew.myapplication.data.AppDatabase;
import com.example.matthew.myapplication.data.ExampleEntity;
import com.example.matthew.myapplication.viewModel.ExampleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    EditText editText;
    List<ExampleEntity> values = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;
    private ExampleViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        recyclerView = findViewById(R.id.ListView);
        // Good resource https://www.sitepoint.com/mastering-complex-lists-with-the-android-recyclerview/
        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerViewAdapter = new RecylerViewAdapter(values);
        recyclerView.setAdapter(recyclerViewAdapter);

        viewModel = ViewModelProviders.of(this).get(ExampleViewModel.class);
        viewModel.getEntities().observe(this, entities -> {
            values.addAll(entities);
            updateListView();
        });
    }

    public void addItem(View v) {
        String text = editText.getText().toString();
        ExampleEntity newEntity = new ExampleEntity();
        newEntity.setName(text);
        newEntity.setCost(values.size());
        //FIXME this inserts all again for some reason but hey whatever.
        viewModel.insertEntities(newEntity);
    }

    public void updateListView() {
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
