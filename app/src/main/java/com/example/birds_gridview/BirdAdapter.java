package com.example.birds_gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BirdAdapter extends RecyclerView.Adapter<BirdViewHolder> {

    private ArrayList<Bird> birdList;
    private ItemClickListener itemClickListener;

    public BirdAdapter(ArrayList<Bird> birdArrayList, ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
        birdList = birdArrayList;
    }

    @NonNull
    @Override
    public BirdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new BirdViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BirdViewHolder holder, int position) {
        Bird bird = birdList.get(position);
        holder.setData(bird);
    }

    @Override
    public int getItemCount() {
        return birdList.size();
    }
}
