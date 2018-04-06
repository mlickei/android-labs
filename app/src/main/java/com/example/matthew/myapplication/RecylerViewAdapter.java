package com.example.matthew.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.matthew.myapplication.data.ExampleEntity;

import java.util.List;

/**
 * Created by Matthew on 4/3/2018.
 */

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.ViewHolder> {

    private List<ExampleEntity> dataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView costView;
        public ViewHolder(View view) {
            super(view);
            textView = itemView.findViewById(R.id.name);
            costView = itemView.findViewById(R.id.cost);
        }
    }

    public RecylerViewAdapter(List<ExampleEntity> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.detailed_list_view, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(dataset.get(position).getName());
        holder.costView.setText(Double.toString(dataset.get(position).getCost()));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
